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
package com.bizblock.stockbroker.repository;

import com.bizblock.stockbroker.model.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BLAZE
 * @since Mar 12, 2023 7:50:46 PM
 */
public interface UserRepository extends JpaRepository<User, String>
{

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :newEmail WHERE u.username = :username")
    void updateEmailByUsername(@Param("newEmail") String newEmail, @Param("username") String username);

    User findByUsername(String username);

    User findByEmail(String email);

}
