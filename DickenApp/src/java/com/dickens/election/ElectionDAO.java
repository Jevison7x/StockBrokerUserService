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

import com.dickens.database.DBConfiguration;
import com.dickens.utils.RandomNumberGenerator;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Feb 27, 2023 11:45:02 PM
 */
public class ElectionDAO
{
    public static void registerNewDOI(DOIRun doi) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(doi);
            em.getTransaction().commit();
        }
    }

    public static void registerNewDOS(DOSRun dos) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(dos);
            em.getTransaction().commit();
        }
    }

    public static void registerNewDOSp(DOSpRun dosp) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(dosp);
            em.getTransaction().commit();
        }
    }

    public static void registerNewDOW(DOWRun dow) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(dow);
            em.getTransaction().commit();
        }
    }

    public static void registerNewElectionDate(ElectionDate ed) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(ed);
            em.getTransaction().commit();
        }
    }

    public static void registerNewFS(FSRun fs) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(fs);
            em.getTransaction().commit();
        }
    }

    public static void registerNewPresido(PresidentRun presido) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(presido);
            em.getTransaction().commit();
        }
    }

    public static void registerNewSG(SGRun sg) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(sg);
            em.getTransaction().commit();
        }
    }

    public static void registerNewVP(VPRun vp) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(vp);
            em.getTransaction().commit();
        }
    }

    public static boolean votingPinExistsInPresido(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + PresidentRun.PRESIDENCY + " WHERE " + PresidentRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniquePresidoID() throws Exception
    {
        String presidoId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            PresidentRun presido;
            do
            {
                presidoId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                presido = em.find(PresidentRun.class, presidoId);
            }
            while(presido != null);
            return presidoId;
        }
    }

    public static boolean votingPinExistsInVP(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + VPRun.VP + " WHERE " + VPRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueVpID() throws Exception
    {
        String vpId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            VPRun vp;
            do
            {
                vpId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                vp = em.find(VPRun.class, vpId);
            }
            while(vp != null);
            return vpId;
        }
    }

    public static boolean votingPinExistsInSG(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + SGRun.SG + " WHERE " + SGRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueSGID() throws Exception
    {
        String sgId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            SGRun sg;
            do
            {
                sgId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                sg = em.find(SGRun.class, sgId);
            }
            while(sg != null);
            return sgId;
        }
    }

    public static boolean votingPinExistsInDOS(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + DOSRun.DOS + " WHERE " + DOSRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueDOSID() throws Exception
    {
        String dosId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            DOSRun dos;
            do
            {
                dosId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                dos = em.find(DOSRun.class, dosId);
            }
            while(dos != null);
            return dosId;
        }
    }

    public static boolean votingPinExistsInDOSp(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + DOSpRun.DOSP + " WHERE " + DOSpRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueDOSpID() throws Exception
    {
        String dospId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            DOSpRun dosp;
            do
            {
                dospId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                dosp = em.find(DOSpRun.class, dospId);
            }
            while(dosp != null);
            return dospId;
        }
    }

    public static boolean votingPinExistsInDOW(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + DOWRun.DOW + " WHERE " + DOWRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueDOWID() throws Exception
    {
        String dowId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            DOWRun dow;
            do
            {
                dowId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                dow = em.find(DOWRun.class, dowId);
            }
            while(dow != null);
            return dowId;
        }
    }

    public static boolean votingPinExistsInDOI(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + DOIRun.DOI + " WHERE " + DOIRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueDoiID() throws Exception
    {
        String doiId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            DOIRun doi;
            do
            {
                doiId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                doi = em.find(DOIRun.class, doiId);
            }
            while(doi != null);
            return doiId;
        }
    }

    public static boolean votingPinExistsInFS(String votingPin) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + FSRun.FS + " WHERE " + FSRun.VOTING_PIN + " = ?");
            q.setParameter(1, votingPin);
            q.getSingleResult();
            return true;
        }
        catch(NoResultException xcp)
        {
            return false;
        }
    }

    public static String generateUniqueFSID() throws Exception
    {
        String fsId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            FSRun fs;
            do
            {
                fsId = RandomNumberGenerator.generateRandomAlphanumericCharacters(2, false);
                fs = em.find(FSRun.class, fsId);
            }
            while(fs != null);
            return fsId;
        }
    }

}
