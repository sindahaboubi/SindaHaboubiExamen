package com.examen.repositories;

import com.examen.entities.Company;
import com.examen.entities.Donation;
import com.examen.entities.DonationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Set;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    Set<Donation> findByType(DonationType type);
    @Query("SELECT COALESCE(SUM(d.amont), 0) " +
            "FROM Donation d " +
            "WHERE d.date >= :date1 AND d.date <= :date2")
    Float getTotalDonationAmount(
            @Param("date1") Date date1,
            @Param("date2") Date date2);

}
