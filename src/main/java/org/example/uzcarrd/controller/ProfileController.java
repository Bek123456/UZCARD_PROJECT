package org.example.uzcarrd.controller;

import org.example.uzcarrd.dto.ProfileDTO;
import org.example.uzcarrd.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
     @Autowired
    private ProfileService profileService;
     @PostMapping("/created1")
    public ResponseEntity<String>created1(@RequestBody ProfileDTO dto){

     }
}
