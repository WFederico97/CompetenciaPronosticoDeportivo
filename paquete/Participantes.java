package paquete;
import java.util.ArrayList;

public class Participantes {
    private static ArrayList<Persona> participantes;
    public Participantes(){
        participantes = new ArrayList<>();
    }

    public static void addPersona(Persona persona){
        participantes.add(persona);
    }
    public  Persona getPersona(int i){
        return participantes.get(i);
    }

    public ArrayList<Persona> getPersonas(){

        return participantes;
    }
}
