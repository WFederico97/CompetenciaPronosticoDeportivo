package paquete;

import java.util.List;
import java.util.ArrayList;

public class Fase {
    private List<Ronda> rondas;
    public Fase(){
        this.rondas = new ArrayList<>();
    }
    public void addRonda(Ronda ronda) {

        this.rondas.add(ronda);
    }
    public Ronda getRonda(int i){
        return this.rondas.get(i);
    }
}
