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
package com.dickens.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 2:06:15 PM
 */
public class DBConfiguration implements AutoCloseable
{
    public static EntityManagerFactory remoteEntityManagerFactory;

    private EntityManager entityManager;

    public DBConfiguration()
    {
        this.entityManager = createEntityManager();
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public static EntityManager createEntityManager()
    {
        try
        {
            return remoteEntityManagerFactory.createEntityManager();
        }
        catch(PersistenceException xcp)
        {
            throw new RuntimeException(xcp);
        }
    }

    @Override
    public void close() throws Exception
    {
        this.entityManager.close();
    }
}
