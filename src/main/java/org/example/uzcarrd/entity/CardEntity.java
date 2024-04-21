package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import org.example.uzcarrd.enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_entity")
public class CardEntity {


    //id(uuid),number,expired_date,phone,status(ACTIVE,BLOCK,NO_ACTIVE),created_date,balance, client_id,company_id,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number",unique = true,nullable = false)
    private String number;
    @Column(name = "expired_date")
    private String expiredDate;
    @Column(name = "phone")
    private String phone;
    @Column(name = "status")
    @Enumerated(EnumType.STRING )
    private Status status;
    @Column(name = "createdDate")
    private LocalDateTime createdDate=LocalDateTime.now();
    @Column(name = "balance")
    private double balance;
    @Column(name = "client_id")
    private  Integer clientId;
    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientEntity clientEntity;
    @Column(name = "company_id")
    private Integer companyId;
    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;
}
