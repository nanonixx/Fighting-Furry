package main.java.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {

    static Random random = new Random();
    List<Carta> cartaList = new ArrayList<>();

    Mazo(){
        //HAY QUE AÑADIR AQUÍ LAS CARTAS PERO VAN EN FUNCIÓN DEL PERSONAJE QUE SE ESCOJA AYUDA
    }

    Carta robar(){
        return cartaList.remove(random.nextInt(cartaList.size()));
    }
}
