package com.example.crud_example.service;


import com.example.crud_example.model.Project;
import com.example.crud_example.model.ProjectCall;
import com.example.crud_example.model.Status;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.ProjectCallRepository;
import com.example.crud_example.repository.ProjectRepository;
import com.example.crud_example.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ProjectCallRepository callRepository;

    //Tüm projelere erişim
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    //Proje kayıt
    @Override
    public void saveProject(Project project) {
        this.projectRepository.save(project);
    }

    //ID ile projeye erişim
    @Override
    public Project getProjectById(int id) {
        Optional<Project> optional = projectRepository.findById(id);
        Project project = null;
        if(optional.isPresent()){
            project = optional.get();
        }else{
            throw new RuntimeException("Project not found for id:: "+id);
        }
        return project;
    }

    //Proje silme
    @Override
    public void deleteProjectById(int id) {
        this.projectRepository.deleteById(id);
    }

    // Proje durumlarının tümüne erişme
    @Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    // Proje çağrılarının tümüne erişme
    @Override
    public List<ProjectCall> getAllCalls() {
        return callRepository.findAll();
    }
}
