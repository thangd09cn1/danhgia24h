package vn.danhgia24h.core;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import vn.danhgia24h.core.errors.UnauthorizedExpcetion;
import vn.danhgia24h.core.rsql.CustomRsqlVisitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import vn.danhgia24h.umgr.utils.SecurityUtils;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by quocvi3t on 11/14/17.
 */
public class CrudService<T extends AbstractEntity, ID extends Serializable> {

    protected CustomJpaRepository<T,ID> repository;

    public T get(ID id) {
        return repository.findOne(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<T> search(String query) {
        if(StringUtils.isEmpty(query)){
            return repository.findAll();
        }
        Node rootNode = new RSQLParser().parse(query);
        Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<T>());
        return repository.findAll(spec);
    }

    public Page<T> search(String query, Pageable pageable) {
        if(StringUtils.isEmpty(query)){
            return repository.findAll(pageable);
        }
        Node rootNode = new RSQLParser().parse(query);
        Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<T>());
        return repository.findAll(spec, pageable);
    }

    public T create(T entity) {
        beforeCreate(entity);
        repository.save(entity);
        afterCreate(entity);
        return entity;
    }

    public void update(ID id, T entity) {
        beforeUpdate(entity);
        T old = get(id);
        if(old == null) {
            throw new EntityNotFoundException("No entity with id " + id);

        }
        repository.save(entity);
        afterUpdate(old,entity);
    }

    public void delete(T entity) {
        beforeDelete(entity);
        repository.delete(entity);
        afterDelete(entity);
    }

    public void deleteById(ID id) {
        T entity = get(id);
        delete(entity);
    }

    public Long count() {
        return repository.count();
    }

    public void batchDelete(List<T> ids) {
        this.repository.deleteInBatch(ids);
    }

    protected void beforeCreate(T entity) {
        entity.setCreated(System.currentTimeMillis());
        entity.setUpdated(System.currentTimeMillis());
        String currentUsername = SecurityUtils.getCurrentUserLogin();
        entity.setCreatedBy(currentUsername == null ? "system" : currentUsername);
        if(entity.getActive() == null) {
            entity.setActive(1);
        }
    }

    protected void afterCreate(T entity) {

    }

    protected void beforeUpdate(T entity) {
        entity.setUpdated(System.currentTimeMillis());
        entity.setUpdatedBy(SecurityUtils.getCurrentUserLogin());
        if(entity.getActive() == null) {
            entity.setActive(1);
        }
    }

    protected void afterUpdate(T old, T updated) {

    }

    protected void beforeDelete(T entity) {
        if(entity.getCreatedBy() == null || "system".equals(entity.getCreatedBy())) {
            //can not delete a system object
            throw new UnauthorizedExpcetion("canNotDeleteSystemObject");
        }
    }

    protected void afterDelete(T entity) {

    }


}
