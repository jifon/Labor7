package com.example.demo.repository;

import com.example.demo.model.TourTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourTaskRep extends JpaRepository<TourTasks, Long> {
}
