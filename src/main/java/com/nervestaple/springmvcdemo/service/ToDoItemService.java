package com.nervestaple.springmvcdemo.service;

import com.nervestaple.springmvcdemo.entity.ToDoItem;
import com.nervestaple.springmvcdemo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {

    private final ToDoItemRepository repository;

    @Autowired
    public ToDoItemService(final ToDoItemRepository repository) {
        this.repository = repository;
    }

    public Long countAll() {
        return repository.countAll();
    }

    public ToDoItem save(ToDoItem item) {
        return repository.save(item);
    }

    public Iterable<ToDoItem> findAll() {
        return repository.findAll();
    }
}
