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
package com.stockBroker.userService.service;

import com.stockBroker.userService.dto.LoginDTO;
import com.stockBroker.userService.dto.UserRequest;
import com.stockBroker.userService.model.User;
import com.stockBroker.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BLAZE
 */
@Service
public class UserService
{
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void createNewUser(UserRequest userRequest)
    {
        if(userRepository.existsById(userRequest.getUsername()))
            throw new IllegalArgumentException("Username already exists for another user");
        else if(userRepository.existsById(userRequest.getEmail()))
            throw new IllegalArgumentException("Email already exists for another user");
        else
        {
            User user = new User();
            user.setEmail(userRequest.getEmail());
            user.setUsername(userRequest.getUsername());
            user.setPassword(userRequest.getPassword());

            userRepository.save(user);
        }

    }

    public void updateUserDetails(User userUpdateTo)
    {
        if(userRepository.existsById(userUpdateTo.getUsername()))
            throw new IllegalArgumentException("Username already exists for another user");
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
            if(!user.getPassword().equals(loginDTO.getPassword()))
                return null;
            else
                return user;
        else
            return null;
    }
}
