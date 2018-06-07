package vn.danhgia24h.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.danhgia24h.core.utils.PaginationUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by quocvi3t on 11/14/17.
 */
public abstract class CrudApiEndpoint<T extends AbstractEntity, ID extends Serializable> {

    private static Logger logger = LoggerFactory.getLogger(CrudApiEndpoint.class);

    protected CrudService<T,ID> service;

    protected String baseUrl;

    public CrudApiEndpoint(CrudService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<T>> list(Pageable pageable) {
        Page<T> page = service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,baseUrl);
        return new ResponseEntity<>(page.getContent(),headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") ID id, @RequestBody T entity) {
        service.update(id,entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") ID id) {
        service.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public T get(@PathVariable(value = "id") ID id) {
        return service.get(id);
    }

    @RequestMapping(path="/search", method = RequestMethod.GET)
    public ResponseEntity<List<T>>  get(@RequestParam("query") String query, Pageable pageable) {
        Page<T> page = service.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,baseUrl);
        return new ResponseEntity<>(page.getContent(),headers, HttpStatus.OK);
    }

    @RequestMapping(path="/batch-delete", method = RequestMethod.POST)
    public Set<ID> batch_delete(@RequestBody Set<ID> listIDs) {
        Set<ID> fail = new HashSet<>();
        for(ID id : listIDs) {
            try {
                service.deleteById(id);
            } catch (Exception e) {
                logger.debug("Cannot delete object with id #{}, baseUrl: {}",id,this.baseUrl);
                fail.add(id);
            }
        }
        return fail;
    }

    @RequestMapping(path="/activate", method = RequestMethod.POST)
    public void activate(@RequestBody Set<ID> listIDs) {
        for(ID id : listIDs) {
            try {
                T t = service.get(id);
                t.setActive(true);
                service.update(id, t);
            } catch (Exception e) {
                logger.debug("Cannot update active object with id #{}, baseUrl: {}",id,this.baseUrl);
            }
        }
    }

    @RequestMapping(path="/deactivate", method = RequestMethod.POST)
    public void deactivate(@RequestBody Set<ID> listIDs) {
        for(ID id : listIDs) {
            try {
                T t = service.get(id);
                t.setActive(false);
                service.update(id, t);
            } catch (Exception e) {
                logger.debug("Cannot update deactive object with id #{}, baseUrl: {}",id,this.baseUrl);
            }
        }
    }


}
