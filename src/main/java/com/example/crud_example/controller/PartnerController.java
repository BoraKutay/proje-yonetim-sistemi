package com.example.crud_example.controller;

import com.example.crud_example.model.MyUserDetails;
import com.example.crud_example.model.Partner;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.UserRepository;
import com.example.crud_example.service.CountryService;
import com.example.crud_example.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//Partner için CRUD işlemlerinin yapılmasını sağlayan controller
/*
* showPartner -> partner.html sayfasına yönlendirir ve partnerlerin listesini erişim sağlar.
* updatePartner -> id'si bilinen partnerin bilgilerine erişir ve değiştirmemize olanak sağlar
* savePartner -> partner service ile kayıt işlemi
* deletePartner-> partner service ile silme işlemi (id gerekli)
* showNewPartner -> yeni partner eklemeye olanak sağlayan html sayfasına yönlendirir.
* */
@Controller
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/partners")
    public String showPartners(Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String username = ((MyUserDetails)principal).getUsername();
        Optional<User> user=userRepository.findByUserMail(username);

        int userID = user.get().getUserID();
        User loggedUser= userRepository.getById(userID);

        model.addAttribute("userID",loggedUser.getUserID());
        model.addAttribute("userName",loggedUser.getUserName());
        model.addAttribute("userRole",loggedUser.getRoles());
        model.addAttribute("userMail",loggedUser.getUserMail());
        model.addAttribute("userPhoto",loggedUser.getUserImage());


        model.addAttribute("listPartners",partnerService.getAllPartners());
        return "partner";
    }

    @GetMapping("/updatePartner/{id}")
    public String updatePartner(@PathVariable(value = "id")int id, Model model){
        Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("listCountries", countryService.getAllCountries());
        model.addAttribute("partner",partner);
        return "update_partner";
    }

    @PostMapping("/savePartner")
    public String savePartner(@ModelAttribute("partner") Partner partner){

        partnerService.savePartner(partner);
        return "redirect:/partners";
    }

    @GetMapping("/deletePartner/{id}")
    public String deletePartner(@PathVariable(value = "id")int id){

        this.partnerService.deletePartnerById(id);
        return "redirect:/partners";
    }
    @GetMapping("/showNewPartner")
    public String showNewPartner(Model model){
        Partner partner = new Partner();
        model.addAttribute("partner",partner);
        model.addAttribute("listCountries", countryService.getAllCountries());
        return "new_partner";
    }
}
