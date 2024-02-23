package ru.paklulin.eshop_eureka_service.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.paklulin.eshop_eureka_service.models.Item;
import ru.paklulin.eshop_eureka_service.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/items/")
public class ItemsController {
    private final ItemService itemService;
    private final MeterRegistry meterRegistry;

    @Autowired
    public ItemsController(ItemService itemService, MeterRegistry meterRegistry) {
        this.itemService = itemService;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping()
    public List<Item> getAllItems() {
        meterRegistry.counter("getAllItems").increment();
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") int id) {
        meterRegistry.counter("get "+id).increment();
        return itemService.findById(id);
    }

    @PostMapping()
    public Item newItem(@RequestBody Item item) {
        meterRegistry.counter("add new item").increment();
        return itemService.save(item);
    }


    @PutMapping("/{id}")
    public Item updateItem(@PathVariable("id") int id, @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        itemService.delete(id);
    }
}
