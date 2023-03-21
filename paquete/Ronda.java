package paquete;

public class Ronda{
    private int num;
    private Partido[] partidos;
    public Ronda(int espacio){
        this.partidos = new Partido[espacio];
    }
    public void setPartido(int i, Partido partido) {
        partidos[i] = partido;
    }
    public Partido getPartido(int i){
        return partidos[i];
    }
}
