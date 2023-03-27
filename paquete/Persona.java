package paquete;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int puntos;
    private ArrayList<Pronostico> pronosticos;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.pronosticos = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void addPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    public int getPuntos() {
        return puntos;
    }
    public int setPuntos(int puntos) {
        return this.puntos = puntos;
    }

    public void SumaPunto() {
        this.puntos ++;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
