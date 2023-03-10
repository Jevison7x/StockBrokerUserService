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

import static com.dickens.utils.UploadImages.IMAGES;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BLAZE
 * @since Mar 2, 2023 12:24:56 PM
 */
@Entity
@Table(name = IMAGES)
public class UploadImages implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String imageName;

    public UploadImages()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }

    public static final String IMAGES = "images";
    public static final String ID = "id";
    public static final String IMAGE_NAME = "imageName";
}
