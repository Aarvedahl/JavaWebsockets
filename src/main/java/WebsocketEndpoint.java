


import com.sun.xml.internal.ws.wsdl.writer.document.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat")
public class WebsocketEndpoint{

    @OnOpen
    public void onOpen(Session session) throws IOException {
        // Get session and Websocket connection
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException {
        // Hnadles new messages
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // Websocket connection close
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling
    }

}
