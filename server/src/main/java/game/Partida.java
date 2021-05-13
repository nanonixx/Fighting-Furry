package main.java.game;

import jakarta.websocket.Session;

public class Partida {
    public boolean turnoBool;
    Jugador jugador1, jugador2;
    Jugador turno;

    public boolean faltaJugador() {
        return jugador1 == null || jugador2 == null;
    }

    public Jugador anyadirJugador(Session session, String gato) {
        if(jugador1 == null) {
            jugador1 = new Jugador(session, gato);
            jugador1.torn = true;
            return jugador1;
        }
        else if(jugador2 == null && jugador1.session != session) {
            jugador2 = new Jugador(session, gato);
            jugador2.torn = false;
            jugador2.oponente = jugador1;
            jugador1.oponente = jugador2;

            return jugador2;
        }
        return null;
    }

    //metodo repartir cartas
    public void repartirCartasIniciales() {
        jugador1.robar();
        jugador1.robar();
        jugador1.robar();

        jugador2.robar();
        jugador2.robar();
        jugador2.robar();

        turno = jugador1;
        turnoBool = false;
    }
    //metodo hacerJugada (ataque, defensa, restar vida rival..etc)

}
