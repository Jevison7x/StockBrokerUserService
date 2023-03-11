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
package com.stockBroker.companyService.controller;

import com.stockBroker.companyService.service.StockBrokerService;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BLAZE
 */
@RestController
@RequestMapping("/api/company-service")
public class StockBrokerController
{
    private final StockBrokerService stockBrokerService;

    private StockBrokerController(StockBrokerService stockBrokerService)
    {
        this.stockBrokerService = stockBrokerService;
    }

    @GetMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateStock() throws IOException
    {
        stockBrokerService.updateStocks();
        return "u too gud to be in this planet";
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public String getName() throws IOException
    {
        String companyName = stockBrokerService.getCompanyName("TSLA");
        return companyName;
    }
}
