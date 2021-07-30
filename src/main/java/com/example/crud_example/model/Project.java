package com.example.crud_example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectID",nullable = false)
    private int projectID;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_short_name")
    private String projectShortName;

    @Column(name = "project_description")
    private String description;

/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_status",referencedColumnName = "statusID")
    private Status status;
*/
    @ManyToOne
    @JoinColumn(name = "fk_call")
    private ProjectCall projectCall;

    @ManyToOne
    @JoinColumn(name="fk_status")
    private Status status;

    /*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_partner",referencedColumnName = "partnerID")
    private Partner partner;

        public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "partner", joinColumns = @JoinColumn(name = "projectID", referencedColumnName = "projectID"),
            inverseJoinColumns = @JoinColumn(name = "fk_partner", referencedColumnName = "partnerID"))

    private Collection<Partner> partners =  new ArrayList<Partner>() ;
*/

    public Set<Partner> getPartners() {
        return partners;
    }

    public void setPartners(Set<Partner> partners) {
        this.partners = partners;
    }

    @ManyToMany(mappedBy = "projects",cascade = {CascadeType.ALL})
    private Set<Partner> partners = new HashSet<Partner>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProjectCall getProjectCall() {
        return projectCall;
    }

    public void setProjectCall(ProjectCall projectCall) {
        this.projectCall = projectCall;
    }


    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectShortName() {
        return projectShortName;
    }

    public void setProjectShortName(String projectShortName) {
        this.projectShortName = projectShortName;
    }



}
