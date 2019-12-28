package pl.coderslab.charity.services;

import pl.coderslab.charity.entities.User;

public interface UpdateUserService {
    void updateAdmin(User user);
    void updateUser(User user);
}
