package org.example.uzcarrd.repository;

import org.example.uzcarrd.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends
        JpaRepository<CompanyEntity,Integer> {
    Optional<CompanyEntity> findByUsernameAndPassword(String username, String encode);
    Optional<CompanyEntity>findByUsername(String username);

}
