package com.example.crud_example.service;

import com.example.crud_example.model.Partner;
import com.example.crud_example.model.Status;

import java.util.List;

public interface PartnerService {

    List<Partner> getAllPartners();
    void savePartner(Partner partner);
    Partner getPartnerById(int id);
    void deletePartnerById(int id);


}
