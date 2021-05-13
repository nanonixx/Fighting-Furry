package com.mygdx.game.Objects;

import com.github.czyzby.websocket.data.WebSocketCloseCode;
import com.mygdx.game.Cosingas;
import main.java.Mensaje;

public class Juego {


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
                Cosingas.renderizador.torn = mensaje.turno;
                break;

            default:
                System.out.println(mensaje.action);
        }
    }

    public void jugarCarta(Carta carta, Gatito activo, Gatito rival){
        switch (carta.tipo){
            case "ataque":
                 rival.salud -= carta.valor;
                break;

            case "defensa":
                activo.defensa += carta.valor;
                break;

            case "curacion":
                activo.salud += carta.valor;
                break;

            case "especial":

                switch (carta.nombre){
                    case "canvi de lloc instantani":
                    //TODO
                        break;

                    case "heehee":
                    //TODO
                        break;

                    case "antigravity lean":
                        activo.atBoost = carta.valor;
                        break;

                    case "cabezazo":
                        rival.atBoost = carta.valor;
                        //comprobar que si el ataque es menos de 5 no
                        // le suba vida al otro, se queda en 0
                        break;

                    case "pisoton":
                    //TODO
                        break;

                    case "pacto de acero":
                        activo.defBoost = carta.valor;
                        break;

                    case "furia oriental":
                        rival.salud -= 3 + Math.random() * 5;
                        //entre 3 y 5 de damage
                        break;

                    case "vomito radioactivo":
                        rival.envenenado = true;
                        break;

                    case "polonio o plomo":
                        if (rival.envenenado) rival.salud -= 25;
                        else rival.salud -= carta.valor;
                        break;
                }

            break;
        }

    }

    public void ready(String pjSeleccionado) {
        Cosingas.cliente.enviar(Mensaje.ready(pjSeleccionado));
    }
}
