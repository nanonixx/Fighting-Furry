package main.java;

import jakarta.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

import javax.swing.*;
import java.awt.*;


public class Main extends JPanel {

    String host;
    Server server;

    public static void main(String[] args) throws DeploymentException {
        new Main().init();
    }

    void init() {
        try {
            startServer();
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame();

        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.setSize(200, 80);

        JButton btnReset = new JButton("RESET SERVER");
        frame.getContentPane().add(btnReset);
        btnReset.addActionListener(e -> {
            try {
                server.stop();
                startServer();
            } catch (DeploymentException deploymentException) {
                deploymentException.printStackTrace();
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void startServer() throws DeploymentException {
        host = "localhost";
        server = new Server(host, 12345, "/", null, ServidorEndpoint.class);
        server.start();

    }
}