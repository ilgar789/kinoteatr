package com.cinema.service.user;

import com.cinema.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    List<User> usergtList(Long idMin);
}
