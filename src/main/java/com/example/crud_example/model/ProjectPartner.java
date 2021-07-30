package com.example.crud_example.model;


import javax.persistence.*;

@Entity
@Table(name = "project_partner")
public class ProjectPartner {

    @ManyToOne
    @JoinColumn(name = "projectID")
    Project project;

    @ManyToOne
    @JoinColumn(name = "partnerID")
    Partner partner;

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
