package org.raj.Servlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Embedded Tomcat");

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);

        // Provide a non-null base directory for the context
        Context context = tomcat.addContext("", new File(".").getAbsolutePath());

        Tomcat.addServlet(context, "h1", new HelloServlet());
        context.addServletMappingDecoded("/hello", "h1");

        try {
            tomcat.start();
            System.out.println("Tomcat started on port 8082.");
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
