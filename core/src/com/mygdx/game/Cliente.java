package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.github.czyzby.websocket.AbstractWebSocketListener;
import com.github.czyzby.websocket.WebSocket;
import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.github.czyzby.websocket.data.WebSocketException;
import com.github.czyzby.websocket.net.ExtendedNet;
import main.java.Mensaje;

public class Cliente {

    private WebSocket socket;
    static Json json = new Json();

    public void conectar(){

        String host = "localhost";

        if (Cosingas.ipAddress != null) {
            host = Cosingas.ipAddress;
        }

        socket = ExtendedNet.getNet().newWebSocket(host, 12345);

        socket.addListener(new AbstractWebSocketListener() {

            @Override
            public boolean onOpen(final WebSocket webSocket) {
                //Cosingas.juego.alConectar();
                return FULLY_HANDLED;
            }

            @Override
            public boolean onClose(final WebSocket webSocket, final WebSocketCloseCode code, final String reason) {
//                Cosingas.juego.desconectar(code, reason);
                return FULLY_HANDLED;
            }

            @Override
            public boolean onMessage(final WebSocket webSocket, final String packet) {
                Gdx.app.postRunnable(() -> Cosingas.juego.mensaje(json.fromJson(Mensaje.class, packet)));
                return FULLY_HANDLED;
            }

            @Override
            protected boolean onMessage(WebSocket webSocket, Object packet) throws WebSocketException {
                return false;
            }
        });

        try {
            socket.connect();
        } catch (Exception e){
            System.out.println("NO SE PUDO CONECTAR AL SERVIDOR");
        }
    }

    public void enviar(Mensaje mensaje){
        socket.send(json.toJson(mensaje));
    }
}
