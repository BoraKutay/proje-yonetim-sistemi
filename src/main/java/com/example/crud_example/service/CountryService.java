package com.example.crud_example.service;

import com.example.crud_example.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAllCountries();
    void saveCountry(Country country);
    Country getCountryById(int id);
    void deleteCountryById(int id);

}
