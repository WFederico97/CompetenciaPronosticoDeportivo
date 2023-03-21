import paquete.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class TrabajoPracticoIntegradorApolo
{
    public static void main(String[] args) throws IOException {
        Path partidos = Paths.get("partidos.txt");
        long l = Files.lines(partidos).count();
        int dimension = (int) l;
        Ronda ronda = new Ronda(dimension);
        int index = 0;
        for (String linea : Files.readAllLines(partidos, StandardCharsets.UTF_8)) {
            String[] i = linea.split(",");
            Equipo equipo1  = new Equipo(i[0]);
            Equipo equipo2  = new Equipo(i[3]);
            Partido partido = new Partido(equipo1,equipo2,Integer.parseInt(i[1]),Integer.parseInt(i[2]));
            ronda.setPartido(index, partido);
            index++;
        }
        Path pronosticos = Paths.get("pronosticos.txt");
        int partido = 0;
        int puntos = 0;
        String persona = "pepe";
        for (String linea : Files.readAllLines(pronosticos, StandardCharsets.UTF_8)) {
            Pronostico pronostico = new Pronostico();
            pronostico.setPartido(ronda.getPartido(partido));
            String[] i = linea.split(",");
            String nombre;
            if(i[1].equals("x")){
                nombre = i[0];
                pronostico.setResultado(ResultadoEnum.ganador);
            } else if(i[2].equals("x")){
                nombre = i[3];
                pronostico.setResultado(ResultadoEnum.ganador);
            } else {
                nombre = "niguno";
                pronostico.setResultado(ResultadoEnum.empate);
            }
            Equipo equipo = new Equipo(nombre);
            pronostico.setEquipo(equipo);
            if (pronostico.Punto()){
                puntos++;
            }
            partido++;
        }
        System.out.println(persona + " obtuvo " + puntos +  " puntos ");
    }
}
