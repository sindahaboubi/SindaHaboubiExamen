package com.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Employe implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long employeID;
    private String lastName;
    private String firstName;
    private String position;
    @ManyToOne
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "employe")
    private Set<Donation> donations;
}
