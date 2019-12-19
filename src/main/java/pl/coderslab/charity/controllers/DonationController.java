package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationService donationService;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationService donationService) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationService = donationService;
    }


    @GetMapping("/form")
    public String prepareDonation(Model model){
        model.addAttribute("donationData", new DonationDataDTO());
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String processDonation(@ModelAttribute("donationData") DonationDataDTO donationData){
        donationService.createDonation(donationData);
        return "form-confirmation";
    }
}
