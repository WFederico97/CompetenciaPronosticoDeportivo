package paquete;
import java.util.ArrayList;

public class Fase {
    private static ArrayList<Ronda> rondas;
    public Fase() {
        rondas = new ArrayList<>();
    }

    public void addRonda(Ronda ronda) {
        rondas.add(ronda);
    }

    public static int getRondaSize(){
        return rondas.size();
    }

    public Ronda getRonda(int i){
        return this.rondas.get(i);
    }
}
