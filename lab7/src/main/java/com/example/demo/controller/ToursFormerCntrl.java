package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.model.TourTasks;
import com.example.demo.service.TourTaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/former")
public class ToursFormerCntrl {
    private final TourTaskServiceImpl tourTaskServiceImpl;

    public ToursFormerCntrl(TourTaskServiceImpl tourTaskServiceImpl) {
        this.tourTaskServiceImpl = tourTaskServiceImpl;
    }

    @GetMapping
    public String toursFormer(){
        return "former/toursFormer";
    }

    @GetMapping("/tour-task")
    public String allTourTask(Model model){
        model.addAttribute("taskList", tourTaskServiceImpl.tourTasksList());
        return "former/tourTaskList";
    }
    @PostMapping("/tour-task/save")
    public String editTask(TourTasks tourTask) {
        tourTaskServiceImpl.createTask(tourTask);
        return "redirect:/former/tour-task";
    }
    @GetMapping("/tour-task/edit/{id}")
    public String TourTaskForm(@PathVariable("id") Long id, Model model){
        TourTasks tourTasks= tourTaskServiceImpl.find(id);
        model.addAttribute("task", tourTasks);
        List<Status> statusList = tourTaskServiceImpl.statusList();
        model.addAttribute("statuses", statusList);
        return "former/task_form";
    }

}
