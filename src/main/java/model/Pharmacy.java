package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pharmacies")
public class Pharmacy {
    @Id @GeneratedValue
    private Long phamId;
    private String address;
    private String name;
    @OneToMany
    private List<Drug> drugs;

    @ManyToMany
    private List<User> users;

    public Pharmacy(Long phamId, String address, String name, List<Drug> drugs, List<User> users) {
        this.phamId = phamId;
        this.address = address;
        this.name = name;
        this.drugs = drugs;
        this.users = users;
    }

    public Pharmacy() {

    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public List<User> getUsers() {
        return users;
    }

    public Long getPhamId() {
        return phamId;
    }

    public void setPhamId(Long phamId) {
        this.phamId = phamId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
