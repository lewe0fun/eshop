package ru.paklulin.eshop_eureka_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.orElseThrow(() -> new RuntimeException("item not found"));
    }

    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public Item update(int id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    @Transactional
    public void delete(long id) {
        itemRepository.deleteById(id);
    }
}