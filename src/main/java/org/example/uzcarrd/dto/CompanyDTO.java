package org.example.uzcarrd.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.CompanyRole;
import org.example.uzcarrd.enums.ProfileRole;
import org.example.uzcarrd.enums.ProfileStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CompanyDTO {

    private String name;

    private String address;

    private String contact;

    private LocalDateTime createdDate=LocalDateTime.now();

    private Boolean visible;

    private CompanyRole role;

    private String code;

    private String username;

    private String password;
    private String jwt;
}
