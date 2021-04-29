package main.java.game;

import jakarta.websocket.Session;
import main.java.Mensaje;

import java.util.HashMap;
import java.util.Map;

public class Partida {
    Jugador jugador1, jugador2;
    Mazo mazo = new Mazo();
    Jugador turno;

    public boolean faltaJugador() {
        return jugador1 == null || jugador2 == null;
    }

    public void anyadirJugador(Session session) {
        if(jugador1 == null) {
            jugador1 = new Jugador(session);
        }
        else if(jugador2 == null) {
            jugador2 = new Jugador(session);

            jugador2.oponente = jugador1;
            jugador1.oponente = jugador2;
        }
    }

    //metodo repartir cartas
    public void repartirCartasIniciales() {
        jugador1.mano.cartaList.add(mazo.robar());
        jugador1.mano.cartaList.add(mazo.robar());
        jugador1.mano.cartaList.add(mazo.robar());

        jugador2.mano.cartaList.add(mazo.robar());
        jugador2.mano.cartaList.add(mazo.robar());
        jugador2.mano.cartaList.add(mazo.robar());

        turno = jugador1;
    }
    //metodo hacerJugada (ataque, defensa, restar vida rival..etc)

}
