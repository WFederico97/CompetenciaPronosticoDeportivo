package paquete;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private int puntos;
    private int[] puntosRonda;
    private ArrayList<Pronostico> pronosticos;

    public Persona(String nombre) {
        this.puntosRonda = new int[Fase.getRondaSize()];
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

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntosRonda(int ronda) {
        return puntosRonda[ronda];
    }

    public void setPuntosRonda(int puntos, int ronda) {
        this.puntosRonda[ronda] = puntos;
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public Pronostico getPronostico(int i) {
        return this.pronosticos.get(i);
    }

    public void SumaPunto() {
        this.puntos ++;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
