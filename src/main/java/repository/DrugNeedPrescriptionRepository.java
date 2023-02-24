package repository;

import model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugNeedPrescriptionRepository extends JpaRepository<Drug, Long> {
}
