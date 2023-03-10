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

import static com.dickens.election.DOIRun.DOI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:37:39 PM
 */
@Entity
@Table(name = DOI)
public class DOIRun implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String canId;
    private String votingPin;

    public DOIRun()
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

    public String getVotingPin()
    {
        return votingPin;
    }

    public void setVotingPin(String votingPin)
    {
        this.votingPin = votingPin;
    }

    public String getCanId()
    {
        return canId;
    }

    public void setCanId(String canId)
    {
        this.canId = canId;
    }
    public static final String DOI = "doi";
    public static final String ID = "id";
    public static final String CAN_ID = "canId";
    public static final String VOTING_PIN = "votingPin";
}
