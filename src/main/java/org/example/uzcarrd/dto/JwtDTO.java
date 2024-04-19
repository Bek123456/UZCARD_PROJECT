package org.example.uzcarrd.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.ProfileRole;
@Getter
@Setter

public class JwtDTO {
    private Integer id;
    private String email;
    private ProfileRole role;

    public JwtDTO(Integer id) {
        this.id = id;
    }

    public JwtDTO(Integer id, ProfileRole role) {
        this.id = id;
        this.role = role;
    }

    public JwtDTO(String email, ProfileRole role) {
        this.email = email;
        this.role = role;
    }


    public JwtDTO(ProfileRole role, String email) {
        this.role = role;
        this.email = email;
    }

    public JwtDTO(Integer id, String email, ProfileRole role) {
        this.id = id;
        this.email = email;
        this.role = role;
    }
}
