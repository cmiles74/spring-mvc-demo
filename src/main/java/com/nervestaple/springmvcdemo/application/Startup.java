package com.nervestaple.springmvcdemo.application;

import com.nervestaple.springmvcdemo.entity.ToDoItem;
import com.nervestaple.springmvcdemo.service.ToDoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Startup implements InitializingBean  {

    private static final Logger log = LoggerFactory.getLogger(InitializingBean.class);

    private ToDoItemService service;

    public Startup(ToDoItemService service) {
        this.service = service;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (service.countAll() < 1) {
            log.info("Creating our initial to-do items...");
            service.save(new ToDoItem("Add more to-do items!"));
        }
    }
}
