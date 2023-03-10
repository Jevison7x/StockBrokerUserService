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
package com.stockBroker.userService.dto;

/**
 *
 * @author BLAZE
 * @since Mar 10, 2023 5:45:11 PM
 */
public class UpdateUserStockDTO
{
    private String username;
    private double noOfShares;
    private String companyName;

    public UpdateUserStockDTO()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public double getNoOfShares()
    {
        return noOfShares;
    }

    public void setNoOfShares(double noOfShares)
    {
        this.noOfShares = noOfShares;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
}
