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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author BLAZE
 * @since Jan 19, 2023 1:07:02 AM
 */
public class RandomString
{

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private int stringLength;

    public RandomString(int stringLength)
    {
        this.stringLength = stringLength;
    }

    public List<String> generateRandomStrings(int numberOfStrings)
    {
        List<String> randomStrings = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfStrings; i++)
        {
            StringBuilder randomString = new StringBuilder();
            for(int j = 0; j < stringLength; j++)
            {
                int randomIndex = random.nextInt(CHAR_LIST.length());
                randomString.append(CHAR_LIST.charAt(randomIndex));
            }
            randomStrings.add(randomString.toString());
        }
        return randomStrings;
    }
}
