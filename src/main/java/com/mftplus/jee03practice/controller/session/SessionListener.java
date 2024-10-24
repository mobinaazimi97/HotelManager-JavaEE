package com.mftplus.jee03practice.controller.session;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private static int visited;
    private static int online;
    private static Boolean logOut;
    private static int offline;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        visited++;
        online++;
        System.out.printf("session created : {online : %s} , {visited : %s}%n", online, visited);



    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        online--;
        offline++;
        logOut = true ;
        System.out.printf("session destroyed : {visited : %s},{logOut : %s},{offline : %s},{online : %s} %n", visited,online);


    }
}
