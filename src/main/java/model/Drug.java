package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drugs")

public class Drug {
    @Id @GeneratedValue
    private Long drugId;
    @Column(name = "drug-name")
    private String name;
    @Column(name = "active-ingredient-dosage")
    private int dosage; //дозировка действующего вещества
    @Column(name = "need-a-prescription")
    private boolean needPrescription; //рецепт


    @ManyToMany
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    @ManyToOne
    private List<Pharmacy> pharmacies;

    public Drug(Long drugId, String name, int dosage, boolean needPrescription) {
        this.drugId = drugId;
        this.name = name;
        this.dosage = dosage;
        this.needPrescription = needPrescription;
    }

    public Drug() {

    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public boolean isNeedPrescription() {
        return needPrescription;
    }

    public void setNeedPrescription(boolean needPrescription) {
        this.needPrescription = needPrescription;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + drugId +
                ", name='" + name + '\'' +
                ", dosage=" + dosage +
                ", needPrescription=" + needPrescription +
                '}';
    }
}
