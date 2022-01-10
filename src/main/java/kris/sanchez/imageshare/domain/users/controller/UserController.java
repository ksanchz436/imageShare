package kris.sanchez.imageshare.domain.users.controller;

import kris.sanchez.imageshare.domain.users.models.User;
import kris.sanchez.imageshare.domain.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }






}
