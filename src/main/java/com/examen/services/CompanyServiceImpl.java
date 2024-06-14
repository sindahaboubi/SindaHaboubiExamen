package com.examen.services;

import com.examen.entities.Company;
import com.examen.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;
    @Override
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
}
