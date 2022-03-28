package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.model.TourTasks;

import java.util.List;

public interface TourTaskService {
    public void createTask(TourTasks tourTasks);

    public List<TourTasks> tourTasksList();

    public List<Status> statusList();

    public void deleteTask(Long id);
    public TourTasks find(Long id);


}
