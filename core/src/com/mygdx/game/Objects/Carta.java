package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.Assets;
import com.mygdx.game.Config.MyActor;
import main.java.Mensaje;

import static com.badlogic.gdx.utils.Align.center;

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
//        WIDTH = 550;
//        HEIGHT = 350;

        setSize(172, 234);
        setOrigin(center);
        //setSize(,);
        //setOrigin(Align.center);

        animation = Assets.getAnimation("pruebaCarta", 10, Animation.PlayMode.LOOP);

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
