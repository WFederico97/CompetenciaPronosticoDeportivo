package paquete;
import java.util.ArrayList;

public class Participantes {
    private ArrayList<Persona> participantes;
    public Participantes(){
        this.participantes = new ArrayList<>();
    }

    public void addPersona(Persona persona){
        this.participantes.add(persona);
    }
    public ArrayList<Persona> getPersonas(){
        return participantes;
    }
}
