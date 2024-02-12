package ru.paklulin.eshop_eureka_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paklulin.eshop_eureka_service.models.Comment;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.repositories.CommentRepository;
import ru.paklulin.eshop_eureka_service.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ItemRepository itemRepository) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        return optionalComment.orElseThrow(() -> new RuntimeException("comment not found"));
    }

    public Comment findByItem(Item item) {
        return commentRepository.findByItem(item);
    }

    @Transactional
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment update(int id, Comment comment) {


        comment.setId(id);
        return commentRepository.save(comment);
    }

    @Transactional
    public void delete(long id) {
        commentRepository.deleteById(id);
    }
}