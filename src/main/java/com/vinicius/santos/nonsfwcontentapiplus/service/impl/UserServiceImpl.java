package com.vinicius.santos.nonsfwcontentapiplus.service.impl;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.User;
import com.vinicius.santos.nonsfwcontentapiplus.repository.UserRepository;
import com.vinicius.santos.nonsfwcontentapiplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
