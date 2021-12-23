import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;

public class Main {

    public static void main (String[] args) throws Exception {
        Server server = new Server(8081);

        ServletContextHandler handler = new ServletContextHandler(server, "/lionx");
        server.setHandler(handler);


        JettyWebSocketServletContainerInitializer.configure(handler, (servletContext, container) ->
        {
            container.addMapping("/test", ServerEndpoint.class);
            container.addMapping("/echo", EchoEndpoint.class);
        });

        server.start();
    }
}
