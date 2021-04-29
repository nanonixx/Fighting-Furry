package main.java.game;

import main.java.Mensaje;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    public List<Carta> cartaList = new ArrayList<>();

    Mensaje.Mano toMensaje(){
        return new Mensaje.Mano(cartaList.stream().map(Carta::toMensaje).toArray(Mensaje.Carta[]::new));
    }

    public boolean tieneCarta(Carta carta){
        for (Carta c:cartaList) {
            if(c.nombre.equals(carta.nombre) && c.valor == carta.valor){
                return true;
            }
        }
        return false;
    }
}
