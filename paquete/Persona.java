package paquete;

import java.util.List;

public class Persona {
    private String nombre;
    private int puntos;
    private List<Pronostico> pronosticos;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPronostico(Pronostico pronostico){
        this.pronosticos.add(pronostico);
    }

    public int getPuntos() {
        return puntos;
    }

    public void SumaPunto() {
        this.puntos ++;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
