package com.example.demo.repository;

import com.example.demo.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRep extends JpaRepository<Staff, Long> {
    Staff findByPassportNumber(String passportNummer);
}
