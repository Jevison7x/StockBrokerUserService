/*
 * Copyright (c) 2018, Xyneex Technologies. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * You are not meant to edit or modify this source code unless you are
 * authorized to do so.
 *
 * Please contact Xyneex Technologies, #1 Orok Orok Street, Calabar, Nigeria.
 * or visit www.xyneex.com if you need additional information or have any
 * questions.
 */
package com.userStockService.userService.service;

import com.userStockService.userService.dto.LoginDTO;
import com.userStockService.userService.dto.UserRequest;
import com.userStockService.userService.model.User;
import com.userStockService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author BLAZE
 */
@Service
public class UserService
{

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createNewUser(UserRequest userRequest)
    {
        if(userRepository.findByUsername(userRequest.getUsername()) != null)
            throw new IllegalArgumentException("Username already exists for another user");
        else if(userRepository.findByEmail(userRequest.getEmail()) != null)
            throw new IllegalArgumentException("Email already exists for another user");
        else
        {
            User user = new User();
            user.setEmail(userRequest.getEmail());
            user.setUsername(userRequest.getUsername());
            String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
            user.setPassword(encodedPassword);

            userRepository.save(user);
        }

    }

    public void updateUserDetails(User userUpdateTo)
    {
        if(userRepository.findByEmail(userUpdateTo.getEmail()) != null)
            throw new IllegalArgumentException("Email already exists for another user");
        else
            userRepository.updateEmailByUsername(userUpdateTo.getEmail(), userUpdateTo.getUsername());
    }

    public User getUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public User loginUser(LoginDTO loginDTO)
    {
        User user = getUserByUsername(loginDTO.getUsername());
        if(user != null)
            if(passwordEncoder.matches(loginDTO.getPassword(), user.getPassword()))
                return user;
            else
                throw new IllegalArgumentException("Wrong user Input");
        return null;
    }
}
