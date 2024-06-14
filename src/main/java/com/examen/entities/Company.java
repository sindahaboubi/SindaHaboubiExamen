package com.examen.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long companyId;
    private String companyName;
    private String adress;
    @OneToMany(mappedBy = "company")
    private Set<Employe> employes;
}
