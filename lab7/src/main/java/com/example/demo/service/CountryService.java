package com.example.demo.service;

import com.example.demo.model.Country;

import java.util.List;

public interface CountryService {
    public List<Country> countryList();
    public void createCountry(Country country);
    public void deleteCountry(Long id);
    public Country updatedCountryById(Long id);

}
