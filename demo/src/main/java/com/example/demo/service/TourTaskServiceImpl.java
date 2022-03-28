package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.model.TourTasks;
import com.example.demo.repository.StatusRep;
import com.example.demo.repository.TourTaskRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourTaskServiceImpl implements TourTaskService {
    private final TourTaskRep tourTaskRep;
    private final StatusRep statusRep;
    public TourTaskServiceImpl(TourTaskRep tourTaskRep, StatusRep statusRep) {
        this.tourTaskRep = tourTaskRep;
        this.statusRep = statusRep;
    }

    @Override
    public void createTask(TourTasks tourTasks){
        tourTaskRep.save(tourTasks);
    }

    @Override
    public List<TourTasks> tourTasksList(){
        return tourTaskRep.findAll();
    }

    @Override
    public List<Status> statusList(){
        return statusRep.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        tourTaskRep.deleteById(id);
    }

    @Override
    public TourTasks find(Long id){
        return tourTaskRep.findById(id).get();
    }
}
