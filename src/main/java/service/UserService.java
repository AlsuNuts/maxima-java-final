package service;


import exceptions.DrugNotFoundException;
import exceptions.PharmacyNotFoundException;
import exceptions.UserNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Drug;
import model.Pharmacy;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugsRepository;
import repository.PharmacyRepository;
import repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DrugsRepository drugsRepository;

    @Autowired
    private PharmacyRepository pharmacyRepository;


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User createNewUser (User newUser ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
        return newUser;
    }
    public User readUser(String login){
        return (User) userRepository.findById(login).orElseThrow(()->new UserNotFoundException(login.toString()));
    }
    public User updateUser(String login, User newUser){
        userRepository.findById(login).orElseThrow();
        User updatedUser = (User) userRepository.getById(login);

        updatedUser.setLogin(newUser.getLogin());
        updatedUser.setName(newUser.getName());
        updatedUser.setPhoneNumber(newUser.getPhoneNumber());
        updatedUser.setEmail(newUser.getEmail());
        updatedUser.setPassword(newUser.getPassword());
        return userRepository.save(updatedUser));

    }
    public void deleteUser(String login){
        userRepository.deleteById(login);
    }
    public List<Drug> bookDrugsForUser(String login, Long drugId){
        userRepository.findById(login).orElseThrow(()->new UserNotFoundException(login.toString()));
        User user = (User) userRepository.getById(login);

        drugsRepository.findById(drugId).orElseThrow(()->new DrugNotFoundException(drugId.toString()));
        Drug drug = drugsRepository.getById(drugId);


        user.getDrugs().add(drug);
        return userRepository.save(user);
    }



    public List<Pharmacy> choosePharmacyForUser(String login, Long phamId){
        userRepository.findById(login).orElseThrow(()->new UserNotFoundException(login.toString()));
        User user = (User) userRepository.getById(login);

        pharmacyRepository.findById(phamId).orElseThrow(()->new PharmacyNotFoundException(phamId.toString()));
        Pharmacy pharmacy= pharmacyRepository.getById(phamId);

        user.getPharmacies().add(pharmacy);
        return userRepository.save(user);
    }
}
