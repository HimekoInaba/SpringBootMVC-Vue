package com.syrym.bootvue.bootvue.service;

import com.syrym.bootvue.bootvue.model.Roles;
import com.syrym.bootvue.bootvue.model.User;
import com.syrym.bootvue.bootvue.repository.RolesRepository;
import com.syrym.bootvue.bootvue.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Roles> roles = new HashSet<>();
        roles.add(rolesRepository.getOne(2L));
        user.setRoles(roles);
    }
}
