import paquete.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//migrar proyecto a maven
public class CompetenciaPronosticoDeportivo{
    public static void main(String[] args) throws IOException {
        Fase fase = new Fase();
        RegistrarPartidos(fase);
        Participantes participantes = new Participantes();
        GenerarPronosticos(fase, participantes);
        TablaPosiciones(participantes);
    }
     private static void RegistrarPartidos(Fase fase) throws IOException {
        System.out.println("Procesando rondas");
        String file = "partidos.csv";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        Ronda ronda = new Ronda(1);

        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] cell = line.split(",");
            String numRonda = cell[0];
            String local = cell[1];
            String golesLocal = cell[2];
            String golesVisitante = cell[3];
            String visitante = cell[4];

            if (numRonda.equals(String.valueOf(ronda.getNumero()))) {

                //evitar crear un equipo cada partido
                Equipo equipoLocal = new Equipo(local);
                Equipo equipoVisitante = new Equipo(visitante);

                Partido partido = new Partido(equipoLocal,equipoVisitante,
                        Integer.parseInt(golesLocal),Integer.parseInt(golesVisitante));

                ronda.addPartido(partido);

            } else {
                System.out.println(ronda.getNumero() + " " + ronda.getPartidos());
                fase.addRonda(ronda);

                ronda = new Ronda(Integer.parseInt(numRonda));
                Partido partido = new Partido(
                        new Equipo(cell[1]), new Equipo(cell[4]),
                        Integer.parseInt(cell[2]),Integer.parseInt(cell[3])
                );

                //generar funcion para no repetir

                ronda.addPartido(partido);
            }
        }
         System.out.println(ronda.getNumero() + " " + ronda.getPartidos());
         fase.addRonda(ronda);
    }
    private static void GenerarPronosticos(Fase fase, Participantes participantes) throws IOException {
        String file = "pronosticos.csv";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        String lastName = "";
        int numPersona = -1;
        int nPartido = 0;
        int nRonda = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            String name = data[0];
            if (!name.equals(lastName)) {
                System.out.println("Generando pronosticos de " + name);
                Persona persona = new Persona(name);
                Participantes.addPersona(persona);
                lastName = name;
                numPersona++;
                nPartido = 0;
                nRonda = 0;
            }
            Pronostico pronostico = new Pronostico();

            if (nPartido == fase.getRonda(nRonda).getSize()){
                nRonda++;
                nPartido = 0;
            }

            Partido partido = fase.getRonda(nRonda).getPartido(nPartido);

            pronostico.setPartido(partido);
            pronostico.setEquipo(Apuesta(partido,data));
            pronostico.setResultado(Res(data));

            System.out.println(pronostico);

            if (pronostico.Acertado()){
                participantes.getPersona(numPersona).SumaPunto();
            }

            //poder dividir puntos por rondas, calcular pronos por separado?

            participantes.getPersona(numPersona).addPronostico(pronostico);
            nPartido++;
        }
        scanner.close();
    }
    private static Equipo Apuesta(Partido partido, String[] data){
        if (data[2].equals("x")) {
            return partido.getLocal();
        } else if (data[3].equals("x")) {
            return partido.getVisit();
        }
        return null;
    }

    private static ResultadoEnum Res(String[] data){
        if (data[2].equals("x") || data[3].equals("x") ) {
            return ResultadoEnum.ganador;
        }
        return ResultadoEnum.empate;
    }

    private static void TablaPosiciones(Participantes participantes){
        System.out.println("Tabla de Posiciones");
        String[] posiciones = new String[participantes.getPersonas().size()];
        int aux = 0;
        for (int i = 0; i < participantes.getPersonas().size(); i++) {
            int max = 0;
            for (int j = 0; j < participantes.getPersonas().size(); j++) {
                int puntos = participantes.getPersona(j).getPuntos();
                if (max < puntos) {
                    max = puntos;
                    aux = j;
                }
            }
            System.out.println( i + 1 + " ) " + participantes.getPersona(aux).getNombre() + " [" + participantes.getPersona(aux).getPuntos() + "]");
            participantes.getPersona(aux).setPuntos(0);
            posiciones[i] = participantes.getPersona(aux).getNombre();
        }
    }
}