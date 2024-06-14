package com.examen.services;

import com.examen.entities.Employe;

public interface EmployeService {
    public Employe addEmployeAndAssignToCompany(Employe employe, String companyName);
}
