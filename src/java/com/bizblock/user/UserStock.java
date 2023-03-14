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
package com.bizblock.user;

import static com.bizblock.user.UserStock.USER_STOCKS;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Mar 13, 2023 12:25:16 PM
 */
@Entity
@Table(name = USER_STOCKS)
public class UserStock implements Serializable
{
    @Id
    private String id;
    private String userName;
    private String symbol;
    private int numberOfShares;
    private String companyName;

    public UserStock()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public int getNumberOfShares()
    {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares)
    {
        this.numberOfShares = numberOfShares;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public static final String USER_STOCKS = "userStocks";
    public static final String ID = "id";
    public static final String USER_NAME = "userName";
    public static final String SYMBOL = "symbol";
    public static final String NUMBER_OF_SHARES = "numberOfShares";
    public static final String COMPANY_NAME = "companyName";

}
