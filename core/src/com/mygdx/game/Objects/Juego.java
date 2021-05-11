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
                Cosingas.renderizador.irAPantallaJuego();
                break;
            case "start":
                Cosingas.renderizador.pjSeleccionado(mensaje.gato, mensaje.gato2);
                Cosingas.renderizador.ponerCartas(mensaje.mano);

            case "goku":
                //AQUÍ IRIA EL METODO PARA CAMBIAR LA SKIN DEL PJ
                Cosingas.renderizador.pjSeleccionado("idlegoku");
                System.out.println("AVERESEGOKU");
                break;
            case "furrie":
                Cosingas.renderizador.pjSeleccionado("idlemf");
                System.out.println("F U R R I E");
                break;
            case "lee":
                Cosingas.renderizador.pjSeleccionado("idlelee");
                System.out.println("LEE");
                break;
            case "jackson":
                Cosingas.renderizador.pjSeleccionado("idleheehee");
                System.out.println("JACKSON");
                break;
            case "pate":
                Cosingas.renderizador.pjSeleccionado("idlepate");
                System.out.println("PATE");
                break;
            case "pussolini":
                Cosingas.renderizador.pjSeleccionado("idlepusso");
                System.out.println("PUSSOLINI");
                break;

            case "goku2":
                //AQUÍ IRIA EL METODO PARA CAMBIAR LA SKIN DEL PJ
                Cosingas.renderizador.pjSeleccionado("idlegoku2");
                System.out.println("AVERESEGOKU");
                break;
            case "furrie2":
                Cosingas.renderizador.pjSeleccionado("idlemf2");
                System.out.println("F U R R I E");
                break;
            case "lee2":
                Cosingas.renderizador.pjSeleccionado("idlelee2");
                System.out.println("LEE");
                break;
            case "jackson2":
                Cosingas.renderizador.pjSeleccionado("idleheehee2");
                System.out.println("JACKSON");
                break;
            case "pate2":
                Cosingas.renderizador.pjSeleccionado("idlepate2");
                System.out.println("PATE");
                break;
            case "pussolini2":
                Cosingas.renderizador.pjSeleccionado("idlepusso2");
                System.out.println("PUSSOLINI");
                break;
            case "CARTAS":
                System.out.println("Cartas?????????");
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
