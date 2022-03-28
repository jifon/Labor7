package com.example.demo.service;

import com.example.demo.model.Types;

import java.util.List;

public interface TypeService {

    public List<Types> typesList();
    public void createType(Types types);
    public void deleteType(Long id);
}
