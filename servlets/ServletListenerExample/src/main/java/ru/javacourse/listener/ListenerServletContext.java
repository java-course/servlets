package ru.javacourse.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerServletContext implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ListenerServletContext.contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ListenerServletContext.contextDestroyed");
    }
}
