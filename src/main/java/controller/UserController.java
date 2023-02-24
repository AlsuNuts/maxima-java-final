package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import service.DrugService;
import service.JpaUserDetailService;


@RestController
@RequestMapping("/version1")
public class UserController {

    @Autowired
    private JpaUserDetailService userService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private ResponseEntity responseEntity;


    @ModelAttribute("user")
    public User getUser(Authentication authentication){
        if (authentication == null){
            return null;
        }
        System.out.println(authentication.getPrincipal());
        User user = userService.getUserByLogin(authentication.getPrincipal().toString());


    }
}
/*
@GetMapping("/user")
    public List<Drug> getAll() {
        return drugService.qetDrug();
    }

    @GetMapping("/drug/{id}")
    public ResponseEntity<Drug> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(drugService.readDrug(id));
    }

    @PostMapping("/drug")
    public ResponseEntity<Drug> add(@RequestBody Drug cat) {
        drugService.saveDrug(cat);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
 */