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

import com.dickens.database.DBConfiguration;
import com.dickens.security.DigestMatcher;
import com.dickens.security.Digester;
import com.dickens.utils.RandomNumberGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Feb 25, 2023 10:48:11 PM
 */
public class UserDAO
{
    public static void registerNewStudent(Student student) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    public static void registerNewCandidate(Candidate candidate) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(candidate);
            em.getTransaction().commit();
        }
    }

    public static void registerNewElecoAdmin(ElecoAdmin elecoAdmin) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(elecoAdmin);
            em.getTransaction().commit();
        }
    }

    public static String generateUniqueStudentId() throws Exception
    {
        String studentId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Student student;
            do
            {
                studentId = RandomNumberGenerator.generateRandomAlphanumericCharacters(6, false);
                student = em.find(Student.class, studentId);
            }
            while(student != null);
            return studentId;
        }
    }

    public static String generateUniqueStudentVotingPin() throws Exception
    {
        String votinPin = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Student student;
            do
            {
                votinPin = RandomNumberGenerator.generateRandomAlphanumericCharacters(9, false);
                student = em.find(Student.class, votinPin);
            }
            while(student != null);
            return votinPin;
        }
    }

    public static String generateUniqueAdminPin() throws Exception
    {
        String adminId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            ElecoAdmin admin;
            do
            {
                adminId = RandomNumberGenerator.generateRandomAlphanumericCharacters(8, false);
                admin = em.find(ElecoAdmin.class, adminId);
            }
            while(admin != null);
            return adminId;
        }
    }

    public static String generateUniqueCandidateId() throws Exception
    {
        String candidateId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Candidate candidate;
            do
            {
                candidateId = RandomNumberGenerator.generateRandomAlphanumericCharacters(8, false);
                candidate = em.find(Candidate.class, candidateId);
            }
            while(candidate != null);
            return candidateId;
        }
    }

    public static Student getStudentByMatricNumber(String matNumber) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + Student.STUDENT + " WHERE " + Student.STU_MAT_NUMBER + " = ?";
            Query q = em.createNativeQuery(sql, Student.class);
            q.setParameter(1, matNumber);
            Student student = (Student)q.getSingleResult();
            return student;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static Student loginStudent(String matNumber, String password) throws Exception
    {
        Student student = getStudentByMatricNumber(matNumber);
        if(student != null)
        {
            DigestMatcher matcher = new DigestMatcher();
            String salt = matcher.getSalt(student.getEncrytedPassword());
            boolean matched = matcher.doMatch(password, salt);
            if(matched)
            {
                student.setEncrytedPassword(null);
                return student;
            }
            else
                return null;
        }
        else
            return null;
    }

    public static ElecoAdmin getElecoAdminByUsername(String username) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + ElecoAdmin.ELECO_ADMIN + " WHERE " + ElecoAdmin.USERNAME + " = ?";
            Query q = em.createNativeQuery(sql, ElecoAdmin.class);
            q.setParameter(1, username);
            ElecoAdmin elecoAdmin = (ElecoAdmin)q.getSingleResult();
            return elecoAdmin;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static ElecoAdmin loginAdmin(String username, String password) throws Exception
    {
        ElecoAdmin elecoAdmin = getElecoAdminByUsername(username);
        if(elecoAdmin != null)
        {
            DigestMatcher matcher = new DigestMatcher();
            String salt = matcher.getSalt(elecoAdmin.getEncrytedPassword());
            boolean matched = matcher.doMatch(password, salt);
            if(matched)
            {
                elecoAdmin.setEncrytedPassword(null);
                return elecoAdmin;
            }
            else
                return null;
        }
        else
            return null;
    }

    public static Candidate getCandidateByName(String name) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + Candidate.CANDIDATE + " WHERE " + Candidate.CANDIDATE_NAME + " = ?";
            Query q = em.createNativeQuery(sql, Candidate.class);
            q.setParameter(1, name);
            Candidate candidate = (Candidate)q.getSingleResult();
            return candidate;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static Candidate loginCandidate(String name, String password) throws Exception
    {
        Candidate candidate = getCandidateByName(name);
        if(candidate != null)
        {
            DigestMatcher matcher = new DigestMatcher();
            String salt = matcher.getSalt(candidate.getEncrytedPasword());
            boolean matched = matcher.doMatch(password, salt);
            if(matched)
            {
                candidate.setEncrytedPasword(null);
                return candidate;
            }
            else
                return null;
        }
        else
            return null;
    }

    public static List<Candidate> getAllCandidates() throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT * FROM " + Candidate.CANDIDATE, Candidate.class);
            List<Candidate> candidates = q.getResultList();
            return candidates;
        }
    }

    public static List<Candidate> getAllCandidatesByPosition(String position) throws Exception
    {

        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createQuery("SELECT c FROM Candidate c WHERE c.position = :position");
            q.setParameter("position", position);
            List<Candidate> candidates = q.getResultList();
            return candidates;
        }
    }

    public static Map<String, Integer> getCandidateVoteCounts() throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            Query q = em.createNativeQuery("SELECT p.canId, COUNT(*) FROM presidency  p GROUP BY p.canId");
            List<Object[]> results = q.getResultList();
            Map<String, Integer> voteCounts = new HashMap<>();
            for(Object[] result : results)
            {
                String candidateName = (String)result[0];
                Long count = (Long)result[1];
                voteCounts.put(candidateName, count.intValue());
            }
            return voteCounts;
        }
    }

    public static void updateCandidateDetails(Candidate user, String imgName, String manifesto) throws Exception
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(Candidate.class, user.getCanId());
            em.getTransaction().begin();
            user.setImgName(imgName);
            user.setManifesto(manifesto);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
        finally
        {
            em.close();
        }
    }

    public static void updateCandidatePassword(Candidate user, String newPassword)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(Candidate.class, user.getCanId());
            em.getTransaction().begin();
            Digester digester = new Digester();
            String hashedPassword = digester.doDigest(newPassword);
            user.setEncrytedPasword(hashedPassword);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public static Student getStudentByName(String name) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + Student.STUDENT + " WHERE " + Student.STU_NAME + " = ?";
            Query q = em.createNativeQuery(sql, Student.class);
            q.setParameter(1, name);
            Student student = (Student)q.getSingleResult();
            return student;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static void updateStudentDetails(Student user, String imgName, String faculty, String department, String level, String matNumber) throws Exception
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(Student.class, user.getUserId());
            em.getTransaction().begin();
            user.setImgName(imgName);
            user.setFaculty(faculty);
            user.setDepartment(department);
            user.setLevel(level);
            user.setMatricNumber(matNumber);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
        finally
        {
            em.close();
        }
    }

    public static void updateStudentPassword(Student user, String newPassword)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(Student.class, user.getUserId());
            em.getTransaction().begin();
            Digester digester = new Digester();
            String hashedPassword = digester.doDigest(newPassword);
            user.setEncrytedPassword(hashedPassword);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public static void updateElecoAdminPassword(ElecoAdmin user, String newPassword)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(ElecoAdmin.class, user.getAdminId());
            em.getTransaction().begin();
            Digester digester = new Digester();
            String hashedPassword = digester.doDigest(newPassword);
            user.setEncrytedPassword(hashedPassword);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public static void updateAdminPicture(ElecoAdmin user, String imgName) throws Exception
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            user = em.find(ElecoAdmin.class, user.getAdminId());
            em.getTransaction().begin();
            user.setImgName(imgName);
            em.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            throw new RuntimeException(e);
        }
        finally
        {
            em.close();
        }
    }
}
