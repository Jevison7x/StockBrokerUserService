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
package com.dickens.election;

import static com.dickens.election.ElectionDate.ELECTION_DATE;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:31:13 PM
 */
@Entity
@Table(name = ELECTION_DATE)
public class ElectionDate implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String session;
    private Timestamp startDate;
    private Timestamp endDate;
    private String status;

    public ElectionDate()
    {
    }

    public Timestamp getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Timestamp startDate)
    {
        this.startDate = startDate;
    }

    public Timestamp getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Timestamp endDate)
    {
        this.endDate = endDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSession()
    {
        return session;
    }

    public void setSession(String session)
    {
        this.session = session;
    }

    public static final String ELECTION_DATE = "electiondate";
    public static final String ELECTION_ID = "id";
    public static final String SESSION = "session";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String STATUS = "status";
}
