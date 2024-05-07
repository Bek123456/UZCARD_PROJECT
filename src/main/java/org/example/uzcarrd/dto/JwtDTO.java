package org.example.uzcarrd.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.uzcarrd.enums.ProfileRole;
@Getter
@Setter

public class JwtDTO {
    private Integer id;
    private String username;
    private ProfileRole role;

    public JwtDTO(Integer id) {
        this.id = id;
    }

    public JwtDTO(Integer id, ProfileRole role) {
        this.id = id;
        this.role = role;
    }

    public JwtDTO(String username, ProfileRole role) {
        this.username = username;
        this.role = role;
    }


    public JwtDTO(ProfileRole role, String username) {
        this.role = role;
        this.username = username;
    }

    public JwtDTO(Integer id, String username, ProfileRole role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
}
