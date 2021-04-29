package main.java.game;
import jakarta.websocket.Session;
import main.java.Mensaje;


public class Jugador {

    public Jugador oponente;
    int vida;
    Mano mano = new Mano();
    Session session;

    public Jugador(Session session) {
        this.session = session;
        this.vida = 100;
    }

    void send(Mensaje mensaje) {
        try {
            session.getBasicRemote().sendObject(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarCartas() {
        send(new Mensaje("CARTAS", mano.toMensaje()));
    }

}
