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

import com.stockBroker.userService.dto.UserStockRequest;
import com.stockBroker.userService.model.UserStock;
import com.stockBroker.userService.repository.UserStockRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author BLAZE
 */
@Service
public class UserStockService
{
    private final UserStockRepository userStockRepository;

    public UserStockService(UserStockRepository userStockRepository)
    {
        this.userStockRepository = userStockRepository;
    }

    public void createNewUserStock(UserStockRequest userStockRequest)
    {
        UserStock userStock = new UserStock();
        userStock.setCompanyName(userStockRequest.getCompanyName());
        userStock.setCompanySharesOwned(userStockRequest.getCompanySharesOwned());
        userStock.setUser(userStockRequest.getUser());

        userStockRepository.save(userStock);
    }

    public void updateCompanySharesOwned(UserStock userStock)
    {
        userStockRepository.updateUserShares(userStock.getCompanySharesOwned(), userStock.getUser().getUsername(), userStock.getCompanyName());
    }
}
