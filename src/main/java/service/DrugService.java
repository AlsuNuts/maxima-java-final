package service;

import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugNeedPrescriptionRepository;
import repository.DrugsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class DrugService {
    @Autowired
    private DrugsRepository drugsRepository;
    @Autowired private DrugNeedPrescriptionRepository needPrescriptionRepository;

    public List<Drug> qetDrug(){
        return drugsRepository.findAll();
    }
    public void saveDrug(Drug newDrug){
        if (newDrug.isNeedPrescription()){
            needPrescriptionRepository.save(newDrug);
        }
        drugsRepository.save(newDrug);
    }

    public Optional<Drug> readDrug(Long id){
        return drugsRepository.findById(id);
    }

    public void deleteDrug(Long id){
        drugsRepository.deleteById(id);
    }
}
