package com.example.crud_example.service;

import com.example.crud_example.model.Country;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    //Tüm ülkelere erişim
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    //Ülkeyi kaydetme
    @Override
    public void saveCountry(Country country) {
        this.countryRepository.save(country);
    }

    //ID ile ülkeye erişim
    @Override
    public Country getCountryById(int id) {
        Optional<Country> optional = countryRepository.findById(id);
        Country country = null;
        if(optional.isPresent()){
            country = optional.get();
        }else{
            throw new RuntimeException("Country not found for id:: "+id);
        }
        return country;
    }

    //Ülke Silme
    @Override
    public void deleteCountryById(int id) {
        this.countryRepository.deleteById(id);
    }


}
