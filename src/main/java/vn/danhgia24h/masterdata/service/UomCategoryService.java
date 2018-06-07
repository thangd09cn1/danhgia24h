package vn.danhgia24h.masterdata.service;

import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.core.errors.BadRequestAlertException;
import vn.danhgia24h.masterdata.models.UomCategory;
import org.springframework.stereotype.Service;
import vn.danhgia24h.masterdata.repositories.UomCategoryRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UomCategoryService  extends CrudService<UomCategory,Long> {

    private UomCategoryRepository uomCategoryRepository;

    public UomCategoryService(UomCategoryRepository repository) {
        this.repository = this.uomCategoryRepository = repository;
    }

    @Override
    protected void beforeCreate(UomCategory entity) {
        super.beforeCreate(entity);

        if(this.uomCategoryRepository.findByName(entity.getName()) != null) {
            throw new BadRequestAlertException("Duplicate UOM category name","uomCategory","nameExist");
        }

    }

    @Override
    protected void beforeUpdate(UomCategory entity) {
        super.beforeUpdate(entity);

        UomCategory uomCategory = this.uomCategoryRepository.findByName(entity.getName());
        if(uomCategory != null && !uomCategory.getId().equals(entity.getId())) {
            throw new BadRequestAlertException("Duplicate UOM category name","uomCategory","nameExist");
        }

    }

    public List<Map<String,Object>> builCategoryTree() {
        Map<Long, List<Map<String,Object>>> mapTree = new HashMap<>();
        List<Long> childList = new LinkedList<>();
        List<UomCategory> categories = this.repository.findAll();
        Map<Long,Map<String,Object>> tmp = new HashMap<>();
        for (UomCategory c : categories){
            Map<String,Object> child=new HashMap<>();
            child.put("parentId", c.getParentId());
            child.put("title", c.getName());
            child.put("key", c.getId());
            child.put("folder", true);
            if(c.getParentId() == null){
                child.put("expanded",true);
            }
            tmp.put(c.getId(),child);
            if (!childList.contains(c.getParentId())){
                childList.add(c.getParentId());
                List<Map<String,Object>> os = new LinkedList<>();
                os.add(child);
                mapTree.put(c.getParentId(),os);
            } else {
                mapTree.get(c.getParentId()).add(child);
            }

        }
        List<Map<String,Object>> root = new LinkedList<>();
        for (Long l: childList){
            if(l == null){
                root = mapTree.get(l);
            } else {
                Map<String,Object> parent = tmp.get(l);
                if (parent !=null){
                    parent.put("children",mapTree.get(l));
                } else {
                    System.out.println(l);
                }
            }
        }
        return root;
    }

}
