package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }


    @GetMapping("/form")
    public String prepareDonation(Model model){
        model.addAttribute("donationData", new DonationDataDTO());
        model.addAttribute("allInstitution", institutionRepository.findAll());
        return "form";
        //<form:select path="institution" items="${allInstitution}" itemLabel="name" itemValue="id" multiple="true"/>
    }
}
