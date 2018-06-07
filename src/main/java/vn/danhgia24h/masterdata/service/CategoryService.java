package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.core.errors.BadRequestAlertException;
import vn.danhgia24h.masterdata.models.Category;
import vn.danhgia24h.masterdata.repositories.CategoryRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryService extends CrudService<Category,Long>{
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void beforeCreate(Category entity) {
        super.beforeCreate(entity);
        Category parent = get(entity.getParentId());
        if(parent == null) {
            throw new BadRequestAlertException("No parent category with id " + entity.getId(), "product.category.parent.notfound");
        }
    }

    public List<Map<String,Object>> builCategoryTree() {
        Map<Long, List<Map<String,Object>>> mapTree = new HashMap<>();
        List<Long> childList = new LinkedList<>();
        List<Category> categories = this.repository.findAll();
        Map<Long,Map<String,Object>> tmp = new HashMap<>();
        for (Category c : categories){
            Map<String,Object> child=new HashMap<>();
                child.put("parentId", c.getParentId());
                child.put("title", c.getName());
                child.put("key", c.getId());
                child.put("folder", true);
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
        List<Map<String,Object>> finalTree = new LinkedList<>();
        Map<String,Object> finalNode = new HashMap<>();
        finalNode.put("title","All products");
        finalNode.put("key","0");
        finalNode.put("folder", true);
        finalNode.put("expanded",true);
        finalNode.put("children",root);
        finalTree.add(finalNode);
//        System.out.println(finalNode);
        return finalTree;
    }
}
