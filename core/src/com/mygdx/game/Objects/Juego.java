package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.mygdx.game.Cosingas;
import main.java.Mensaje;

public class Juego {
    Mano mano;


    public void alConectar(){
        //Cosingas.renderizador.mostrarMensaje("CONECTADO");
        Cosingas.cliente.enviar(new Mensaje("READY"));
    }

    public void desconectar(WebSocketCloseCode code, String reason){}

    public void mensaje(Mensaje mensaje){
        switch (mensaje.action) {
            case "START":
                Cosingas.renderizador.mostrarMensaje("CONECTADO");
                Cosingas.renderizador.irAPantallJuego();
                break;

            case "":
                break;
        }
    }

    public void jugarCarta(){}
}
