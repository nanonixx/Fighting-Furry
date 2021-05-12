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
                new Carta("zarpazo","", 10, 1, "ataque"),
                new Carta("mordisco","", 15, 2, "ataque"),
                //defensa
                new Carta("bufido","", 10, 1, "defensa"),
                new Carta("enAlerta","", 15, 2, "defensa"),
                //curacion
                new Carta("ronroneo","", 15, 3, "curacion"),
                new Carta("amasar","", 10, 2, "curacion")
        ));

        switch (gato) {
            case "goku":
                cartaList.addAll(Arrays.asList(
                        new Carta("canvi de lloc instantani","",0, 3, "especial"),
                        new Carta("kame","", 25, 3, "especial")
                ));
                break;
            case "jackson":
                cartaList.addAll(Arrays.asList(
                        new Carta("heehee","", 0, 3, "especial"),
                        new Carta("antigravity lean","", 5, 1, "especial")
                ));
                break;
            case "pate":
                cartaList.addAll(Arrays.asList(
                        new Carta("cabezazo","", 5, 2, "especial"),
                        new Carta("pisoton","", 0, 1, "especial")
                ));
                break;
            case "pussolini":
                cartaList.addAll(Arrays.asList(
                        new Carta("autocracia","", 0, 2, "especial"),
                        new Carta("pacto de acero","", 3, 3, "especial")
                ));
                break;
            case "lee":
                cartaList.addAll(Arrays.asList(
                        new Carta("patada voladora","", 25, 3, "especial"),
                        new Carta("furia oriental","", 5, 2, "especial")
                ));
                break;
            case "furrie":
                cartaList.addAll(Arrays.asList(
                        new Carta("vomito radioactivo","", 3, 3, "especial"),
                        new Carta("polonio o plomo","", 15, 3, "especial")
                ));
                break;
        }
    }

    Carta robar(){
        return cartaList.get(random.nextInt(cartaList.size()));
    }
}
