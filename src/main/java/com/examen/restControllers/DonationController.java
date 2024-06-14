package com.examen.restControllers;

import com.examen.entities.Donation;
import com.examen.entities.DonationType;
import com.examen.services.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@RestController
public class DonationController {
    private DonationService donationService;

    @PostMapping("/donations")
    public Donation addDonation(@RequestBody Donation donation) {
        return donationService.addDonation(donation);
    }

    @GetMapping("/type/{type}")
    public Set<Donation> getDonationByType(@PathVariable DonationType type) {
        return donationService.getDonationByType(type);
    }

    @GetMapping("/totalDonation")
    public Float getTotalDonation(
            @RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
            @RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
        return donationService.getTotalDonation(date1, date2);
    }
}
