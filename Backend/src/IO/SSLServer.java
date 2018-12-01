package IO;


import Main.Main;
import java.net.InetSocketAddress;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.java_websocket.server.DefaultSSLWebSocketServerFactory;

public class SSLServer implements Runnable {

    private Server server;

    public SSLServer(Main main, InetSocketAddress address) {
        server = new Server(main, address);

        String STORETYPE = "JKS";
        String KEYSTORE = "keystore.jks";
        String STOREPASSWORD = "storepassword";
        String KEYPASSWORD = "keypassword";


        File keyFile = new File(KEYSTORE);

        try {
            KeyStore keyStore = KeyStore.getInstance(STORETYPE);
            keyStore.load(new FileInputStream("./Backend/" + keyFile), STOREPASSWORD.toCharArray());

            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance("SunX509");
            keyFactory.init(keyStore, KEYPASSWORD.toCharArray());
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance("SunX509");
            trustFactory.init(keyStore);

            SSLContext sslContext = null;
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyFactory.getKeyManagers(), trustFactory.getTrustManagers(), null);

            server.setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sslContext));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        server.run();
    }
}
