/**
 * Interfaz que representa el estado del robot dentro del patron "State"
 * Cada metodo corresponde a una accion del menu 
 * Cada estado concreto decide que hacer
 */
public interface EstadoRobot {

    /**
     * Accion del cliente para llamar al robot y que este comience a
     * atenderlo, solo cuando el robot esta dormido
     */
    void llamar();

    /**
     * Accion para agregar una pizza a la orden actual
     * solo mientras se esta tomando la orden
     */
    void ordenarPizza();

    /**
    * Accion para agregar un helado a la orden actual
    * solo mientras se esta tomando la orden
    * @param helado el helado que el cliente quiere agregar a su orden
    */
    void ordenarHelado();
    
    /**
     * Accion para confirmar la orden actual
     * solo mientras se esta tomando la orden y esta no esta vacia.
     */
    void confirmarOrden();
    
    /**
     * Accion para cancelar la orden actual
     * Solo mientras se está tomando la orden, (antes de confirmarla)
     */
    void cancelarOrden();
    
    /**
     * Accion para iniciar la preparacion de la orden confirmada
     * Una vez que la orden ya fue confirmada
     */
    void prepararOrden();

    /**
     * Accion para entregar la orden ya preparada al cliente
     * Una vez que la orden ya fue preparada
     */
    void entregarOrden();

    /**
     * Metodo que nos muestra el estado en que se encuentra nuestro robot
     */
    String mostrarEstado();
}

