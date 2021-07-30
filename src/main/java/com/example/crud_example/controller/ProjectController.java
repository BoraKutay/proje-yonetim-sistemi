
package com.example.crud_example.controller;


import com.example.crud_example.model.MyUserDetails;
import com.example.crud_example.model.Project;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.UserRepository;
import com.example.crud_example.service.PartnerService;
import com.example.crud_example.service.ProjectPartnerService;
import com.example.crud_example.service.ProjectService;
import com.example.crud_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

//Project için CRUD işlemlerinin yapılmasını sağlayan controller
/*
 * viewHomePage -> home.html sayfasına yönlendirir ve projelerin listesine erişim sağlar.
 * updateProject -> id'si bilinen projectin bilgilerine erişir ve değiştirmemize olanak sağlar
 * saveProject -> Project service ile kayıt işlemi
 * deleteProject-> Project service ile silme işlemi (id gerekli)
 * showNewProject -> yeni project eklemeye olanak sağlayan html sayfasına yönlendirir.
 * */
@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectPartnerService projectPartnerService;

    @GetMapping("/home")
    public String viewHomePage(Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("listProjects", projectService.getAllProjects());



        String username = ((MyUserDetails)principal).getUsername();
        Optional<User> user=userRepository.findByUserMail(username);

        int userID = user.get().getUserID();
        User loggedUser= userRepository.getById(userID);

        model.addAttribute("userID",loggedUser.getUserID());
        model.addAttribute("userName",loggedUser.getUserName());
        model.addAttribute("userRole",loggedUser.getRoles());
        model.addAttribute("userMail",loggedUser.getUserMail());
        model.addAttribute("userPhoto",loggedUser.getUserImage());
        model.addAttribute("projectPartner",projectPartnerService.getAllPartners());

        return "home";
    }

    @GetMapping("/updateProject/{id}")
    public String updateProject(@PathVariable(value = "id") int id, Model model){
        //get project from service
        Project project = projectService.getProjectById(id);
        model.addAttribute("listPartners", partnerService.getAllPartners());
        model.addAttribute("listStatus",projectService.getAllStatus());
        model.addAttribute("listCalls",projectService.getAllCalls());
        model.addAttribute("project",project);
        return "update_project";
    }
    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute("project") Project project){
        //proje db'ye kaydedilir

        projectService.saveProject(project);
        return "redirect:/home";
    }
    @GetMapping("deleteProject/{id}")
    public String deleteProject(@PathVariable (value = "id") int id){

        //projeyi silme methodu
        this.projectService.deleteProjectById(id);
        return "redirect:/home";
    }

    @GetMapping("/showNewProject")
    public String showNewProject(Model model){
        Project project = new Project();
        model.addAttribute("project",project);
        model.addAttribute("listPartners", partnerService.getAllPartners());
        model.addAttribute("listStatus",projectService.getAllStatus());
        model.addAttribute("listCalls",projectService.getAllCalls());
        model.addAttribute("projectPartner",projectPartnerService.getAllPartners());
        return "new_project";
    }

    @GetMapping("/showProject/{id}")
    public String showProject(@PathVariable (value = "id") int id,Model model){
        //get emp from service
        Project project = projectService.getProjectById(id);
        model.addAttribute("listPartners", partnerService.getAllPartners());
        model.addAttribute("listStatus",projectService.getAllStatus());
        model.addAttribute("listCalls",projectService.getAllCalls());
        model.addAttribute("projectPartner",projectPartnerService.getAllPartners());
        //set employee as a model attrb to pre-pop form
        model.addAttribute("project",project);
        return "detailed_project";
    }
}
