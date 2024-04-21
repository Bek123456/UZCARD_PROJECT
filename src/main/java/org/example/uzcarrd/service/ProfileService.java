package org.example.uzcarrd.service;

import org.example.uzcarrd.dto.ProfileDTO;
import org.example.uzcarrd.entity.ProfileEntity;
import org.example.uzcarrd.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
@Autowired
private ProfileRepository profileRepository;
    public String created1(ProfileDTO dto) {
        ProfileEntity entity=new ProfileEntity();
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
        entity.setSurname(dto.getSurname());
        entity.setStatus(dto.getStatus());
        entity.setUsername(dto.getUsername());
        profileRepository.save(entity);
        return "created profile";
    }

}
