package com.example.crud_example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project_call")
public class ProjectCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectcallID",nullable = false)
    private int callID;

    public int getCallID() {
        return callID;
    }

    public void setCallID(int callID) {
        this.callID = callID;
    }

    public String getProjectCallName() {
        return projectCallName;
    }

    public void setProjectCallName(String projectCallName) {
        this.projectCallName = projectCallName;
    }

    @Column(name = "project_call_name",nullable = false)
    private String projectCallName;

    @OneToMany(mappedBy = "projectCall")
    private List<Project> projects = new ArrayList<>();


}
