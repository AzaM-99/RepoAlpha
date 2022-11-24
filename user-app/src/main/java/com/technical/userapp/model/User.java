package com.technical.userapp.model;

import com.technical.userapp.enumeration.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * User is a class that has a name, birth date, country, phone, and gender
 */

@Entity
@Table(name = "user_data")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 400)
    @Column(name = "name", length = 400)
    @NotNull
    private String name;

    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @Size(max = 50)
    @Column(name = "country", length = 50)
    @NotNull
    private String country;

    @Size(max = 50)
    @Column(name = "phone", length = 50)
    private String phone;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender;

    public User() {
    }

    public User( String name, LocalDate birthDate, String country, String phone, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.country = country;
        this.phone = phone;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
