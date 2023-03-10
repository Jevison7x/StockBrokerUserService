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

import com.stockBroker.userService.model.User;

/**
 *
 * @author BLAZE
 * @since Mar 10, 2023 4:30:12 PM
 */
public class UserStockRequest
{
    private User user;
    private String companyName;
    private double companySharesOwned;

    public UserStockRequest()
    {
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public double getCompanySharesOwned()
    {
        return companySharesOwned;
    }

    public void setCompanySharesOwned(double companySharesOwned)
    {
        this.companySharesOwned = companySharesOwned;
    }
}
