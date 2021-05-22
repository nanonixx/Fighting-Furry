package com.mygdx.game.Objects;

import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mano extends MyActor {

    public List<Carta> cartaList = new ArrayList<>();

    public int dx = 300;
    public int dy = 2;

    public Mano(List<Carta> mano) {
        this.cartaList = mano;

        //setSize(,); tamaño de la mano en pantalla
        //animacion
    }

    Mensaje.Mano toMensaje(){
        return new Mensaje.Mano(cartaList.stream().map(Carta::toMensaje).toArray(Mensaje.Carta[]::new));
    }

    public static Mano fromMensaje(Mensaje.Mano mano){
        return new Mano(Arrays.stream(mano.cartaList).map(Carta::fromMensaje).collect(Collectors.toList()));
    }
    //
}
