package com.example.demo.repository;
import com.example.demo.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRep extends JpaRepository<Tour, Long> {
}
