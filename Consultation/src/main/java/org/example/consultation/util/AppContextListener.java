package org.example.consultation.util;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        DataBaseConnection.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (DataBaseConnection.getSessionFactory() != null) {
            DataBaseConnection.getSessionFactory().close();
        }
        System.out.println("Session factory closed");
    }
}
