package com.example.crud_example.service;

import com.example.crud_example.model.Project;
import com.example.crud_example.model.ProjectCall;
import com.example.crud_example.model.Status;
import com.example.crud_example.model.User;

import java.util.List;

public interface ProjectService {


    List<Project> getAllProjects();
    void saveProject(Project project);
    Project getProjectById(int id);
    void deleteProjectById(int id);
    List<Status> getAllStatus();
    List<ProjectCall> getAllCalls();
}
