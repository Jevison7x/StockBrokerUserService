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
package com.stockBroker.companyService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Mar 11, 2023 5:31:06 PM
 */
@Entity
@Table(name = "company_service")
public class StockBroker
{
    @Id
    private String companySymbol;
    private String companyName;
    private String companyCurrency;
    private double companySharePrice;
    private double noOfShares;

    public StockBroker()
    {

    }

    public StockBroker(String companySymbol, String companyName, String companyCurrency, double companySharePrice)
    {
        this.companyCurrency = companyCurrency;
        this.companyName = companyName;
        this.companySharePrice = companySharePrice;
        this.companySymbol = companySymbol;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanySymbol()
    {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol)
    {
        this.companySymbol = companySymbol;
    }

    public String getCompanyCurrency()
    {
        return companyCurrency;
    }

    public void setCompanyCurrency(String companyCurrency)
    {
        this.companyCurrency = companyCurrency;
    }

    public double getCompanySharePrice()
    {
        return companySharePrice;
    }

    public void setCompanySharePrice(double companySharePrice)
    {
        this.companySharePrice = companySharePrice;
    }

    public double getNoOfShares()
    {
        return noOfShares;
    }

    public void setNoOfShares(double noOfShares)
    {
        this.noOfShares = noOfShares;
    }
}
