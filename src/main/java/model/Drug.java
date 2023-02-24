package model;

import jakarta.persistence.*;

@Entity
@Table(name = "drugs")

public class Drug {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "drug-name")
    private String name;
    @Column(name = "active-ingredient-dosage")
    private int dosage; //дозировка действующего вещества
    @Column(name = "need-a-prescription")
    private boolean needPrescription; //рецепт

    public Drug(Long id, String name, int dosage, boolean needPrescription) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.needPrescription = needPrescription;
    }

    public Drug() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", dosage=" + dosage +
                ", needPrescription=" + needPrescription +
                '}';
    }
}
