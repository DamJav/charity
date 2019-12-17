package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.repositories.CategoryRepository;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;

    public DonationController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/form")
    public String prepareDonation(Model model){
        model.addAttribute("donationData", new DonationDataDTO());
        return "form";
    }
}
