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

import com.dickens.database.DBConfiguration;
import com.dickens.utils.RandomNumberGenerator;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Feb 26, 2023 5:23:14 PM
 */
public class AccessDAO
{
    public static void registerNewPin(CandidateAccess pin) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(pin);
            em.getTransaction().commit();
        }
    }

    public static List<CandidateAccess> getAllPinsCreated() throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + CandidateAccess.PIN, CandidateAccess.class);
            List<CandidateAccess> pinList = q.getResultList();
            return pinList;
        }
    }

    public static void updatePinTable(CandidateAccess pin, String status, Timestamp dateUsed, String usedBy)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            pin = em.find(CandidateAccess.class, pin.getSn());
            em.getTransaction().begin();
            pin.setStatus(status);
            pin.setDateUsed(dateUsed);
            pin.setUsedBy(usedBy);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public static CandidateAccess getPinById(String id) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + CandidateAccess.PIN + " WHERE " + CandidateAccess.PIN_ID + " = ?";
            Query q = em.createNativeQuery(sql, CandidateAccess.class);
            q.setParameter(1, id);
            CandidateAccess pin = (CandidateAccess)q.getSingleResult();
            return pin;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static String generateUniquePinID() throws Exception
    {
        String pin = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            CandidateAccess pinId;
            do
            {
                pin = RandomNumberGenerator.generateRandomAlphanumericCharacters(9, false);
                pinId = em.find(CandidateAccess.class, pin);
            }
            while(pinId != null);
            return pin;
        }
    }

    public static String generateUniqueSnID() throws Exception
    {
        String sn = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            CandidateAccess snId;
            do
            {
                sn = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                snId = em.find(CandidateAccess.class, sn);
            }
            while(snId != null);
            return sn;
        }
    }

    public static boolean pinUsed(String pin)
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createQuery("SELECT COUNT(c) FROM CandidateAccess c WHERE c.pinId = :pin AND c.status = :status");
            q.setParameter("pin", pin);
            q.setParameter("status", "used");
            Long count = (Long)q.getSingleResult();
            return count > 0;
        }
        catch(Exception e)
        {
            // Handle exceptions appropriately, e.g. log them
            return false;
        }
    }

}
