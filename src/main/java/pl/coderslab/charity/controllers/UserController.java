package pl.coderslab.charity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.UpdateUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String prepageChangeEmailPage(Principal principal, Model model){
        User user = userRepository.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "/user/change-email";
    }

    @PostMapping("/changeEmail")
    public String processChangeEmailPage(@ModelAttribute User user, Principal principal, HttpServletRequest req) throws ServletException {
        User userToChange = userRepository.findUserByEmail(principal.getName());
        userToChange.getId();
        userRepository.changeEmailUser(user.getEmail(), userToChange.getId());
        req.logout();
        return "/login";
    }
}
