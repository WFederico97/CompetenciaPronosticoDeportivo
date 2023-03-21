package paquete;

public class Pronostico{
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    public void setPartido(Partido partido){
        this.partido = partido;
    }
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }
    public void setResultado(ResultadoEnum resultado){
        this.resultado = resultado;
    }
    public ResultadoEnum getResultado(){
        return resultado;
    }
    public boolean Punto() {
        return getResultado().equals(partido.Resultado(equipo));

    }
}
