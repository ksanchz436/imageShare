package kris.sanchez.imageshare.domain.users.service;

import kris.sanchez.imageshare.domain.users.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //private kris.sanchez.imageshare.domain.users.repos.UserRepo UserRepo;

    private UserRepo userRepo;

    @Autowired
    public UserService (UserRepo userRepo){
        this.userRepo = userRepo;
    }




}
