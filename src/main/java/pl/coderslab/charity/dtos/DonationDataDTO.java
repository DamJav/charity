package pl.coderslab.charity.dtos;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DonationDataDTO {



    private Long quantity;
    private List<Category> categories;
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}
