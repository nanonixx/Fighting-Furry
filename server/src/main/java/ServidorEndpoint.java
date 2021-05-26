package main.java;


import com.google.gson.Gson;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import main.java.game.Juego;

@ServerEndpoint(value = "/", encoders = ServidorEndpoint.MyEncoder.class, decoders = ServidorEndpoint.MyDecoder.class)
public class ServidorEndpoint {
    static Gson gson = new Gson();
    static Juego juego;
    boolean firstOpen = true;

    public ServidorEndpoint() {
        juego = new Juego();
    }

    @OnOpen
    public void onOpen(Session cliente) {
        if (firstOpen) {
            System.out.println("FIRST OPEN");
            juego = new Juego();
            firstOpen = false;
        }
    }


    @OnMessage
    public void onMessage(Session cliente, Mensaje mensaje) {
        System.out.println("MENSAJE DE " + cliente.getId() + " => " + mensaje.action);
        juego.onMessage(cliente, mensaje);
    }


    public static class MyEncoder implements Encoder.Text<Mensaje> {
        @Override
        public String encode(Mensaje mensaje) {
            return gson.toJson(mensaje);
        }

        @Override
        public void init(EndpointConfig config) {}

        @Override
        public void destroy() {}
    }

    public static class MyDecoder implements Decoder.Text<Mensaje> {
        @Override
        public void init(EndpointConfig config) {}

        @Override
        public void destroy() {}

        @Override
        public Mensaje decode(String s) {
            return gson.fromJson(s, Mensaje.class);
        }

        @Override
        public boolean willDecode(String s) {
            return (s != null);
        }
    }

}
