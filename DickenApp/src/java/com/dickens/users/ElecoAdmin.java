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
package com.dickens.users;

import static com.dickens.users.ElecoAdmin.ELECO_ADMIN;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:14:47 PM
 */
@Entity
@Table(name = ELECO_ADMIN)
public class ElecoAdmin implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private String adminId;
    private String imgName;
    private String username;
    @Column(name = PASSWORD)
    private String encrytedPassword;
    private String role;

    public ElecoAdmin()
    {
    }

    public String getAdminId()
    {
        return adminId;
    }

    public void setAdminId(String adminId)
    {
        this.adminId = adminId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEncrytedPassword()
    {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword)
    {
        this.encrytedPassword = encrytedPassword;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public static final String ELECO_ADMIN = "admin";
    public static final String ADMIN_ID = "adminId";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String IMG_NAME = "imgName";
    public static final String ROLE = "role";

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }
}
