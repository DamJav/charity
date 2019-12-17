package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.DonationDataDTO;

public interface DonationService {
    void createDonation(DonationDataDTO donationDataDTO);
}
