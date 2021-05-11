package main.java.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mazo {

    static Random random = new Random();
    List<Carta> cartaList = new ArrayList<>();

    Mazo(String gato){
        //HAY QUE AÑADIR AQUI LAS CARTAS PERO VAN EN FUNCIÓN DEL PERSONAJE QUE SE ESCOJA AYUDA
//        ... o no
        cartaList.addAll(Arrays.asList(
                //ataque
                new Carta("zarpazo", 10, 1, "ataque"),
                new Carta("mordisco", 15, 2, "ataque"),
                //defensa
                new Carta("bufido", 10, 1, "defensa"),
                new Carta("enAlerta", 15, 2, "defensa"),
                //curacion
                new Carta("ronroneo", 15, 3, "curacion"),
                new Carta("amasar", 10, 2, "curacion")
        ));

        switch (gato) {
            case "goku":
                cartaList.addAll(Arrays.asList(
                        new Carta("bufido", 10, 1, "defensa"),
                        new Carta("enAlerta", 15, 2, "defensa")
                ));
                break;
        }
    }

    Carta robar(){
        return cartaList.remove(random.nextInt(cartaList.size()));
    }
}
