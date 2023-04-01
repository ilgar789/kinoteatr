package com.cinema.service.user;

import com.cinema.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long userId);

    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    List<User> usergtList(Long idMin);
}
