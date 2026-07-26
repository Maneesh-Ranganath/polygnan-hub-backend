package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Bootstraps an embedded Jetty server hosting the Jersey REST application.
 * This allows the project to be packaged as a self-contained executable JAR
 * (rather than a WAR deployed to an external servlet container).
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        String portEnv = System.getenv("PORT");
        if (portEnv != null && !portEnv.isEmpty()) {
            port = Integer.parseInt(portEnv);
        }

        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Scan the com.telusco package for JAX-RS annotated resources
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("com.telusco");

        ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(resourceConfig));
        jerseyServlet.setInitOrder(1);
        context.addServlet(jerseyServlet, "/*");

        server.start();
        server.join();
    }
}
