package pl.coderslab.charity.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dtos.RegistrationDataDTO;
import pl.coderslab.charity.entities.Role;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.RoleRepository;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.UpdateUserService;

@Service
@Transactional
public class DefaultUpdateUserService implements UpdateUserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultUpdateUserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void updateAdmin(User user) {
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_ADMIN");
        user.getRoles().add(roleUser);
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        userRepository.save(user);
    }
}

