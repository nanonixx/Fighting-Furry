package com.mygdx.game.Objects;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

public class Carta extends MyActor {
    String nombre;
    String descripcion;
    int coste_mana;

    public Carta(String nombre, String descripcion, int coste_mana) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste_mana = coste_mana;


        //setSize(,);
        setOrigin(Align.center);

        //aquí poner la animación que hará la carta

    }

    public Carta(String nombre, int valor) {
        this.nombre = nombre;
    }

    //métodos: mensaje al server, repartir, lanzarCarta

    static Carta fromMensaje(Mensaje.Carta carta){
        return new Carta(carta.nombre, carta.valor);
    }
    public void accionRepartir(){}

    public void lanzarCarta(){}

}
