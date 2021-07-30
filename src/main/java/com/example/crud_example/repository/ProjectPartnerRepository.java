package com.example.crud_example.repository;

import com.example.crud_example.model.Partner;
import com.example.crud_example.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPartnerRepository extends JpaRepository<Partner, Project> {

}
