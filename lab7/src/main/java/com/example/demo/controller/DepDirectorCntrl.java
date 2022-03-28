package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.PostServiceImpl;
import com.example.demo.service.StaffServiceImpl;
import com.example.demo.service.TourServiceImpl;
import com.example.demo.service.TourTaskServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/deputy-director")
public class DepDirectorCntrl {
    private final PostServiceImpl postServiceImpl;
    private final StaffServiceImpl staffServiceImpl;
    private final TourTaskServiceImpl tourTaskServiceImpl;
    private final TourServiceImpl tourServiceImpl;
    public DepDirectorCntrl(PostServiceImpl postServiceImpl, StaffServiceImpl staffServiceImpl, TourTaskServiceImpl tourTaskServiceImpl, TourServiceImpl tourServiceImpl) {
        this.postServiceImpl = postServiceImpl;
        this.staffServiceImpl = staffServiceImpl;
        this.tourTaskServiceImpl = tourTaskServiceImpl;
        this.tourServiceImpl = tourServiceImpl;
    }
    @GetMapping
    public String deputyDirector(){
        return "director/deputyDirector";
    }


    @GetMapping("/posts")
    public String allPosts(Model model){
        model.addAttribute("postList", postServiceImpl.postList());
        return "director/postList";
    }

    @GetMapping("/posts/newPosition")
    public String newPost(Model model){
        model.addAttribute("post", new Post());
        return "director/post_form";
    }
    @PostMapping("/posts/save")
    public String createPosition(Post post){
        postServiceImpl.creatPost(post);
        return "redirect:/deputy-director/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePosition(@PathVariable("id") Long id){
        postServiceImpl.deletePost(id);
        return "redirect:/deputy-director/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public ModelAndView viewEditPostForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("director/post_form");
        Post post = postServiceImpl.updateById(id);
        mav.addObject("post", post);
        return mav;
    }







    // Staff List
    @GetMapping("/staff")
    public String allStaff(Model model){
        model.addAttribute("staffList", staffServiceImpl.staffList());
        return "director/staffList";
    }
    //Create Staff
    @GetMapping("/staff/newStaff")
    public String newStaff(Model model) {
        List<Post> postList = postServiceImpl.postList();
        model.addAttribute("staff", new Staff());
        model.addAttribute("listPost", postList);
        return "director/staff_form";
    }
    @PostMapping("/staff/save")
    public String createStaff(Staff staff) {
        staffServiceImpl.creatStaff(staff);
        return "redirect:/deputy-director/staff";
    }

    @GetMapping("/staff/edit/{id}")
    public String staffForm(@PathVariable("id") Long id, Model model){
        Staff staff = staffServiceImpl.findById(id);
        model.addAttribute("staff", staff);
        List<Post> postList = postServiceImpl.postList();
        model.addAttribute("listPost", postList);
        return "director/staff_form";
    }
    //Delete Staff
    @GetMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id){
        staffServiceImpl.deletePost(id);
        return "redirect:/deputy-director/staff";
    }






    //All Tour Tasks
    @GetMapping("/tour-task")
    public String allTourTask(Model model){
        model.addAttribute("taskList", tourTaskServiceImpl.tourTasksList());
        return "director/tourTaskList";
    }
    //Create Tour Task
    @GetMapping("/tour-task/newTask")
    public String newTask(Model model) {
        List<Status> statusList = tourTaskServiceImpl.statusList();
        List<Tour> tourList = tourServiceImpl.tourList();
        model.addAttribute("task", new TourTasks());
        model.addAttribute("statuses", statusList);
        model.addAttribute("tours", tourList);
        return "director/task_form";
    }
    @PostMapping("/tour-task/save")
    public String createTask(TourTasks tourTask) {
        tourTaskServiceImpl.createTask(tourTask);
        return "redirect:/deputy-director/tour-task";
    }

    //Delete Task
    @GetMapping("/tour-task/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        tourTaskServiceImpl.deleteTask(id);
        return "redirect:/deputy-director/tour-task";
    }










}
