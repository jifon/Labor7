package com.example.demo.service;


import com.example.demo.model.Types;
import com.example.demo.repository.TypesRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypesRep typesRep;
    public TypeServiceImpl(TypesRep typesRep) {
        this.typesRep = typesRep;
    }

    @Override
    public List<Types> typesList(){
        return typesRep.findAll();
    }

    @Override
    public void createType(Types types){
        typesRep.save(types);
    }

    @Override
    public void deleteType(Long id){
        typesRep.deleteById(id);
    }

}
