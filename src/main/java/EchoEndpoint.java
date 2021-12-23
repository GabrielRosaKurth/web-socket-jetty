import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

@WebSocket
public class EchoEndpoint {

    @OnWebSocketConnect
    public void onConnect(Session session) throws IOException {
        session.getRemote().sendString("Handshake ECHO ok... sessão aberta");
        System.out.println("Handshake ECHO OK: " + session);
    }

}
