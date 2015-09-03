package ru.javacourse.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListenerHttpSession implements HttpSessionListener {

    int count;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("ListenerHttpSession.sessionCreated");
        count++;
        System.out.println("visit count = " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("ListenerHttpSession.sessionDestroyed");
    }
}
