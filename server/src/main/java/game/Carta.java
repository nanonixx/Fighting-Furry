package main.java.game;


import main.java.Mensaje;

public class Carta {
    String nombre;
    int valor;

    public Carta(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Carta(Mensaje.Carta carta){
        this.nombre = carta.nombre;
        this.valor = carta.valor;
    }

    Mensaje.Carta toMensaje(){
        return new Mensaje.Carta(nombre, valor);
    }
}
