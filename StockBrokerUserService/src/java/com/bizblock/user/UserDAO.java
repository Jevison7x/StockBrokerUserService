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

import static com.bizblock.user.User.*;
import com.bizblock.user.database.DBConfiguration;
import com.bizblock.user.security.DigestMatcher;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Mar 13, 2023 12:31:28 PM
 */
public class UserDAO
{

    public static void registerNewUser(User user) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    public static User loginUser(String userName, String password) throws Exception
    {
        User user = getUserByUserNameOrEmail(userName);
        if(user != null)
        {
            DigestMatcher matcher = new DigestMatcher();
            String salt = matcher.getSalt(user.getEncrytedPassword());
            boolean matched = matcher.doMatch(password, salt);
            if(matched)
            {
                user.setEncrytedPassword(null);
                return user;
            }
            else
                return null;
        }
        else
            return null;
    }

    public static User getUserByUserNameOrEmail(String userNameOrEmail) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + USERS + " WHERE " + EMAIL + " = ? OR " + USER_NAME + " = ?";
            Query q = em.createNativeQuery(sql, User.class);
            q.setParameter(1, userNameOrEmail);
            q.setParameter(2, userNameOrEmail);
            User user = (User)q.getSingleResult();
            return user;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }
}
