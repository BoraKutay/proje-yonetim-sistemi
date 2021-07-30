package com.example.crud_example.service;

import com.example.crud_example.model.Partner;
import com.example.crud_example.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    //Tüm partnerlere erişim
    @Override
    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    //Partnerleri kaydetme
    @Override
    public void savePartner(Partner partner) {
        this.partnerRepository.save(partner);
    }

    //ID ile partnere erişim
    @Override
    public Partner getPartnerById(int id) {
        Optional<Partner> optional = partnerRepository.findById(id);
        Partner partner = null;
        if(optional.isPresent()){
            partner = optional.get();
        }else{
            throw new RuntimeException("Partner not found for id:: "+id);
        }
        return partner;
    }

    //Partner silme
    @Override
    public void deletePartnerById(int id) {
        this.partnerRepository.deleteById(id);
    }


}
