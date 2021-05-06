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
                Cosingas.renderizador.irAPantallaJuego();
                break;
            case "GOKU":
                //AQUÍ IRIA EL METODO PARA CAMBIAR LA SKIN DEL PJ
                Cosingas.renderizador.pjSeleccionado("idlegoku");
                System.out.println("AVERESEGOKU");
                break;
            case "FURRIE":
                Cosingas.renderizador.pjSeleccionado("idlemf");
                System.out.println("F U R R I E");
                break;
            case "LEE":
                Cosingas.renderizador.pjSeleccionado("idlelee");
                System.out.println("LEE");
                break;
            case "JACKSON":
                Cosingas.renderizador.pjSeleccionado("idleheehee");
                System.out.println("JACKSON");
                break;
            case "PATE":
                Cosingas.renderizador.pjSeleccionado("idlepate");
                System.out.println("PATE");
                break;
            case "PUSSOLINI":
                Cosingas.renderizador.pjSeleccionado("idlepusso");
                System.out.println("PUSSOLINI");
                break;
        }
    }

    public void jugarCarta(){}
}
