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
package com.bizblock.user.database;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Jevison7x
 */
public class ContextListener implements ServletContextListener
{
    public ContextListener()
    {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext context = sce.getServletContext();
        context.setAttribute("con", new ContextListener());
        this.loadEntityManagerFactory();
    }

    private void loadEntityManagerFactory()
    {
        DBConfiguration.remoteEntityManagerFactory = Persistence.createEntityManagerFactory("StockBrokerPU");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}
