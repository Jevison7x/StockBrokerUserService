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
package com.bizblock.user;

import static com.bizblock.user.UserStock.*;
import com.bizblock.user.database.DBConfiguration;
import com.bizblock.user.util.RandomNumberGenerator;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Mar 13, 2023 12:40:15 PM
 */
public class UserStockDAO
{
    public static void registerNewUserStock(UserStock userStock) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(userStock);
            em.getTransaction().commit();
        }
    }

    public static UserStock getUserStockByUserNameAndCompanyName(String userName, String companyName) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + USER_STOCKS + " WHERE " + USER_NAME + " = ? AND " + COMPANY_NAME + " = ?";
            Query q = em.createNativeQuery(sql, User.class);
            q.setParameter(1, userName);
            q.setParameter(2, companyName);
            UserStock userStock = (UserStock)q.getSingleResult();
            return userStock;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static void updateUserStock(UserStock userStock)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            userStock = em.find(UserStock.class, userStock.getId());
            em.getTransaction().begin();
            userStock.setNumberOfShares(userStock.getNumberOfShares());
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public static void sellUserStock(String userName, String companyName, int noOfShares) throws Exception
    {
        UserStock userStock = getUserStockByUserNameAndCompanyName(userName, companyName);
        if(userStock != null)
            if(userStock.getNumberOfShares() > 0 && userStock.getNumberOfShares() >= noOfShares)
            {
                int newNumberOfShares = userStock.getNumberOfShares() - noOfShares;
                userStock.setNumberOfShares(newNumberOfShares);
                updateUserStock(userStock);
            }
            else
                throw new IllegalArgumentException("Insufficient stocks");
        else
            throw new IllegalArgumentException("user not found");

    }

    public static void buyUserStock(User user, String userName, String companyName, int noOfShares, String symbol) throws Exception
    {
        UserStock userStock = getUserStockByUserNameAndCompanyName(userName, companyName);
        if(userStock != null)
        {
            int newNumberOfShares = userStock.getNumberOfShares() + noOfShares;
            userStock.setNumberOfShares(newNumberOfShares);
            updateUserStock(userStock);
        }
        else
        {
            UserStock newUserStock = new UserStock();
            newUserStock.setCompanyName(companyName);
            newUserStock.setNumberOfShares(noOfShares);
            newUserStock.setSymbol(symbol);
            newUserStock.setUser(user);
            newUserStock.setId(generateUniqueUserID());
            registerNewUserStock(newUserStock);
        }
    }

    public static String generateUniqueUserID() throws Exception
    {
        String userId = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            User user;
            do
            {
                userId = RandomNumberGenerator.generateRandomAlphanumericCharacters(7, false);
                user = em.find(User.class, userId);
            }
            while(user != null);
            return userId;
        }
    }

    public static List<UserStock> getAllUserStockByUserName(String username) throws Exception
    {

        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + USER_STOCKS + " WHERE " + USER_NAME + " = ?";
            Query q = em.createNativeQuery(sql, UserStock.class);
            q.setParameter(1, username);
            List<UserStock> userStocklist = q.getResultList();
            return userStocklist;
        }
    }
}
