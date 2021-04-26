import jakarta.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

import javax.swing.*;
import java.awt.*;


public class Main extends JPanel {
    public static void main(String[] args) throws DeploymentException {
        new Main().init();
    }

    void init() throws DeploymentException {
//        String host = "192.168.246.246";
//        String host = "192.168.1.100";
        String host = "localhost";
//        new Server("localhost", 12345, "/", null, ServidorEndpoint.class).start();
        new Server(host, 12345, "/", null, ServidorEndpoint.class).start();

        JFrame frame = new JFrame();

        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setSize(200, 80);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}