package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.util.List;


public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void saveUser(User newUser){
        userRepository.save(newUser);

    }
    public User readUser(Long id){
        return userRepository.findById(id);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
