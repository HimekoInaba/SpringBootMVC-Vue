package com.syrym.bootvue.bootvue.service;


import com.syrym.bootvue.bootvue.model.User;

public interface UserService {
    User findByUsername(String username);
    User findById(long id);
    void add(User user);
}