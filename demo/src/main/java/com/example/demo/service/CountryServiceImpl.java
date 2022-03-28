package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRep countryRep;
    public CountryServiceImpl(CountryRep countryRep) {
        this.countryRep = countryRep;
    }

    @Override
    public List<Country> countryList(){
        return countryRep.findAll();
    }

    @Override
    public void createCountry(Country country){
        countryRep.save(country);
    }

    @Override
    public void deleteCountry(Long id){
        countryRep.deleteById(id);
    }

    @Override
    public Country updatedCountryById(Long id){
        return countryRep.findById(id).get();
    }



}
