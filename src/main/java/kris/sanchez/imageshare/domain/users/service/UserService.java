package kris.sanchez.imageshare.domain.users.service;

import kris.sanchez.imageshare.domain.users.models.User;
import kris.sanchez.imageshare.domain.users.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //private kris.sanchez.imageshare.domain.users.repos.UserRepo UserRepo;

    private UserRepo userRepo;

    @Autowired
    public UserService (UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userOptional = userRepo.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("user already exists");
        }
        userRepo.save(user);
    }

    public void deleteUser(Long userId){
        boolean exist = userRepo.existsById(userId);
        if(!exist){
            throw new IllegalStateException(("user with id" + userId + " does not exist "));
        }
        userRepo.deleteById(userId);

    }

    //@Transactional
    //public void updateUser()





}
