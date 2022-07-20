package br.com.address_users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "address_tb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_place")
    private String publicPlace;

    @Size(max = 10)
    private String zipCode;

    private int number;

    @Size(max = 80)
    private String city;

    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPublicPlace() {
        return publicPlace;
    }
    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public boolean isMain() {
        return isMain;
    }
    public void setMain(boolean main) {
        isMain = main;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", publicPlace='" + publicPlace + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", isMain=" + isMain +
                '}';
    }
}
