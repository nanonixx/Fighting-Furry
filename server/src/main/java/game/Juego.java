package main.java.game;

import jakarta.websocket.Session;
import main.java.Mensaje;

import java.util.HashMap;
import java.util.Map;

public class Juego {
    Map<String, Partida> partidaMap = new HashMap<>();
    Partida partida = new Partida();

    public void onOpen(Session cliente) {}

    public void onClose(Session cliente) {}

    public void onError(Session session) {}

    public void onMessage(Session cliente, Mensaje mensaje) {
        switch(mensaje.action){
            case "READY":
                if (partida.faltaJugador()){
                    partida.anyadirJugador(cliente);

                    if(!partida.faltaJugador()) {
                        partida.jugador1.send(new Mensaje("START"));
                        partida.jugador2.send(new Mensaje("START"));
                        partida.repartirCartasIniciales();

                        partida.jugador1.enviarCartas();
                        partida.jugador2.enviarCartas();
                    }
                }
            break;
            //PARA SABER EL PJ QUE SE SELECCIONA

            default:
                if(cliente == partida.jugador1.session)
                    partida.jugador1.send(new Mensaje(mensaje.action));
                else
                    partida.jugador2.send(new Mensaje(mensaje.action));
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
