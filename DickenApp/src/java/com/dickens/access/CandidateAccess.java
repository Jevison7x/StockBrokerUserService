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
package com.dickens.access;

import static com.dickens.access.CandidateAccess.PIN;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:28:17 PM
 */
@Entity
@Table(name = PIN)
public class CandidateAccess implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private String sn;
    private String pinId;
    private String status;
    private Timestamp dateIssued;
    private Timestamp dateUsed;
    private String usedBy;

    public CandidateAccess()
    {
    }

    public String getSn()
    {
        return sn;
    }

    public void setSn(String sn)
    {
        this.sn = sn;
    }

    public String getPinId()
    {
        return pinId;
    }

    public void setPinId(String pinId)
    {
        this.pinId = pinId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Timestamp getDateIssued()
    {
        return dateIssued;
    }

    public void setDateIssued(Timestamp dateIssued)
    {
        this.dateIssued = dateIssued;
    }

    public Timestamp getDateUsed()
    {
        return dateUsed;
    }

    public void setDateUsed(Timestamp dateUsed)
    {
        this.dateUsed = dateUsed;
    }

    public String getUsedBy()
    {
        return usedBy;
    }

    public void setUsedBy(String usedBy)
    {
        this.usedBy = usedBy;
    }

    public static final String PIN = "pin";
    public static final String S_N = "sn";
    public static final String PIN_ID = "pinId";
    public static final String STATUS = "status";
    public static final String DATE_ISSUED = "dateIssued";
    public static final String DATE_USED = "dateUsed";
    public static final String USED_BY = "usedBy";
}
