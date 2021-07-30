package com.example.crud_example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partnerID",nullable = false)
    private int partnerID;

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Column(name = "partner_name")
    private String partnerName;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;
/*
    @ManyToMany(mappedBy = "partners",fetch = FetchType.LAZY)
    private Collection<Project> projects;
*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_country",referencedColumnName = "countryID")
    private Country country;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "project_partner",
            joinColumns = { @JoinColumn(name = "partnerID") },
            inverseJoinColumns = { @JoinColumn(name = "projectID") }
    )
    Set<Project> projects = new HashSet<>();

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
/*
    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
*/
    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
