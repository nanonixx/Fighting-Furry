package main.java.game;

import jakarta.websocket.Session;
import main.java.Mensaje;

import java.util.HashMap;
import java.util.Map;

public class Juego {
    Map<String, Partida> partidaMap = new HashMap<>();
    Partida partida = new Partida();
    String pj1;
    String pj2;

    public void onMessage(Session cliente, Mensaje mensaje) {
        switch(mensaje.action){
            case "ready":
                if (partida.faltaJugador()){
                    Jugador jugador = partida.anyadirJugador(cliente, mensaje.gato);

                    if(jugador != null){
                        jugador.send(Mensaje.readyOk());
                    }

                    if(!partida.faltaJugador()) {
                        partida.repartirCartasIniciales();

                        partida.jugador1.send(Mensaje.start(partida.jugador1.gato, partida.jugador2.gato, partida.jugador1.mano.toMensaje(), partida.turnoBool));
                        partida.jugador2.send(Mensaje.start(partida.jugador2.gato, partida.jugador1.gato, partida.jugador2.mano.toMensaje(), partida.turnoBool));
                    }
                }
            break;
            //PARA SABER EL PJ QUE SE SELECCIONA

            default:
                if(cliente == partida.jugador1.session){
                    pj1 = mensaje.action;
                }
                else
                    pj2 = mensaje.action;

                if((pj1 != null) && (pj2 != null)){

                    partida.jugador1.send(new Mensaje(pj1));
                    partida.jugador1.send(new Mensaje(mensaje.action + "2"));

                    partida.jugador2.send(new Mensaje(pj1));
                    partida.jugador2.send(new Mensaje(pj2 + "2"));
                }

                break;

//            case "goku":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("GOKU"));
//                else
//                    partida.jugador2.send(new Mensaje("GOKU"));
//                break;
//
//            case "furrie":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("FURRIE"));
//                else
//                    partida.jugador2.send(new Mensaje("FURRIE"));
//                break;
//            case "lee":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("LEE"));
//                else
//                    partida.jugador2.send(new Mensaje("LEE"));
//                break;
//            case "jackson":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("JACKSON"));
//                else
//                    partida.jugador2.send(new Mensaje("JACKSON"));
//                break;
//            case "pate":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("PATE"));
//                else
//                    partida.jugador2.send(new Mensaje("PATE"));
//                break;
//            case "pussolini":
//                if(cliente == partida.jugador1.session)
//                    partida.jugador1.send(new Mensaje("PUSSOLINI"));
//                else
//                    partida.jugador2.send(new Mensaje("PUSSOLINI"));
//                break;
        }
//        else if (mensaje.action.equals("JUGADA")){
//            partida.hacerJugada(cliente, new Carta(mensaje.carta));
//            partida.jugador1.send(new Mensaje("VIDAS", new int[]{partida.jugador1.vida, partida.jugador2.vida}));
//            partida.jugador2.send(new Mensaje("VIDAS", new int[]{partida.jugador1.vida, partida.jugador2.vida}));
//        }
    }
}

/*

ready (pers="goku") ->
                    <-  ready_ok
                                                    <-  ready (pers="merie")
                     <-  start (p2, 4cartas, turno)
                         start (p1, 4cartas, turno)  ->
tirada(carta) ->
               <-   tirada_ok(resultado, turno)  ->

                                                    tirada(carta)

 */