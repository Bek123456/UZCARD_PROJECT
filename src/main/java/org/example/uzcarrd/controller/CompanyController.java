package org.example.uzcarrd.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.uzcarrd.dto.CompanyDTO;
import org.example.uzcarrd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/create1")
    public ResponseEntity<String>create1(@RequestBody CompanyDTO dto){
       return ResponseEntity.ok(companyService.create1(dto));
    }
    @PostMapping("/created")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String>created(@RequestBody CompanyDTO dto){
       return ResponseEntity.ok(companyService.create1(dto));
    }
}
