package com.examen.restControllers;

import com.examen.entities.Company;
import com.examen.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CompanyController {
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){

        return companyService.addCompany(company);

    }
}
