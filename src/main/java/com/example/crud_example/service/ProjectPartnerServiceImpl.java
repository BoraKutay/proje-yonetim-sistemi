package com.example.crud_example.service;

import com.example.crud_example.model.Partner;
import com.example.crud_example.model.Project;
import com.example.crud_example.repository.ProjectPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPartnerServiceImpl implements ProjectPartnerService {

    @Autowired
    private ProjectPartnerRepository projectPartnerRepository;

    @Override
    public List<Partner> getAllPartners() {
        return projectPartnerRepository.findAll();
    }
}
