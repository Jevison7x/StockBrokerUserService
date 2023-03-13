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

import static com.bizblock.user.User.USER_NAME;
import static com.bizblock.user.UserToken.USER_TOKEN;
import com.bizblock.user.database.DBConfiguration;
import com.bizblock.user.util.RandomNumberGenerator;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Mar 13, 2023 2:31:02 PM
 */
public class UserTokenDAO
{
    public static void registerNewUserToken(UserToken userToken) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(userToken);
            em.getTransaction().commit();
        }
    }

    public static UserToken getUserTokenByUserName(String userName) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + USER_TOKEN + " WHERE " + USER_NAME + " = ?  ";
            Query q = em.createNativeQuery(sql, UserToken.class);
            q.setParameter(1, userName);
            UserToken userToken = (UserToken)q.getSingleResult();
            return userToken;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }

    public static String generateUniqueUserToken() throws Exception
    {
        String token = null;
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            UserToken userToken;
            do
            {
                token = RandomNumberGenerator.generateRandomAlphanumericCharacters(100, true);
                userToken = em.find(UserToken.class, token);
            }
            while(userToken != null);
            return token;
        }
    }

    public static void updateUserTokenExpiryDateAndLifeSpan(UserToken userToken)
    {
        EntityManager em = DBConfiguration.createEntityManager();
        try
        {
            userToken = em.find(UserToken.class, userToken.getToken());
            em.getTransaction().begin();
            userToken.setExpiryDate(userToken.getExpiryDate());
            userToken.setLifeSpan(userToken.getLifeSpan());
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }
}
