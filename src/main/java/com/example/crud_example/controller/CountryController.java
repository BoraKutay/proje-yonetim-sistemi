package com.example.crud_example.controller;

import com.example.crud_example.model.Country;
import com.example.crud_example.model.MyUserDetails;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.UserRepository;
import com.example.crud_example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//Country entity için CRUD işlemlerinin yapılmasını sağlayan controller
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/countries")
    public String showCountries(Model model) {

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


        model.addAttribute("listCountries", countryService.getAllCountries());
        return "country";
    }

    @GetMapping("/updateCountry/{id}")
    public String updateCountry(@PathVariable(value = "id") int id, Model model) {

        Country country = countryService.getCountryById(id);

        model.addAttribute("country", country);

        return "update_country";
    }

    @PostMapping("/saveCountry")
    public String saveCountry(@ModelAttribute("country") Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable(value = "id") int id) {
        this.countryService.deleteCountryById(id);
        return "redirect:/countries";
    }

    @GetMapping("/showNewCountry")
    public String showNewCountry(Model model){
        Country country = new Country();
        model.addAttribute("country",country);
        return "new_country";
    }
}
