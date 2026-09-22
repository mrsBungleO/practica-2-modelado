/**
 * Interfaz que representa el estado del robot dentro del patrón "State"
 * Cada método corresponde a una acción del menú 
 * Cada estado concreto decide qué hacer
 */
public interface EstadoRobot {

    /**
     * Acción del cliente para llamar al robot y que este comience a
     * atenderlo, solo cuando el robot está dormido
     */
    void llamar();

    /**
     * Acción para agregar una pizza a la orden actual
     * solo mientras se está tomando la orden
     */
    void ordenarPizza();

    /**
    * Acción para agregar un helado a la orden actual
    * solo mientras se está tomando la orden
    * @param helado el helado que el cliente quiere agregar a su orden
    */
    void ordenarHelado(Helado helado);
    
    /**
     * Acción para confirmar la orden actual
     * solo mientras se está tomando la orden y esta no está vacía.
     */
    void confirmarOrden();
    
    /**
     * Acción para cancelar la orden actual
     * Solo mientras se está tomando la orden, (antes de confirmarla)
     */
    void cancelarOrden();
    
    /**
     * Acción para iniciar la preparación de la orden confirmada
     * Una vez que la orden ya fue confirmada
     */
    void prepararOrden();

    /**
     * Acción para entregar la orden ya preparada al cliente
     * Una vez que la orden ya fue preparada
     */
    void entregarOrden();
}

