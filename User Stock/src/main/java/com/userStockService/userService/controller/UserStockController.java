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
package com.userStockService.userService.controller;

import com.userStockService.userService.dto.BuyStockDTO;
import com.userStockService.userService.dto.TransactionDTO;
import com.userStockService.userService.service.UserService;
import com.userStockService.userService.service.UserStockService;
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

    public UserStockController(UserStockService userStockService, UserService userService)
    {
        this.userStockService = userStockService;
    }

    @PostMapping("/sell-stock")
    @ResponseStatus(HttpStatus.OK)
    public String sellUserStocks(@RequestBody TransactionDTO td)
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
