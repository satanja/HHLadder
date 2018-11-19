package IO;

import Main.Main;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.net.InetSocketAddress;
import org.json.*;
import Weapon.*;

public class WebSocketIO extends WebSocketServer {

    private Main main;

    public WebSocketIO(Main main, InetSocketAddress address) {
        super(address);
        this.main = main;
    }

    private JSONObject getJSONLadder(Weapon weapon) {
        return main.ladderToJSON(weapon);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Connected");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Closed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("message received");
        JSONObject json = new JSONObject(s);
        switch (json.getString("command")) {
            case "ladder":
                Weapon epee = new Epee();
                webSocket.send(getJSONLadder(epee).toString());
                break;
        }
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
