package com.nervestaple.springmvcdemo.service;

import com.nervestaple.springmvcdemo.entity.ToDoItem;
import com.nervestaple.springmvcdemo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public ToDoItem save(ToDoItem itemThis) {
        ToDoItem item = null;
        if(itemThis.getId() != null) {
            item = repository.findById(itemThis.getId()).get();
            item.setDescription(itemThis.getDescription());
        } else {
            item = itemThis;
        }

        if (item.getCreatedAt() == null) {
            item.setCreatedAt(LocalDateTime.now());
        }

        if (item.getCreatedAt() != null) {
            item.setModifiedAt(LocalDateTime.now());
        }

        return repository.save(item);
    }

    public ToDoItem complete(Long id) {
        ToDoItem item = repository.findById(id).get();
        item.setCompletedAt(LocalDateTime.now());
        repository.save(item);
        return item;
    }

    public Page<ToDoItem> findPaginated(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<ToDoItem> findById(Long id) {
        return repository.findById(id);
    }
}
