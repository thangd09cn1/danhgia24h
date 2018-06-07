package vn.danhgia24h.masterdata.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.danhgia24h.core.CrudApiEndpoint;
import vn.danhgia24h.masterdata.models.Comment;
import vn.danhgia24h.masterdata.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentEndpoint extends CrudApiEndpoint<Comment,Long> {

    private CommentService commentService;

    @Autowired
    public CommentEndpoint(CommentService service) {
        super(service);
        this.commentService = service;
        this.baseUrl = "/api/comments";
    }

}
