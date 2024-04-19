package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.CompanyRole;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "company_entity")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "contact")
    private String contact;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private CompanyRole role;
    @Column(name = "code",nullable = false,unique = true)
    private String code;
    @Column(name = "user_name",unique = true)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
}
