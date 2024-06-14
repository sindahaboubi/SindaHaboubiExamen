package com.examen.services;

import com.examen.entities.Donation;
import com.examen.entities.DonationType;
import com.examen.entities.Employe;
import com.examen.repositories.DonationRepository;
import com.examen.repositories.EmployeRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {
    private DonationRepository donationRepository;
    private EmployeRepository employeRepository;

    /*@Override
    public Donation addDonation(Donation donation) {
        if (donation.getType() == DonationType.MINETARY) {
            if (donation.getAmont() == null || donation.getAmont() <= 0) {
                throw new IllegalArgumentException("For monetary donations, the amount must be specified and greater than zero.");
            }
        } else {
            donation.setAmont(0f);
        }
        return donationRepository.save(donation);
    }*/

    @Override
    public Donation addDonation(Donation donation) {
        if (donation.getType() == DonationType.MINETARY) {
            if (donation.getAmont() == null || donation.getAmont() <= 0) {
                throw new IllegalArgumentException("For monetary donations, the amount must be specified and greater than zero.");
            }
        } else {
            donation.setAmont(0f);
        }

        Donation savedDonation = donationRepository.save(donation);
        System.out.println("Merci pour ce don");
        return savedDonation;
    }

    @Override
    public Set<Donation> getDonationByType(DonationType type) {
        return donationRepository.findByType(type).stream()
                .sorted(Comparator.comparing(Donation::getDate))
                .collect(Collectors.toSet());
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void getEmployeByDonation() {
        LocalDate now = LocalDate.now();
        YearMonth currentMonth = YearMonth.of(now.getYear(), now.getMonth());

        Map<Employe, Long> employeDonationCounts = employeRepository.findEmployeDonationCounts(currentMonth.atDay(1), currentMonth.atEndOfMonth())
                .stream()
                .collect(Collectors.toMap(
                        obj -> (Employe) obj[0],
                        obj -> (Long) obj[1]
                ));

        Optional<Map.Entry<Employe, Long>> bestEmployee = employeDonationCounts.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        bestEmployee.ifPresentOrElse(
                entry -> System.out.println("Meilleur employé du mois : " + entry.getKey().getFirstName() + " " + entry.getKey().getLastName() +
                        ", Nombre de donations : " + entry.getValue()),
                () -> System.out.println("Aucune donation enregistrée ce mois !!!")
        );
    }

    @Override
    public Float getTotalDonation(Date date1, Date date2) {
        return donationRepository.getTotalDonationAmount(date1, date2);
    }

}
