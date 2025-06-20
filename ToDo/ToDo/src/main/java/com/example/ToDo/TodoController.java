package com.example.ToDo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    private final List<Task> tasks = new ArrayList<>();

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task newTask) {
        tasks.add(newTask);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
        return "redirect:/";
    }
}

