package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

public class Carta extends MyActor {
    String nombre;
    String descripcion;
    int coste_mana;
    int valor;
    String tipo;

    public Carta(String nombre, String descripcion, int coste_mana, int valor, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste_mana = coste_mana;
        this.valor = valor;
        this.tipo = tipo;
        WIDTH = 550;
        HEIGHT = 350;


        //setSize(,);
        setOrigin(Align.center);

        //aquí poner la animación que hará la carta
        animation = Assets.getAnimation("pruebaCarta", 10, Animation.PlayMode.NORMAL);

    }

//    public Carta(String nombre, int valor) {
//        this.nombre = nombre;
//    }

    //métodos: mensaje al server, repartir, lanzarCarta

    static Carta fromMensaje(Mensaje.Carta carta){
        return new Carta(carta.nombre, carta.descripcion, carta.costeMana, carta.valor, carta.tipo);
    }

    Mensaje.Carta toMensaje(){
        return new Mensaje.Carta(nombre, descripcion, coste_mana, valor, tipo);
    }

    public void accionRepartir(){}

    public void lanzarCarta(){}

}
