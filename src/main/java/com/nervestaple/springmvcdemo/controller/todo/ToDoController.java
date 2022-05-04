package com.nervestaple.springmvcdemo.controller.todo;

import com.nervestaple.springmvcdemo.entity.ToDoItem;
import com.nervestaple.springmvcdemo.service.ToDoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ToDoController {

    private static final Logger log = LoggerFactory.getLogger(ToDoController.class);

    private ToDoItemService service;

    public ToDoController(ToDoItemService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String Index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Page<ToDoItem> pageToDoItem = service.findPaginated(
                PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.DESC, "completedAt")));

        model.addAttribute("pageToDoItems", pageToDoItem);

        return "todo/index";
    }

    @GetMapping(value = "/add-item-form")
    public String AddForm(Model model) {
        model.addAttribute("title", "Create a New To Do");
        model.addAttribute("action", "Create");
        model.addAttribute("submitPath", "save-item");
        model.addAttribute("toDoItem", new ToDoItem());
        return "todo/item-form";
    }

    @GetMapping(value = "/edit-item-form/{id}")
    public String EditForm(Model model,
                           @PathVariable("id") Long id) {
        model.addAttribute("title",  "Edit a To Do");
        model.addAttribute("action", "Save");
        model.addAttribute("submitPath", "save-item");
        model.addAttribute("toDoItem", service.findById(id).get());
        return "todo/item-form";
    }

    @GetMapping(value = "/complete-item/{id}")
    public String complete(Model model,
                           @PathVariable("id") Long id) {
        service.complete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/delete-item/{id}")
    public String delete(Model model,
                         @PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping(value = "/save-item")
    public String SaveItem(@ModelAttribute("toDoItem") ToDoItem toDoItem) {
        service.save(toDoItem);
        return "redirect:/";
    }
}
