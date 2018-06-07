package vn.danhgia24h.masterdata.service;

import org.springframework.stereotype.Service;
import vn.danhgia24h.core.CrudService;
import vn.danhgia24h.masterdata.models.Comment;
import vn.danhgia24h.masterdata.repositories.CommentRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentService extends CrudService<Comment,Long> {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository repository) {
        this.repository = this.commentRepository = repository;
    }

}
