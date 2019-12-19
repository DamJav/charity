package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dtos.DonationDataDTO;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.services.DonationService;


@Service
@Transactional
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;

    public DefaultDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;

    }


    @Override
    public void createDonation(DonationDataDTO donationDataDTO) {
        ModelMapper mapper = new ModelMapper();
        Donation donation = mapper.map(donationDataDTO, Donation.class);
        donationRepository.save(donation);
    }
}
