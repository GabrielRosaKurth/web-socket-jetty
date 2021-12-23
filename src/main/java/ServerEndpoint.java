import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;

@WebSocket
public class ServerEndpoint {

    // TODO utilizar lista para mandar um broadcast caso necessário
//    private static List<Session> sessions = new ArrayList<>();

    @OnWebSocketConnect
    public void onOpen (Session session) throws IOException {
        System.out.println("[SERVER] - Conexão aberta> " + session.getRemoteAddress());
        //        sessions.add(session);
        //        session.getRemote().sendString("Handshake ok... sessão aberta");
    }

    @OnWebSocketClose
    public void onClose (Session session, int status, String reason) throws IOException {
        //        sessions.remove(session);

        System.out.println("[SERVER] - Conexão fechada");
    }

    @OnWebSocketMessage
    public void onMessage (Session session, String message) throws IOException {
        System.out.println("[SERVER] - Mensagem recebida: " + message);

//        BROADCAST
//        sessions.forEach(ss -> {
//            try {
//                ss.getRemote().sendString("BROADCAST> " + message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

        session.getRemote().sendString("Sua mensagem foi recebida com sucesso!");
    }

}
