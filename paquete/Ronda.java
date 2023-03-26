package paquete;
import java.util.ArrayList;

public class Ronda{
    private int numero;
    private ArrayList<Partido> partidos;
    public Ronda(int numero){
        this.numero = numero;
        this.partidos = new ArrayList<>();
    }

    public int getNumero(){
        return this.numero;
    }

    public void addPartido(Partido partido) {

        this.partidos.add(partido);
    }
    public Partido getPartido(int i){

        return this.partidos.get(i);
    }

    public ArrayList<Partido> getPartidos(){
        return partidos;
    }


}
