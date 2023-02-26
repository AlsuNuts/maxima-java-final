package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import service.DrugService;
import service.JpaUserDetailService;
import service.UserService;


@RestController
@RequestMapping("/version1")
public class UserController {

    @Autowired
    private JpaUserDetailService userDetailServiceService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private ResponseEntity responseEntity;
    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public User getUser(Authentication authentication){
        if (authentication == null){
            return null;
        }
        System.out.println(authentication.getPrincipal());
        User user = (User) userDetailServiceService.loadUserByUsername(authentication.getPrincipal().toString());
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/")
    public String sayHello(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return "Hi! This is Spring Boot Project Интернет Аптека";

    }

}
