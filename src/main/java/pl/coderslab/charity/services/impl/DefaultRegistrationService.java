package pl.coderslab.charity.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.services.RegistrationService;
@Service
@Transactional
public class DefaultRegistrationService implements RegistrationService {
    @Override
    public void register(RegistrationDataDTO registrationDataDTO) {

    }
}
