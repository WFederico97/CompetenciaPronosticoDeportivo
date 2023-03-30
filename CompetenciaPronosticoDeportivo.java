import paquete.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class CompetenciaPronosticoDeportivo{
    public static void main(String[] args) throws IOException {
        Fase fase = new Fase();
        RegistrarPartidos(fase);
        Participantes participantes = new Participantes();
        GenerarPronosticos(fase, participantes);
        GenerarPuntaje(fase, participantes);
        TablaPosiciones(participantes);
    }
     private static void RegistrarPartidos(Fase fase) throws IOException {
        System.out.println("Procesando rondas");
        String archivo = "partidos.csv";
        Scanner scanner = new Scanner(new File(archivo));
        scanner.useDelimiter(",");
        Ronda ronda = new Ronda(1);
        while (scanner.hasNext()) {
            String linea = scanner.nextLine();
            String[] data = linea.split(",");
            String numRonda = data[0];
            if(!numRonda.equals(String.valueOf(ronda.getNumero()))) {
                System.out.println("Ronda: " + ronda.getNumero() + " " + ronda.getPartidos());
                fase.addRonda(ronda);
                ronda = new Ronda(Integer.parseInt(numRonda));
            }
            String local = data[1];
            int golesLocal = Integer.parseInt(data[2]);
            int golesVisitante = Integer.parseInt(data[3]);
            String visitante = data[4];
            Equipo equipoLocal = new Equipo(local);
            Equipo equipoVisitante = new Equipo(visitante);

            Partido partido = new Partido(equipoLocal,equipoVisitante,golesLocal,golesVisitante);
            ronda.addPartido(partido);
        }
        System.out.println("Ronda: " + ronda.getNumero() + " " + ronda.getPartidos());
        fase.addRonda(ronda);
    }
    private static void GenerarPronosticos(Fase fase, Participantes participantes) throws IOException {
        String file = "pronosticos.csv";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        String ultimoNombre = "";
        int numPersona = -1;
        int numPartido = 0;
        int numRonda = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");String nombre = data[0];
            if (!nombre.equals(ultimoNombre)) {
                System.out.println("Generando pronosticos de " + nombre);
                Persona persona = new Persona(nombre);
                Participantes.addPersona(persona);
                ultimoNombre = nombre;
                numPersona++;
                numPartido = 0;
                numRonda = 0;
            }
            Pronostico pronostico = new Pronostico();
            if (numPartido == fase.getRonda(numRonda).getSize()){
                numRonda++;
                numPartido = 0;
            }
            Partido partido = fase.getRonda(numRonda).getPartido(numPartido);
            pronostico.setPartido(partido);
            pronostico.apuesta(partido,data);
            pronostico.resultado(data);
            System.out.println(pronostico);
            participantes.getPersona(numPersona).addPronostico(pronostico);
            numPartido++;
        }
    }

    private static void GenerarPuntaje(Fase fase, Participantes participantes) {
        for (int i = 0; i < participantes.getPersonas().size(); i++) {
            Persona persona = participantes.getPersona(i);
                for (int k = 0; k < Fase.getRondaSize(); k++) {
                    for (int j = 0; j < fase.getRonda(k).getPartidos().size(); j++) {
                        Pronostico pronostico = persona.getPronostico(j);
                        if (pronostico.acertado()) {
                            persona.SumaPunto();
                        }
                    }
                    persona.setPuntosRonda(persona.getPuntos(), k);
                    System.out.println(participantes.getPersona(i) + " obtuvo " + persona.getPuntos() + " la ronda " + ( k + 1 ));
                }
            System.out.println(participantes.getPersona(i) + " obtuvo " + participantes.getPersona(i).getPuntos() + " puntos totales.");
        }

    }
    private static void TablaPosiciones(Participantes participantes){
        System.out.println("///TABLA DE POSICIONES///");
        List<Persona> personas = participantes.getPersonas();
        personas.sort((p1, p2) -> p2.getPuntos() - p1.getPuntos());
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            System.out.println((i + 1) + "# " + persona.getNombre().toUpperCase() + " [" + persona.getPuntos() + "] puntos con " + persona.getPuntos() + " aciertos");
        }
    }
}