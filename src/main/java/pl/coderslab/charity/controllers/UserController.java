package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @GetMapping("/manage")
    public String userManage(){
        return "/user/manage";
    }

    @GetMapping("/changeEmail")
    public String prepageChangeEmailPage(Principal principal){
        String email = principal.getName();

        return "/user/change-email";
    }
}
