package service;

import exceptions.DrugNotFoundException;
import exceptions.PharmacyNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Drug;
import model.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Service;
import repository.DrugsRepository;
import repository.PharmacyRepository;

import java.util.List;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmRepository;
    @Autowired
    private DrugsRepository drugsRepository;

    public List<Pharmacy> getPharmacies(){
        return pharmRepository.findAll();
    }
    public Pharmacy createNewPharmacy(Pharmacy newPharmacy) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newPharmacy);
        em.getTransaction().commit();
        return newPharmacy;
    }
    public Pharmacy readPharm(Long pharmId){
        return pharmRepository.findById(pharmId).orElseThrow(()-> new PharmacyNotFoundException(pharmId.toString()));
    }
    public Pharmacy updatePharmacy(Long pharmId, Pharmacy newPharmacy){
        pharmRepository.findById(pharmId).orElseThrow(()-> new PharmacyNotFoundException(pharmId.toString()));
        Pharmacy updatedPharmacy = pharmRepository.getById(pharmId);

        updatedPharmacy.setPhamId(newPharmacy.getPhamId());
        updatedPharmacy.setAddress(newPharmacy.getAddress());
        updatedPharmacy.setName(newPharmacy.getName());
        pharmRepository.save(updatedPharmacy);
        return pharmRepository.save(updatedPharmacy);
    }

    public void deletePharm(Long id){
        pharmRepository.deleteById(id);
    }

    public List<Drug> createDrugOrder(Long pharmId, Long drugId){ // List<Drug> createDrugOrder
        pharmRepository.findById(pharmId).orElseThrow(()-> new PharmacyNotFoundException(pharmId.toString()));
        Pharmacy pharmacy = pharmRepository.getById(pharmId);

        drugsRepository.findById(drugId).orElseThrow(()->new DrugNotFoundException(drugId.toString()));
        Drug drug = drugsRepository.getById(drugId);

        pharmacy.getDrugs().add(drug);
        return (List<Drug>) pharmRepository.save(pharmacy);

    }

}
/*\
  public List<Pharmacy> choosePharmacyForUser(String login, Long id){
        userRepository.findById(login).orElseThrow(()->new UserNotFoundException(login.toString()));
        User user = (User) userRepository.getById(login);

        pharmacyRepository.findById(id).orElseThrow(()->new PharmacyNotFoundException(id.toString()));
        Pharmacy pharmacy= pharmacyRepository.getById(id);

        user.getPharmacies().add(pharmacy);
        return userRepository.save(user);
 */
