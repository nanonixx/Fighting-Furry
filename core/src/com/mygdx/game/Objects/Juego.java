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
    int furiaOrientalValor;
    public String bg;

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
                //va bien, no tocar
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
                }else activo.atBoost += carta.valor;
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
//                        furiaOrientalValor = (int)(3 + Math.random() * 5) * 5;
                        furiaOrientalValor = (int)(3 + Math.random() * 5) * 5;
                        if (furiaOrientalValor + activo.atBoost >= 0) {
                            if (rival.defensa == 0) {
                                rival.salud -= furiaOrientalValor + activo.atBoost;
                            } else {
                                if (rival.defensa - (furiaOrientalValor + activo.atBoost) >= 0)
                                    rival.defensa -= furiaOrientalValor + activo.atBoost;
                                else {
                                    damages = (furiaOrientalValor + activo.atBoost) - rival.defensa;
                                    rival.defensa = 0;
                                    rival.salud -= damages;
                                }
                            }
                            activo.atBoost = 0;
                        }else activo.atBoost += furiaOrientalValor;
                        break;
                        //entre 3 y 5 de turno por 5 damage


                    case "vomitoradioactivo":
                        rival.envenenado = true;
                        break;

                    case "poloniooplomo":
                        int veneno ;
                        if (rival.envenenado) {
                            veneno = 25;
                        }else veneno=15;
                        if (veneno + activo.atBoost >= 0) {
                            if (rival.defensa == 0) {
                                rival.salud -= veneno + activo.atBoost;
                            } else {
                                if (rival.defensa - (veneno + activo.atBoost) >= 0)
                                    rival.defensa -= veneno + activo.atBoost;
                                else {
                                    damages = (veneno + activo.atBoost) - rival.defensa;
                                    rival.defensa = 0;
                                    rival.salud -= damages;
                                }
                            }
                            activo.atBoost = 0;
                        }else activo.atBoost += veneno;
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
        Cosingas.cliente.enviar(Mensaje.jugada(mCarta, furiaOrientalValor));

    }

    public void ready(String pjSeleccionado) {
        Cosingas.cliente.enviar(Mensaje.ready(pjSeleccionado));
    }

    public void changeTurn() {
        Cosingas.cliente.enviar(Mensaje.cambiarTurno());
    }

    public void procesarJugada(Carta carta, Gatito destPlayer, Gatito sourcePlayer, int furiadanyo) {
        int damages;
        Random random = new Random();
        Carta c1;
        sourcePlayer.cristales -= carta.coste_mana;
        System.out.println("AVER AHORA "+carta.nombre);
        if(!P1.inmune){
            switch(carta.tipo){
                case "ataque":
                    if (carta.valor + sourcePlayer.atBoost >= 0) {
                    if(destPlayer.defensa == 0)
                        destPlayer.salud -= carta.valor + sourcePlayer.atBoost;
                    else {
                        if (destPlayer.defensa - carta.valor + sourcePlayer.atBoost >= 0)
                            destPlayer.defensa -= carta.valor + sourcePlayer.atBoost;
                        else {
                            damages = carta.valor + destPlayer.atBoost - destPlayer.defensa;
                            destPlayer.defensa = 0;
                            destPlayer.salud -= damages;

                        }
                    }
                        sourcePlayer.atBoost = 0;
                    }else sourcePlayer.atBoost += carta.valor;
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
//                            furiaOrientalValor = (int)(3 + Math.random() * 5) * 5;
                            if (furiadanyo + sourcePlayer.atBoost >= 0) {
                                if (destPlayer.defensa == 0) {
                                    destPlayer.salud -= furiadanyo + sourcePlayer.atBoost;
                                } else {
                                    if (destPlayer.defensa - (furiadanyo + sourcePlayer.atBoost) >= 0)
                                        destPlayer.defensa -= furiadanyo + sourcePlayer.atBoost;
                                    else {
                                        damages = (furiadanyo + destPlayer.atBoost) - destPlayer.defensa;
                                        destPlayer.defensa = 0;
                                        destPlayer.salud -= damages;
                                    }
                                }
                                sourcePlayer.atBoost = 0;
                            }else sourcePlayer.atBoost += furiadanyo;
                            //entre 3 y 5 de damage
                            break;

                        case "vomitoradioactivo":
                            destPlayer.envenenado = true;
                            break;

                        case "poloniooplomo":
                            int veneno;
                            if (destPlayer.envenenado) {
                                veneno = 25;
                            }else veneno=15;
                            if (veneno + sourcePlayer.atBoost >= 0) {
                                if (destPlayer.defensa == 0) {
                                    destPlayer.salud -= veneno + sourcePlayer.atBoost;
                                } else {
                                    if (destPlayer.defensa - (veneno + sourcePlayer.atBoost) >= 0)
                                        destPlayer.defensa -= veneno + sourcePlayer.atBoost;
                                    else {
                                        damages = (veneno + sourcePlayer.atBoost) - destPlayer.defensa;
                                        destPlayer.defensa = 0;
                                        destPlayer.salud -= damages;
                                    }
                                }
                                sourcePlayer.atBoost = 0;
                            }else sourcePlayer.atBoost += veneno;
                            break;
                    }
                    break;
            }
        }else{
            P1.inmune = false;
        }

    }

}
