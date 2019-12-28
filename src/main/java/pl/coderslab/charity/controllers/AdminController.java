package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.UpdateUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final UpdateUserService updateUserService;
    private final RegistrationService registrationService;

    public AdminController(UserRepository userRepository, UpdateUserService updateUserService, RegistrationService registrationService) {
        this.userRepository = userRepository;
        this.updateUserService = updateUserService;
        this.registrationService = registrationService;
    }

    @GetMapping("/administrators")
    public String adminManage(Model model){
        model.addAttribute("admins", userRepository.findAllAdmins());
        return "/admin/administrators";
    }

    @GetMapping("/delete")
    public String deleteAdmin(Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/administrators";
    }


    @GetMapping("/update")
    public String prepareUpdateUserPage(Long id, Model model) {
        model.addAttribute("user", userRepository.getOne(id));
        return "/admin/update-admin";
    }

    @PostMapping("/update")
    public String prepareUpdateUserPage(@ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/update-admin";
        }
        updateUserService.updateAdmin(user);
        return "redirect:/admin/administrators";
    }

    @GetMapping("/create")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "/admin/admin-register";
    }

    @PostMapping("/create")
    public String processRegistrationPage(@ModelAttribute("registrationData")RegistrationDataDTO registrationData) {
        registrationService.registerAdmin(registrationData);
        return "redirect:/admin/administrators";
    }


}
