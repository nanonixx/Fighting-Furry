package com.mygdx.game.Objects;

import com.mygdx.game.Cosingas;
import com.mygdx.game.MyGdxGame;
import main.java.Mensaje;

import java.util.Iterator;
import java.util.Random;

public class Juego {
    public Gatito P1, P2;
    public Mano mano;
    public boolean torn;

    private final MyGdxGame game;

    public Juego(MyGdxGame game) {
        this.game = game;
    }

    public void mensaje(Mensaje mensaje){
        game.getBaseScreen().mensaje(mensaje);
    }

    public void jugarCarta(Carta carta, Gatito activo, Gatito rival){
        int damages;
        switch (carta.tipo){
            case "ataque":
                if (carta.valor + activo.atBoost >= 0) {
                    if (rival.defensa == 0) {
                        rival.salud -= carta.valor + activo.atBoost;
                    } else {
                        if (rival.defensa - (carta.valor + activo.atBoost) >= 0)
                            rival.defensa -= carta.valor + activo.atBoost;
                        else {
                            damages = (carta.valor + activo.atBoost) - rival.defensa;
                            rival.defensa = 0;
                            rival.salud -= damages;
                        }
                    }
                    activo.atBoost = 0;
                }
                    activo.atBoost -= carta.valor;
                break;

            case "defensa":
                activo.defensa += carta.valor;
                break;

            case "curacion":
                if(activo.salud + carta.valor <= 100)
                    activo.salud += carta.valor;
                else
                    activo.salud = 100;
                break;

            case "especial":

                switch (carta.nombre){
                    case "canvidelloc instantani":
                        P1.inmune = true;
                        break;

                    case "heehee":
                    //TODO
                        break;

                    case "antigravitylean":
                        activo.atBoost += carta.valor;
                        break;

                    case "cabezazo":
                        rival.atBoost += carta.valor;
                        //comprobar que si el ataque es menos de 5 no
                        // le suba vida al otro, se queda en 0
                        break;


                    case "pactodeacero":
                        activo.defensa += carta.valor;
                        P1.turnoCount = 1;
                        break;

                    case "furiaoriental":
                        rival.salud -= 3 + Math.random() * 5;
                        //entre 3 y 5 de damage
                        break;

                    case "vomitoradioactivo":
                        rival.envenenado = true;
                        break;

                    case "poloniooplomo":
                        if (rival.envenenado) rival.salud -= 25;
                        else rival.salud -= carta.valor;
                        break;
                }

            break;
        }

        //LA IDEA ES QUE UNA VEZ PROCESADA LA JUGADA A NIVEL LOCAL ENVIEMOS LA CARTA AL SERVER Y QUE LA PASE AL RIVAL PARA PROCESARLA
        System.out.println("SE JUEGA LA CARTA");

        Mensaje.Carta mCarta = new Mensaje.Carta();
        mCarta.nombre = carta.nombre;
        mCarta.valor = carta.valor;
        mCarta.costeMana = carta.coste_mana;
        mCarta.tipo = carta.tipo;
        Cosingas.cliente.enviar(Mensaje.jugada(mCarta));

    }

    public void ready(String pjSeleccionado) {
        Cosingas.cliente.enviar(Mensaje.ready(pjSeleccionado));
    }

    public void changeTurn() {
        Cosingas.cliente.enviar(Mensaje.cambiarTurno());
    }

    public void procesarJugada(Carta carta, Gatito destPlayer, Gatito sourcePlayer) {
        int damages;
        Random random = new Random();
        Carta c1;
        sourcePlayer.cristales -= carta.coste_mana;
        System.out.println("AVER AHORA "+carta.nombre);
        if(!P1.inmune){
            switch(carta.tipo){
                case "ataque":
                    if(destPlayer.defensa == 0)
                        destPlayer.salud -= carta.valor;
                    else{
                        if(destPlayer.defensa - carta.valor >= 0)
                            destPlayer.defensa -= carta.valor;
                        else{
                            damages = carta.valor - destPlayer.defensa;
                            destPlayer.defensa = 0;
                            destPlayer.salud -= damages;

                        }
                    }
                    break;
                case "defensa":
                    sourcePlayer.defensa += carta.valor;
                    break;
                case "curacion":
                    if(sourcePlayer.salud + carta.valor <= 100)
                        sourcePlayer.salud += carta.valor;
                    else
                        sourcePlayer.salud = 100;
                    break;
                case "especial":
                    switch(carta.nombre){
                        case "autocracia":
                            for (Iterator<Carta> iterator = Cosingas.juego.mano.cartaList.iterator(); iterator.hasNext(); ) {
                                Carta c = iterator.next();
                                c.remove();
                                iterator.remove();
                            }
                            break;

                        case "heehee":
                            P1.skipTurno = true;
                            break;

                        case "antigravitylean":
                            sourcePlayer.atBoost += carta.valor;
                            break;

                        case "cabezazo":
                            destPlayer.atBoost += carta.valor;
                            //comprobar que si el ataque es menos de 5 no
                            // le suba vida al otro, se queda en 0
                            break;

                        case "pisoton":
                            System.out.println("pos sa tirao");
                            c1 = Cosingas.juego.mano.cartaList.get(random.nextInt(Cosingas.juego.mano.cartaList.size()));
                            c1.remove();
                            Cosingas.juego.mano.cartaList.remove(c1);
                            break;

                        case "pactodeacero":
                            sourcePlayer.defensa += carta.valor;
                            P2.turnoCount = 1;
                            break;

                        case "furiaoriental":
                            destPlayer.salud -= 3 + Math.random() * 5;
                            //entre 3 y 5 de damage
                            break;

                        case "vomitoradioactivo":
                            destPlayer.envenenado = true;
                            break;

                        case "poloniooplomo":
                            if (destPlayer.envenenado) destPlayer.salud -= 25;
                            else destPlayer.salud -= carta.valor;
                            break;
                    }
                    break;
            }
        }else{
            P1.inmune = false;
        }

    }

}
