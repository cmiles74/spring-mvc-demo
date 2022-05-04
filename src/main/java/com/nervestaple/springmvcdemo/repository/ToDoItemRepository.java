package com.nervestaple.springmvcdemo.repository;

import com.nervestaple.springmvcdemo.entity.ToDoItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends PagingAndSortingRepository<ToDoItem, Long> {
    @Query("select count(id) from ToDoItem")
    Long countAll();
}
