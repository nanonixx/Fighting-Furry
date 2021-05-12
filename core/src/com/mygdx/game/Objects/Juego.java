package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.mygdx.game.Cosingas;
import main.java.Mensaje;

import java.security.CodeSigner;

public class Juego {
    Mano mano;


//    public void alConectar(){
//        //Cosingas.renderizador.mostrarMensaje("CONECTADO");
//        Cosingas.cliente.enviar(new Mensaje("READY"));
//    }

    public void desconectar(WebSocketCloseCode code, String reason){}

    public void mensaje(Mensaje mensaje){
        switch (mensaje.action) {
            case "ready_ok":
                Cosingas.renderizador.mostrarMensaje("CONECTADO");
                break;
            case "start":
                Cosingas.renderizador.irAPantallaJuego();
                Cosingas.renderizador.pjSeleccionado(mensaje.gato, mensaje.gato2);
                Cosingas.renderizador.ponerCartas(Mano.fromMensaje(mensaje.mano));
                break;

            default:
                System.out.println(mensaje.action);
        }
    }

    public void jugarCarta(){

    }

    public void ready(String pjSeleccionado) {
        Cosingas.cliente.enviar(Mensaje.ready(pjSeleccionado));
    }
}
