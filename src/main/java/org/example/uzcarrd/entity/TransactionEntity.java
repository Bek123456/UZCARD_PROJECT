package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.TransactionStatus;
import org.example.uzcarrd.enums.TransactionType;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transaction_entity")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    id(uuid), card_id,amount,transaction_type (CREDIT,DEBIT), transfer_id, created_date,
//    status(CREATED,SUCCESS,FAILED,CANCELED,)
    @ManyToOne
    @JoinColumn(name = "card_id", insertable = false, updatable = false)
    private CardEntity cardEntity;

    @Column(name = "card_id")
    private UUID cardId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "transfer_id", insertable = false, updatable = false)
    private TransferEntity transferEntity;

    @Column(name = "transfer_id")
    private UUID transferId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;


}
