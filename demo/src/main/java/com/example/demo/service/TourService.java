package com.example.demo.service;

import com.example.demo.model.Tour;

import java.util.List;

public interface TourService {

    public List<Tour> tourList();
    public void creatTour(Tour tour);
    public Tour findTourById(Long id);
    public void deleteTour(Long id);
}
