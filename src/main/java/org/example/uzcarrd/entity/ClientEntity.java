package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.Status;

import java.util.UUID;

@Entity
@Table
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
//    id(uuid),name,surname,middle_name,created_date, phone(not unique), status, password_seria,passport_number
//     -> ( passport_seria + passport_number  unique)

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "phone",nullable = false,unique = true)
    private String phone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "password_seria")
    private String passwordSeria;

    @Column(name = "password_number")
    private String passwordNumber;

    @Column(name = "password",nullable = false,unique = true)
    private String password;
}
