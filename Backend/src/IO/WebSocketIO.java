package IO;

import Main.Main;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import org.json.*;


public class WebSocketIO extends WebSocketServer {

    public WebSocketIO(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Connected");
        sendExampleJSON(webSocket);
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Closed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("message received");
        System.out.println(s);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.err.println("an error occurred on connection " + webSocket.getRemoteSocketAddress()  + ":" + e);
    }

    @Override
    public void onStart() {
        System.out.println("server started successfully");
    }

    public static void main(String[]    args) {
        String host = "localhost";
        int port = 4242;
        WebSocketServer server = new WebSocketIO(new InetSocketAddress(host, port));
        server.run();
    }

    /**
     * Example method for sending JSON messages to the frontend
     * @param webSocket The WebSocket connection
     */
    public void sendExampleJSON(WebSocket webSocket) {
        JSONObject json = new JSONObject();
        json.put("success", true);
        String jsonMessage = json.toString();
        webSocket.send(jsonMessage);
    }
}
