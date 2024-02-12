package ru.paklulin.eshop_eureka_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.paklulin.eshop_eureka_service.models.Comment;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments/")
public class CommentsController {
    private final CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/item")
    public Comment findComment(@RequestBody Item item) {
        return commentService.findByItem(item);
    }
    @GetMapping("/{id}")
    public Comment findCommentByItem(@PathVariable("id") int id) {
        return commentService.findById(id);
    }

    @PostMapping()
    public Comment postComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }


    @PutMapping("/{id}")
    public Comment editComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        commentService.delete(id);
    }

}
