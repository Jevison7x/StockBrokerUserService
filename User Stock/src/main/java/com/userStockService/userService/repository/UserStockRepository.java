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
package com.userStockService.userService.repository;

import com.userStockService.userService.model.User;
import com.userStockService.userService.model.UserStock;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author BLAZE
 * @since Mar 12, 2023 7:52:05 PM
 */
public interface UserStockRepository extends JpaRepository<UserStock, Long>
{
    @Modifying
    @Transactional
    @Query("UPDATE UserStock us SET us.companySharesOwned = :newShares WHERE us.user = :user AND us.companyName = :companyName")
    void updateUserShares(@Param("newShares") double newShares, @Param("user") User username, @Param("companyName") String companyName);

    UserStock findByCompanyNameAndUserUsername(String companyName, String username);
}
