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

import static com.dickens.users.Candidate.CANDIDATE;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:14:16 PM
 */
@Entity
@Table(name = CANDIDATE)
public class Candidate implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private String canId;
    private String imgName;
    private String name;
    @Column(name = PASSWORD)
    private String encrytedPasword;
    private String position;
    private String manifesto;
    private String role;

    public Candidate()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEncrytedPasword()
    {
        return encrytedPasword;
    }

    public void setEncrytedPasword(String encrytedPasword)
    {
        this.encrytedPasword = encrytedPasword;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getManifesto()
    {
        return manifesto;
    }

    public void setManifesto(String manifesto)
    {
        this.manifesto = manifesto;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public static final String CANDIDATE = "candidate";
    public static final String CANDIDATE_ID = "canId";
    public static final String CANDIDATE_NAME = "name";
    public static final String PASSWORD = "password";
    public static final String POSITION = "position";
    public static final String MANIFESTO = "manfesto";
    public static final String IMG_NAME = "imgName";
    public static final String ROLE = "role";

    public String getCanId()
    {
        return canId;
    }

    public void setCanId(String canId)
    {
        this.canId = canId;
    }

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }
}
