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
package com.stockBroker.userService.controller;

import com.stockBroker.userService.dto.BuyStockDTO;
import com.stockBroker.userService.dto.TransactionDto;
import com.stockBroker.userService.dto.UpdateUserStockDTO;
import com.stockBroker.userService.dto.UserStockRequest;
import com.stockBroker.userService.model.User;
import com.stockBroker.userService.model.UserStock;
import com.stockBroker.userService.service.UserService;
import com.stockBroker.userService.service.UserStockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BLAZE
 */
@RestController
@RequestMapping("/api/user-stocks")
public class UserStockController
{
    private final UserStockService userStockService;

    private final UserService userService;

    public UserStockController(UserStockService userStockService, UserService userService)
    {
        this.userStockService = userStockService;
        this.userService = userService;
    }

    @PostMapping("/create-new")
    @ResponseStatus(HttpStatus.CREATED)
    public String createNewUserStock(@RequestBody UserStockRequest userStockRequest)
    {
        userStockService.createNewUserStock(userStockRequest);
        return "user created successfully";
    }

    @PostMapping("/update-stock")
    @ResponseStatus(HttpStatus.OK)
    public String updateUserStock(@RequestBody UpdateUserStockDTO updateUserStockDTO)
    {
        User user = userService.getUserByUsername(updateUserStockDTO.getUsername());
        UserStock userStock = new UserStock();
        userStock.setCompanySharesOwned(updateUserStockDTO.getNoOfShares());
        userStock.setUser(user);
        userStock.setCompanyName(updateUserStockDTO.getCompanyName());
        userStockService.updateCompanySharesOwned(userStock);
        return "yup, u be bad guy";
    }

    @PostMapping("/sell-stock")
    @ResponseStatus(HttpStatus.OK)
    public String sellUserStocks(@RequestBody TransactionDto td)
    {
        userStockService.sellTransactionStuff(td);
        return "yup, u hv made a sell";
    }

    @PostMapping("/buy-stock")
    @ResponseStatus(HttpStatus.OK)
    public String BuyUserStocks(@RequestBody BuyStockDTO bsdto)
    {
        userStockService.buyTransactionStuff(bsdto.getTransactionDto(), bsdto.getUserStockRequest());
        return "yup, u hv made a buy";
    }
}
