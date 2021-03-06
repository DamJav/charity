package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.RegistrationService;
import pl.coderslab.charity.services.UpdateUserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final UpdateUserService updateUserService;
    private final RegistrationService registrationService;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public AdminController(UserRepository userRepository, UpdateUserService updateUserService, RegistrationService registrationService, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.userRepository = userRepository;
        this.updateUserService = updateUserService;
        this.registrationService = registrationService;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
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
    public String prepareUpdateAdminPage(Long id, Model model) {
        model.addAttribute("user", userRepository.getOne(id));
        return "/admin/update-admin";
    }

    @PostMapping("/update")
    public String processUpdateAdminPage(@ModelAttribute User user) {
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



    @GetMapping("/manage")
    public String usersManage(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/admin/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/lock")
    public String lockUser(Long id){
        userRepository.lockUserByUserId(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/unlock")
    public String unlockUser(Long id){
        userRepository.unlockUserByUserId(id);
        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/update")
    public String prepareUpdateUserPage(Long id, Model model) {
        model.addAttribute("user", userRepository.getOne(id));
        return "/admin/update-admin";
    }

    @PostMapping("/manage/update")
    public String processUpdateUserPage(@ModelAttribute User user) {
        updateUserService.updateUser(user);
        return "redirect:/admin/manage";
    }

    @GetMapping("/institutions")
    public String showInstitutions(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        return "/admin/institutions";
    }


    @GetMapping("/deleteInst")
    public String deleteInst(Long id) {
        if(donationRepository.showIds(id) != null) {
            for (Long one : donationRepository.showIds(id)) {
                donationRepository.deleteCategoriesByDonationId(one);
            }
        }
            donationRepository.deleteDonationsByInstitutionId(id);
            institutionRepository.deleteById(id);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/updateInst")
    public String prepareUpdateInst(Long id, Model model) {
        model.addAttribute("institution", institutionRepository.getOne(id));
        return "/admin/update-inst";
    }

    @PostMapping("/updateInst")
    public String processUpdateInst(@ModelAttribute Institution institution) {
        institutionRepository.save(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/createInst")
    public String prepareCreateInst(Model model) {
        model.addAttribute("institution", new Institution());
        return "/admin/create-inst";
    }

    @PostMapping("/createInst")
    public String processCreateInst(@ModelAttribute("institution")Institution institution) {
        institutionRepository.save(institution);
        return "redirect:/admin/institutions";
    }
}
