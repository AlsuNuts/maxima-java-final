package service;

import exceptions.DrugNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugNeedPrescriptionRepository;
import repository.DrugsRepository;

import java.util.List;


@Service
public class DrugService {
    @Autowired
    private DrugsRepository drugsRepository;
    @Autowired private DrugNeedPrescriptionRepository needPrescriptionRepository;

    public List<Drug> qetDrug(){
        return drugsRepository.findAll();
    }
    public Drug createNewDrug (Drug newDrug ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
        EntityManager em;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(newDrug);
        em.getTransaction().commit();
        return newDrug;
    }
    public void saveDrug(Drug newDrug){
        if (newDrug.isNeedPrescription()){
            needPrescriptionRepository.save(newDrug);
            System.out.println("Препарат отпускается по рецепту");
        }
        drugsRepository.save(newDrug);
    }

    public Drug readDrug(Long drugId){
        return drugsRepository.findById(drugId).orElseThrow(()->new DrugNotFoundException(drugId.toString()));
    }
    public void deleteDrug(Long drugId){
        drugsRepository.deleteById(drugId);
    }

}
