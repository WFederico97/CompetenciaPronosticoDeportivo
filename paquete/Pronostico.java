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

    public void resultado(String[] data){
        if (data[2].equals("x") || data[3].equals("x") ) {
            this.setResultado(ResultadoEnum.ganador);
        } else this.setResultado(ResultadoEnum.empate);
    }


    public ResultadoEnum getResultado(){
        return resultado;
    }

    public void apuesta(Partido partido, String[] data){
        if (data[2].equals("x")) {
            this.setEquipo(partido.getLocal());
        } else if (data[3].equals("x")) {
            this.setEquipo(partido.getVisit());
        } else setEquipo(null);
    }
    public boolean acertado() {
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
        } else return this.partido.toString() +
                " | " + this.equipo + " " + this.resultado ;
    }

}
