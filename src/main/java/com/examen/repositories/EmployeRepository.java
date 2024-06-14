package com.examen.repositories;

import com.examen.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("SELECT e, COUNT(d) " +
            "FROM Employe e LEFT JOIN e.donations d " +
            "WHERE d.date >= :startDate AND d.date <= :endDate " +
            "GROUP BY e")
    List<Object[]> findEmployeDonationCounts(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
