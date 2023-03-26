import paquete.*;
import java.io.*;
import java.util.Scanner;

public class TrabajoPracticoIntegradorApolo {
    public static void main(String[] args) throws IOException {
        RegistrarParticipantes();
        Partidos();
    }

    private static void Partidos() throws IOException {

        String file = "partidos.csv";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        int rondaNumero = 1;
        Ronda ronda = new Ronda(rondaNumero);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cell = line.split(",");
            String numRonda = cell[0];
            if (numRonda.equals(String.valueOf(ronda.getNumero()))) {
                Partido partido = new Partido(
                        new Equipo(cell[1]), new Equipo(cell[4]),
                        Integer.parseInt(cell[2]),Integer.parseInt(cell[3])
                );
                System.out.println(partido);
                ronda.addPartido(partido);
            } else {
                //crear otra ronda
            }
        }
    }
        private static void RegistrarParticipantes() throws IOException {
            Participantes participantes = new Participantes();
            String file = "pronosticos.csv";
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter(",");
            String lastname = "";
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] cell = line.split(",");
                String name = cell[0];
                if (!name.equals(lastname)) {
                    participantes.addPersona(new Persona(name));
                    lastname = name;
                }
            }
            scanner.close();
            System.out.println("Se registraron las siguientes personas: " + participantes.getPersonas());
        }

        private static String Apuesta(String[]line)
        {
            if (line[2].equals("x")) {
                return line[1];
            } else if (line[3].equals("x")) {
                return line[4];
            }
            return "empate";
        }

}
