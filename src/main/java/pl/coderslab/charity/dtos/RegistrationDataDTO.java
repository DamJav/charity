package pl.coderslab.charity.dtos;


import lombok.Data;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.entities.Role;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class RegistrationDataDTO {

    private String name;
    private String surname;
    @NotBlank @Email
    private String email;
    private String password;
    private String rePassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;
}
