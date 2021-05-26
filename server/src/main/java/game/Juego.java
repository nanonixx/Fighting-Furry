package main.java.game;

import jakarta.websocket.Session;
import main.java.Mensaje;
import java.util.HashMap;
import java.util.Map;

public class Juego {
    Map<String, Partida> partidaMap = new HashMap<>();
    Partida partida = new Partida();
    String background;
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

                        background = "fondos/fondo_"+(int)(Math.random() * 11)+".png";

                        partida.jugador1.send(Mensaje.start(partida.jugador1.gato, partida.jugador2.gato, partida.jugador1.mano.toMensaje(), background));
                        partida.jugador2.send(Mensaje.start(partida.jugador2.gato, partida.jugador1.gato, partida.jugador2.mano.toMensaje(), background));

                        if(partida.turnoBool == partida.jugador1.torn){
                            partida.jugador1.send(Mensaje.setTurno(true));
                            partida.jugador2.send(Mensaje.setTurno(false));
                        }
                        else{
                            partida.jugador2.send(Mensaje.setTurno(true));
                            partida.jugador1.send(Mensaje.setTurno(false));
                        }
                    }
                }
            break;
            case "jugada":

                System.out.println("llega la carta");
                if(cliente.equals(partida.jugador1.session)){
                    //partida.jugador1.mano.cartaList.removeIf(c -> c.nombre.equals(mensaje.carta.nombre));
                    for (Carta c:partida.jugador1.mano.cartaList) {
                        if(c.nombre.equals(mensaje.carta.nombre)){
                            partida.jugador1.mano.cartaList.remove(c);
                            break;
                        }
                    }
                    partida.jugador2.send(Mensaje.jugadaOk(mensaje.carta, mensaje.furiadanyo));
                } else{
                    //partida.jugador2.mano.cartaList.removeIf(c -> c.nombre.equals(mensaje.carta.nombre));
                    for (Carta c:partida.jugador2.mano.cartaList) {
                        if(c.nombre.equals(mensaje.carta.nombre)){
                            partida.jugador2.mano.cartaList.remove(c);
                            break;
                        }
                    }
                    partida.jugador1.send(Mensaje.jugadaOk(mensaje.carta, mensaje.furiadanyo));
                }
                //aqui habria que enviar al rival un mensaje.jugadaOk() que de los datos de la jugada que ha hecho el otro
                break;

            case "cambiarTurno":
                partida.turnoBool = !partida.turnoBool;
                if(partida.turnoBool == partida.jugador1.torn){
                    for (int i = partida.jugador1.mano.cartaList.size(); i < 3; i++) {
                        partida.jugador1.mano.cartaList.add(partida.jugador1.mazo.robar());
                    }
                    partida.jugador1.send(Mensaje.refillMano(partida.jugador1.mano.toMensaje()));
                    partida.jugador1.send(Mensaje.setTurno(true));
                    partida.jugador2.send(Mensaje.setTurno(false));
                }
                else{
                    for (int i = partida.jugador2.mano.cartaList.size(); i < 3; i++) {
                        partida.jugador2.mano.cartaList.add(partida.jugador2.mazo.robar());
                    }
                    partida.jugador2.send(Mensaje.refillMano(partida.jugador2.mano.toMensaje()));
                    partida.jugador2.send(Mensaje.setTurno(true));
                    partida.jugador1.send(Mensaje.setTurno(false));
                }
                break;

        }
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