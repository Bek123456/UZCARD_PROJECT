package org.example.uzcarrd.service;

import org.example.uzcarrd.dto.AuthDTO;
import org.example.uzcarrd.dto.CompanyDTO;
import org.example.uzcarrd.dto.ProfileDTO;
import org.example.uzcarrd.entity.CompanyEntity;
import org.example.uzcarrd.entity.ProfileEntity;
import org.example.uzcarrd.enums.AppLanguage;
import org.example.uzcarrd.enums.ProfileStatus;
import org.example.uzcarrd.exp.AppBadException;
import org.example.uzcarrd.repository.CompanyRepository;
import org.example.uzcarrd.repository.ProfileRepository;
import org.example.uzcarrd.util.JWTUtil;
import org.example.uzcarrd.util.MDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ResourceBundleService resourceBundleService;
    @Autowired
    private CompanyRepository companyRepository;

    public ProfileDTO auth(AuthDTO profile, AppLanguage language) {
        Optional<ProfileEntity> optional = profileRepository.findByUsernameAndPassword(profile.getUsername(),
                MDUtil.encode(profile.getPassword()));

        if (optional.isEmpty()) {
            //   String message = resourceBundleMessageSource.getMessage("email.password.wrong", null, new Locale(language.name()));

            throw new AppBadException(resourceBundleService.getMessage("email.password.wrong",language));
        }

        ProfileEntity entity = optional.get();

        if (!entity.getStatus().equals(ProfileStatus.ACTIVE)){
            throw new AppBadException("Profile not active");
        }
        ProfileDTO dto = new ProfileDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setRole(entity.getRole());
        dto.setJwt(JWTUtil.encode(entity.getUsername()
                ,entity.getRole()));
        return dto;
    }

    public CompanyDTO authCompany(AuthDTO auth, AppLanguage language) {
        Optional<CompanyEntity> optional = companyRepository.findByUsernameAndPassword(auth.getUsername(),
                MDUtil.encode(auth.getPassword()));

        if (optional.isEmpty()) {
            //   String message = resourceBundleMessageSource.getMessage("email.password.wrong", null, new Locale(language.name()));
            throw new AppBadException(resourceBundleService.getMessage("email.password.wrong",language));
        }

        CompanyEntity entity = optional.get();
        CompanyDTO dto = new CompanyDTO();
        dto.setName(entity.getName());

        dto.setJwt(JWTUtil.encodeCompany(entity.getUsername()
                ,entity.getRole()));
        return dto;
    }
    }

