package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRep extends JpaRepository<Client, Long> {
}
