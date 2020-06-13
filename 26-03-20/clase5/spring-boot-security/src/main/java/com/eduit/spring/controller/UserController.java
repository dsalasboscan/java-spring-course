package com.eduit.spring.controller;

import com.eduit.spring.model.UserDto;
import com.eduit.spring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully");

        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String createUser(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        UserDetails userExists = null;

        try {
            userExists = userService.loadUserByEmail(userDto.getEmail());
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
        }

        if (userExists != null) {
            bindingResult.rejectValue("email", "error.user", "There is an user with the email provided");
        }

        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            bindingResult.rejectValue("password", "error.password", "The passwords must match");
        }

        userDto.setRole("USER");
        userService.save(userDto);

        return "redirect:/registration?success";
    }

    @GetMapping(value = "/users")
    public ModelAndView getUsers() {
        List<UserDto> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @GetMapping(value = "/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @ModelAttribute("user")
    public UserDto createUserDto() {
        return new UserDto();
    }

    @ModelAttribute("users")
    public List<UserDto> createUsersDto() {
        return userService.findAll();
    }


}
