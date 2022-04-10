package com.example.basicfullstack.profile;

import com.example.basicfullstack.user.User;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @Size(max = 25)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 25)
    private String lastName;

    @Column(name = "phone_number")
    @Size(max = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private EGender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Size(max = 100)
    private String address;

    @Size(max = 6)
    private String address_number;

    @Size(max = 10)
    private String zipCode;

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String country;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Profile(String firstName, String lastName, String phoneNumber, EGender gender, Date dateOfBirth, String address, String address_number, String zipCode, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.address_number = address_number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    // Omit getter to avoid inifinite loop
    public User getUser() {
        return null;
    }
}