public class Robot {
    private EstadoRobot estadoActual;
    private EstadoRobot estadoDormido;
    private EstadoRobot estadoTomandoOrden;
    private EstadoRobot estadoPreparando;
    private EstadoRobot estadoEsperandoEntrega;

    private Orden ordenActual;
    
    public Robot() {
        //
    }

    public void llamar(){
        //
    }

    public void ordenarPizza(Pizza pizza){
        //
    }

    //Falta helado
    
    public void confirmarOrden(){
        //
    }

    public void cancelarOrden(){
        //
    }
    
    public void prepararOrden(){
        //
    }

    public void entregarOrden(){
        //
    }

    public void setEstado(EstadoRobot estado){
        //
    }

    public EstadoRobot getEstadoDormido(){
        return estadoDormido;
    }

    public EstadoRobot getEstadoTomandoOrden(){
        return estadoTomandoOrden;
    }

    public EstadoRobot getEstadoPreparando(){
        return estadoPreparando;
    }

    public EstadoRobot getEstadoEsperandoEntrega(){
        return estadoEsperandoEntrega;
    }

    public Orden getOrdenActual(){
        return ordenActual;
    }


}
