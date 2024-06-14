package com.examen.services;

import com.examen.entities.Company;
import com.examen.entities.Employe;
import com.examen.repositories.CompanyRepository;
import com.examen.repositories.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService{
    private CompanyRepository companyRepository;
    private EmployeRepository employeRepository;
    @Override
    public Employe addEmployeAndAssignToCompany(Employe employe, String companyName) {
        Company company = companyRepository.findByCompanyName(companyName);
        employe.setCompany(company);
        return employeRepository.save(employe);
    }
}
