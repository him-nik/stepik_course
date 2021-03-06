package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.GetRequestsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        GetRequestsServlet getRequestsServlet = new GetRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(getRequestsServlet), "/mirror");


        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        System.out.println("Server started");
        server.join();
    }
}
