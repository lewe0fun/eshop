package ru.paklulin.eshop_eureka_service.controllers;

import io.micrometer.core.instrument.MeterRegistry;
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
    private final MeterRegistry meterRegistry;

    @Autowired
    public CommentsController(CommentService commentService, MeterRegistry meterRegistry) {
        this.commentService = commentService;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping()
    public List<Comment> getAllComments() {
        meterRegistry.counter("getAllComments").increment();
        return commentService.findAll();
    }

    @GetMapping("/item")
    public Comment findComment(@RequestBody Item item) {
        meterRegistry.counter("findComment").increment();
        return commentService.findByItem(item);
    }
    @GetMapping("/{id}")
    public Comment findCommentByItem(@PathVariable("id") int id) {
        meterRegistry.counter("findCommentByItem").increment();
        return commentService.findById(id);
    }

    @PostMapping()
    public Comment postComment(@RequestBody Comment comment) {
        meterRegistry.counter("postComment").increment();
        return commentService.save(comment);
    }


    @PutMapping("/{id}")
    public Comment editComment(@PathVariable("id") int id, @RequestBody Comment comment) {
        meterRegistry.counter("editComment").increment();
        return commentService.update(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        meterRegistry.counter("deleteComment").increment();
        commentService.delete(id);
    }

}
