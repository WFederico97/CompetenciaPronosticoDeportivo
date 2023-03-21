package paquete;
public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }
    public ResultadoEnum Resultado(Equipo equipo){
        ResultadoEnum resultado = null;
        if (golesEquipo1 == golesEquipo2) {
            resultado = ResultadoEnum.empate;
        }
        if (equipo.equals(equipo1)) {
            if (golesEquipo1 > golesEquipo2)
                resultado = ResultadoEnum.ganador;
            else
                resultado = ResultadoEnum.perdedor;
        }
        if (equipo.equals(equipo2)) {
            if (golesEquipo1 > golesEquipo2)
                resultado = ResultadoEnum.perdedor;
            else
                resultado = ResultadoEnum.ganador;
        }
        return resultado;
    }
}

