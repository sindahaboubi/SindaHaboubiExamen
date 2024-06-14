package com.examen.repositories;

import com.examen.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Company findByCompanyName(String companyName);
}
