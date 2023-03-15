 
package com.bizblock.user.database;

import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Praise
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
