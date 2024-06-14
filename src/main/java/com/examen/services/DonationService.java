package com.examen.services;

import com.examen.entities.Donation;
import com.examen.entities.DonationType;

import java.util.Date;
import java.util.Set;

public interface DonationService {
    Donation addDonation(Donation donation);
    Set<Donation> getDonationByType(DonationType type);
    void getEmployeByDonation();

    Float getTotalDonation(Date date1, Date date2);

}
