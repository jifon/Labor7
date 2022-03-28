package com.example.demo.repository;

import com.example.demo.model.Types;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesRep extends JpaRepository<Types, Long> {
}
