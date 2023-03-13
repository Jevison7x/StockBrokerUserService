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

import static com.bizblock.user.UserToken.USER_TOKEN;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Mar 13, 2023 2:27:47 PM
 */
@Entity
@Table(name = USER_TOKEN)
public class UserToken implements Serializable
{
    private String userName;
    @Id
    private String token;
    private Timestamp expiryDate;
    private int lifeSpan;

    public UserToken()
    {
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public Timestamp getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public int getLifeSpan()
    {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan)
    {
        this.lifeSpan = lifeSpan;
    }

    public static final String USER_TOKEN = "userTokens";
    public static final String USER_NAME = "userName";
    public static final String TOKEN = "token";
    public static final String EXPIRY_DATE = "expiryDate";
    public static final String LIFE_SPAN = "lifeSpan";
}
