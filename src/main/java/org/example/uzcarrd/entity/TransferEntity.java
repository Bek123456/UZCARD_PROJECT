package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table
@Setter
@Getter
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;;
//    id (uuid), from_card_id, to_card_id, total_amount(5600),amount(5500),service_amount(100),
//    service_percentage(1%),created_date, status(SUCCESS,FAILED,CANCELED), company_id


    @ManyToOne
    @JoinColumn(name = "from_card_id", insertable = false, updatable = false)
    private CardEntity fromCardEntity;
    @Column(name = "from_card_id")
    private Integer fromCardId;

    @ManyToOne
    @JoinColumn(name = "to_card_id", insertable = false, updatable = false)
    private CardEntity toCardEntity;
    @Column(name = "to_card_id")
    private Integer toCardId;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "amount")
    private double amount;

    @Column(name = "service_amount")
    private double serviceAmount;

    @ManyToOne
     @JoinColumn(name = "client_id", insertable = false, updatable = false)
     private ClientEntity clientEntity;
     @Column(name = "company_id")
     private Integer companyId;



}
