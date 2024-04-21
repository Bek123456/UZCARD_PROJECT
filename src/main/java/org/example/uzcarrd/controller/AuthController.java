package org.example.uzcarrd.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.uzcarrd.dto.AuthDTO;
import org.example.uzcarrd.dto.ProfileDTO;
import org.example.uzcarrd.enums.AppLanguage;
import org.example.uzcarrd.service.AuthService;
import org.example.uzcarrd.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    @Operation( summary = "Api for login", description = "this api used for authorization")
    public ResponseEntity<ProfileDTO> login(@RequestHeader(value = "Accept-Language",
            defaultValue = "uz") AppLanguage language, @RequestBody AuthDTO auth){
        log.trace("Login In Trace");
        log.debug("Login In Debug");
//        log.info("Login {}",auth.getEmail());
//        log.warn("Login {}",auth.getEmail());
//        log.error("Login {}",auth.getEmail());
        ProfileDTO autht = authService.auth(auth,language);
        return ResponseEntity.ok(autht);
    }

//    @PutMapping("/verification/email/{jwt}")
//    public ResponseEntity<String> emailVerification(@PathVariable String jwt) {
//        String s = profileService.emailVerification(jwt,AppLanguage.eng);
//        return ResponseEntity.ok(s);
//    }
}
