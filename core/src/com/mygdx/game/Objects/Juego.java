package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.mygdx.game.Cosingas;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
                Cosingas.renderizador.irAPantallaJuego();
                break;
            case "GOKU":
                //AQUÍ IRIA EL METODO PARA CAMBIAR LA SKIN DEL PJ
                System.out.println("AVERESEGOKU");
                break;
            case "FURRIE":
                System.out.println("F U R R I E");
                break;
            case "LEE":
                System.out.println("LEE");
                break;
            case "JACKSON":
                System.out.println("JACKSON");
                break;
            case "PATE":
                System.out.println("PATE");
                break;
            case "PUSSOLINI":
                System.out.println("PUSSOLINI");
                break;
        }
    }

    public void jugarCarta(){}
}
