/**
 * Representa al robot de la pizzeria
 * El robot mantiene una referencia al estadp en el que se encuentra actualmente 
 * y delega en ese estado toda la logica de que hacer con cada accion del menu
 */
public class Robot {

    /** Estado en el que se encuentra actualmente el robot */
    private EstadoRobot estadoActual;

    /** Instancia unica del estado "dormido" */
    private EstadoRobot estadoDormido;

    /** Instancia unica del estado "tomando la orden"*/
    private EstadoRobot estadoTomandoOrden;

    /** Instancia unica del estado "preparando la orden" */
    private EstadoRobot estadoPreparando;

    /** Instancia del estadp "esperando entrega" */
    private EstadoRobot estadoEsperandoEntrega;

    /** Orden que el robot esta tomando, preparando o a punto de entregar*/
    private Orden ordenActual;
    
    /**
     * Construye al robot, crea las cuatro instancias de estado
     * y lo deja dormido, que es el estado inicial del ciclo de vida del robot.
     */
    public Robot() {
        estadoDormido = new EstadoDormido(this);
        estadoTomandoOrden = new EstadoTomandoOrden(this);
        estadoPreparando = new EstadoPreparando(this);
        estadoEsperandoEntrega = new EstadoEsperandoEntrega(this);
        estadoActual = estadoDormido;
    }

    /**
     * El cliente llama al robot para que despierte y comience a
     * atenderlo, el comportamiento real depende del estado actual
     */
    public void llamar(){
        estadoActual.llamar();
    }

    /**
     * Agrega una pizza a la orden actual
     */
    public void ordenarPizza(){
        estadoActual.ordenarPizza();
    }

    /**
    * Agrega un helado a la orden actual
    */
    public void ordenarHelado(){
    estadoActual.ordenarHelado();
    }
    
    /**
     * Confirma la orden actual
     */
    public void confirmarOrden(){
        estadoActual.confirmarOrden();
    }

    /**
     * Confirma la orden actual
     */
    public void cancelarOrden(){
        estadoActual.cancelarOrden();
    }
    
    /**
     * Inicia la preparación de la orden confirmada
     */
    public void prepararOrden(){
        estadoActual.prepararOrden();
    }

    /**
     * Entrega la orden ya preparada al cliente
     */
    public void entregarOrden(){
        estadoActual.entregarOrden();
    }

    /**
    * Muestra el estado en el que se encuentra actualmente el robot
    * @return el nombre del estado actual
    */
    public String mostrarEstado(){
        return estadoActual.mostrarEstado();
    }

    /**
     * Cambia el estado actual del robot
     * Este metodo lo invocan las propias clases de estado cuando una transicion debe ocurrir
     * @param estado el nuevo estado del robot
     */
    public void setEstado(EstadoRobot estado){
        this.estadoActual = estado;
    }

    /**
     * Reemplaza la orden actual del robot
     * Lo usan los estados para crear una orden nueva al llamar al robot y 
     * para vaciarla una vez cancelada o entregada
     * @param orden la nueva orden actual (puede ser null)
     */
    public void setOrdenActual(Orden orden) {
        this.ordenActual = orden;
    }

    /**
     * obtiene la instancia del estado "dormido"
     * @return el estado dormido
     */
    public EstadoRobot getEstadoDormido(){
        return estadoDormido;
    }

    /**
     * Obtiene la instancia del estado "tomando la orden"
     * @return el estado tomando orden
     */
    public EstadoRobot getEstadoTomandoOrden(){
        return estadoTomandoOrden;
    }

    /**
     * Obtiene la instancia del estado "preparando la orden"
     * @return el estado preparando
     */
    public EstadoRobot getEstadoPreparando(){
        return estadoPreparando;
    }

    /**
     * Obtiene la instancia del estado "esperando la entrega"
     * @return el estado esperando entrega
     */
    public EstadoRobot getEstadoEsperandoEntrega(){
        return estadoEsperandoEntrega;
    }

    /**
     * Obtiene la orden que el robot está manejando actualmente
     * @return la orden actual, o null si no hay ninguna en curso
     */
    public Orden getOrdenActual(){
        return ordenActual;
    }


}
