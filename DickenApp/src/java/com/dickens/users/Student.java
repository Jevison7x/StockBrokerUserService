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

import static com.dickens.users.Student.STUDENT;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:13:59 PM
 */
@Entity
@Table(name = STUDENT)
public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private String userId;
    private String imgName;
    private String name;
    private String matricNumber;
    @Column(name = STU_PASSWORD)
    private String encrytedPassword;
    private String faculty;
    private String department;
    private String level;
    private String votingPin;

    public Student()
    {
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMatricNumber()
    {
        return matricNumber;
    }

    public void setMatricNumber(String matricNumber)
    {
        this.matricNumber = matricNumber;
    }

    public String getEncrytedPassword()
    {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword)
    {
        this.encrytedPassword = encrytedPassword;
    }

    public String getFaculty()
    {
        return faculty;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getVotingPin()
    {
        return votingPin;
    }

    public void setVotingPin(String votingPin)
    {
        this.votingPin = votingPin;
    }

    public static final String STUDENT = "users";
    public static final String STU_ID = "userId";
    public static final String STU_NAME = "name";
    public static final String STU_MAT_NUMBER = "matricNumber";
    public static final String STU_PASSWORD = "password";
    public static final String STU_FACULTY = "faculty";
    public static final String STU_DEPARTMENT = "department";
    public static final String STU_LEVEL = "level";
    public static final String STU_VOTING_PIN = "votingPin";
    public static final String STU_IMG_NAME = "imgName";

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }
}
