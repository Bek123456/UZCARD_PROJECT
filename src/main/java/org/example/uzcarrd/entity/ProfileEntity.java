package org.example.uzcarrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.ProfileRole;
import org.example.uzcarrd.enums.ProfileStatus;
import org.example.uzcarrd.enums.Status;
import org.springframework.context.annotation.Profile;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "profile_entity")
@Setter
@Getter
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
//    id(uuid),name,surname,created_date,status,role(ADMIN,MODERATOR), username,password

    @Column(name = "name")
    private  String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProfileStatus status;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ProfileRole role;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone",unique = true,nullable = false)
    private String phone;

}
