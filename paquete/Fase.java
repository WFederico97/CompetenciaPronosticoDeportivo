package paquete;
import java.util.ArrayList;

public class Fase {
    private int numero;
    private ArrayList<Ronda> rondas;
    public Fase() {
        rondas = new ArrayList<>();
    }

    public ArrayList<Ronda> getFase() {
        return rondas;
    }

    public void addRonda(Ronda ronda) {
        rondas.add(ronda);
    }

    public Ronda getRonda(int i){
        return this.rondas.get(i);
    }
}
