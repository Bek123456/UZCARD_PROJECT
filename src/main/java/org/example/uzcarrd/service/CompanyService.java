package org.example.uzcarrd.service;

import org.example.uzcarrd.dto.CompanyDTO;
import org.example.uzcarrd.entity.CompanyEntity;
import org.example.uzcarrd.exp.AppBadException;
import org.example.uzcarrd.repository.CompanyRepository;
import org.example.uzcarrd.util.MDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public String create1(CompanyDTO dto) {
        Optional<CompanyEntity> byUsername = companyRepository.findByUsername(dto.getUsername());
        if (!byUsername.isEmpty()){
            throw new AppBadException("bunday companya mavjud mazgi");
        }
        companyRepository.save(toDo(dto));
        return "created company";
    }
    public CompanyEntity toDo(CompanyDTO dto){
        CompanyEntity companyEntity=new CompanyEntity();
        companyEntity.setName(dto.getName());
        companyEntity.setRole(dto.getRole());
        companyEntity.setCode(dto.getCode());
        companyEntity.setContact(dto.getContact());
        companyEntity.setAddress(dto.getAddress());
        companyEntity.setCreatedDate(LocalDateTime.now());
        companyEntity.setPassword(MDUtil.encode(dto.getPassword()));
        companyEntity.setUsername(dto.getUsername());
        companyEntity.setVisible(dto.getVisible());
        return companyEntity;
    }
}
