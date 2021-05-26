package main.java;

public class Mensaje {
    public String action;
    public boolean turno;
    public Mano mano;
    public Carta carta;
    public int[] vidas;
    public String gato, gato2; //
    public String background;
    public int furiadanyo;


    public static Mensaje ready(String gato){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "ready";
        mensaje.gato = gato;
        return mensaje;
    }

    public static Mensaje readyOk(){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "ready_ok";
        return mensaje;
    }


    public static Mensaje start(String gato, String gato2, Mano mano, String background) {
        Mensaje mensaje = new Mensaje();
        mensaje.action = "start";
        mensaje.gato = gato;
        mensaje.gato2 = gato2;
        mensaje.mano = mano;
        mensaje.background = background;
        return mensaje;
    }

    //el mensaje de la jugada con la carta a procesar
    public static Mensaje jugada(Carta carta, int furiadanyo){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "jugada";
        mensaje.carta = carta;
        mensaje.furiadanyo = furiadanyo;
        return mensaje;
    }

    public static Mensaje jugadaOk(Carta carta, int furiadanyo){
        Mensaje mensaje = new Mensaje();
        mensaje.carta = carta;
        mensaje.action = "jugadaOk";
        mensaje.furiadanyo = furiadanyo;
        return mensaje;
    }

    public static Mensaje setTurno(boolean torn){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "turno";
        mensaje.turno = torn;
        return mensaje;
    }

    public static Mensaje refillMano(Mano mano){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "refillCartas";
        mensaje.mano = mano;
        return mensaje;
    }
    public static Mensaje cambiarTurno(){
        Mensaje mensaje = new Mensaje();
        mensaje.action = "cambiarTurno";
        return mensaje;
    }
    public Mensaje(){}



    public Mensaje(String action) {
        this.action = action;
    }


    public Mensaje(String action, Carta carta) {
        this.action = action;
        this.carta = carta;
    }

    public Mensaje(String action, Mano mano) {
        this.action = action;
        this.mano = mano;
    }

    public Mensaje(String action, int[] vidas){
        this.action = action;
        this.vidas = vidas;
    }



    public static class Carta {
        public String nombre;
        public int valor;
        public String descripcion;
        public int costeMana;
        public String tipo;

        public Carta(){}

        public Carta(String nombre, String descripcion, int coste_mana, int valor, String tipo) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.costeMana = coste_mana;
            this.valor = valor;
            this.tipo = tipo;
        }
    }

    public static class Mano {
        public Carta[] cartaList;

        public Mano(){}

        public Mano(Carta[] cartaList) {
            this.cartaList = cartaList;
        }
    }
}
