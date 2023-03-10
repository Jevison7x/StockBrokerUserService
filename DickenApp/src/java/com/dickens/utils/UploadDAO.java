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
package com.dickens.utils;

import com.dickens.database.DBConfiguration;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author BLAZE
 * @since Mar 2, 2023 1:03:01 PM
 */
public class UploadDAO
{
    public static void registerNewStudent(UploadImages ui) throws Exception, EntityExistsException
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {
            EntityManager em = dbConfig.getEntityManager();
            em.getTransaction().begin();
            em.persist(ui);
            em.getTransaction().commit();
        }
    }

    public static String getImages(int id) throws Exception
    {
        try(DBConfiguration dbConfig = new DBConfiguration())
        {

            EntityManager em = dbConfig.getEntityManager();
            String sql = "SELECT * FROM " + UploadImages.IMAGES + " WHERE " + UploadImages.ID + " =?";
            Query q = em.createNativeQuery(sql, UploadImages.class);
            q.setParameter(1, id);
            UploadImages rs = (UploadImages)q.getSingleResult();
            String imageName = rs.getImageName();
            return imageName;
        }
        catch(NoResultException nre)
        {
            return null;
        }
    }
}
