package com.example.demo.service;

import com.example.demo.model.Tour;
import com.example.demo.repository.TourRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    private final TourRep tourRepository;
    public TourServiceImpl(TourRep tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> tourList(){
        return tourRepository.findAll();
    }

    @Override
    public void creatTour(Tour tour){
        tourRepository.save(tour);
    }

    @Override
    public Tour findTourById(Long id){return tourRepository.findById(id).get();}

    @Override
    public void deleteTour(Long id){
        tourRepository.deleteById(id);
    }
}
