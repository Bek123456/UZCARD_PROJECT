package org.example.uzcarrd.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.ProfileRole;
import org.example.uzcarrd.enums.ProfileStatus;

import java.util.UUID;
@Getter
@Setter
public class ProfileDTO {
    private UUID id;
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "surname is required")
    private String surname;
    private String username;
    private String phone;
    @NotBlank(message = "Password field must has a value")
    private String password;
    private ProfileRole role;
    private ProfileStatus status;
    private String attachUrl;
    private String jwt;
}
