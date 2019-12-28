package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.RegistrationDataDTO;

public interface RegistrationService {
    void register(RegistrationDataDTO registrationDataDTO);
    void registerAdmin(RegistrationDataDTO registrationDataDTO);
}
