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
    public boolean Acertado() {
        if(this.equipo == null && getResultado() == (ResultadoEnum.empate)){
            return true;
        }
        return getResultado().equals(this.partido.Resultado(this.equipo));
    }

    @Override
    public String toString(){
        if(this.equipo == null) {
            return this.partido.toString() +
                    " | " + this.resultado + " | ";
        } else
        return this.partido.toString() +
                " | " + this.equipo + " " + this.resultado ;
    }

}
