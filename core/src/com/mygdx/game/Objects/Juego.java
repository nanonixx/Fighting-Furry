package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import main.java.Mensaje;

public class Juego {
    Mano mano;
    Renderizador renderizador;

    public void conectar(){
        renderizador.mostrarMensaje("CONECTADO");
    }

    public void desconectar(WebSocketCloseCode code, String reason){}

    public void mensaje(Mensaje mensaje){
        if(mensaje.action.equals("START")){
            renderizador.mostrarMensaje("EMPIESA");
        }
    }

    public void jugarCarta(){}
}
