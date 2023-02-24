package service;

import model.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PharmacyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmRepository;

    public List<Pharmacy> getPharmacies(){
        return pharmRepository.findAll();
    }
    public void savePharm(Pharmacy newPharmacy){
        pharmRepository.save(newPharmacy);
    }
    public Optional<Pharmacy> readPharm(Long id){
        return pharmRepository.findById(id);
    }
    public void deletePharm(Long id){
        pharmRepository.deleteById(id);
    }

}
