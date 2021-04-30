package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.mygdx.game.Cosingas;
import main.java.Mensaje;

public class Juego {
    Mano mano;


    public void conectar(){
        Cosingas.renderizador.mostrarMensaje("CONECTADO");
    }

    public void desconectar(WebSocketCloseCode code, String reason){}

    public void mensaje(Mensaje mensaje){
        if(mensaje.action.equals("START")){
            Cosingas.renderizador.mostrarMensaje("EMPIESA");
        }
    }

    public void jugarCarta(){}
}
