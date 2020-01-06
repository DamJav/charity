package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.DonationService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationService donationService;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationService donationService, DonationRepository donationRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/form")
    public String prepareDonation(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String processDonation(HttpServletRequest req, Model model, Principal principal){
        Donation donation = new Donation();
        List<Category> categories = new ArrayList<>();
        List<String> categoriesNames = Collections.singletonList(req.getParameter("categories"));
        for(String category : categoriesNames){
            categories.add(categoryRepository.findByName(category));
        }
        donation.setCategories(categories);
        donation.setCity(req.getParameter("city"));
        donation.setPickUpComment(req.getParameter("comment"));
        donation.setPickUpDate(LocalDate.parse(req.getParameter("date")));
        donation.setPickUpTime(LocalTime.parse(req.getParameter("time")));
        donation.setUser(userRepository.findUserByEmail(principal.getName()));
        donation.setQuantity(Long.parseLong( req.getParameter("bags")));
        donation.setStreet(req.getParameter("street"));
        donation.setZipCode(req.getParameter("zipCode"));
        donation.setStatus("nieodebrany");
        donationRepository.save(donation);


        return "form-confirmation";
    }
}