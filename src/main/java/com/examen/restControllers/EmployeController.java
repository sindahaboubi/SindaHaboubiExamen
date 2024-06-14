package com.examen.restControllers;

import com.examen.entities.Employe;
import com.examen.services.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class EmployeController {

    private EmployeService employeService;

    @PostMapping("/addEmployeAndAssignToCompany/{companyName}")
    public Employe addEmployeAndAssignToCompany (@RequestBody Employe employe, @PathVariable String companyName){
        return employeService.addEmployeAndAssignToCompany(employe, companyName);
    }
}
