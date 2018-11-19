package IO;

import Main.Main;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;


public class WebSocketIO extends WebSocketServer {

    public WebSocketIO(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        webSocket.send("hey");
        System.out.println("Opened");
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
        String host = "192.168.0.121";
        int port = 4242;
        WebSocketServer server = new WebSocketIO(new InetSocketAddress(host, port));
        server.run();
    }
}
