/**
 * Estado concreto que representa al robot tomando la orden de un
 * cliente, en este estado se pueden seguir agregando productos a la
 * orden, cancelarla o confirmarla 
 */
public class EstadoTomandoOrden implements EstadoRobot{
    
    /** Referencia al robot al que pertenece este estado. */
    private Robot robot;

     /**
     * Construye el estado tomando a un robot
     * @param robot el robot al que pertenece este estado
     */
    public EstadoTomandoOrden(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot ya está atendiendo a un cliente, no puede atender a otro
     */
    @Override
    public void llamar(){
        System.out.println("El robot ya está tomando una orden, no puede atender a otro cliente todavía");
    }

    /**
     * Agrega la pizza indicada a la orden actual,
     * el robot pueden seguir agregando productos
     * @param pizza la pizza que el cliente quiere agregar a su orden
     */
    @Override 
    public void ordenarPizza(Pizza pizza){
        robot.getOrdenActual().agregarPizza(pizza);
        System.out.println("Se agregó " + pizza.getNombre() + " a la orden.");
    }

    //falta helado

     /**
     * Confirma la orden si esta no está vacía y el robot pasa a
     * preparar la orden, si la orden está vacía la confirmación se ignora
     */
    @Override 
    public void confirmarOrden(){
         if (!robot.getOrdenActual().estaVacia()) {
            System.out.println("Robot Cesarín: Orden CONFIRMADA, comenzaré a preparar tu orden, ¡A partir de este momento no se puede cancelar!");
            robot.setEstado(robot.getEstadoPreparando());
        } else {
            System.out.println("No se puede confirmar una orden vacía, agrega al menos un producto por favor");
        }
    }

    /**
     * Cancela la orden actual y el robot vuelve a dormir
     * Solo se puede cancelar antes de confirmar
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("Robot Cesarín: Orden Cancelada");
        System.out.println("El robot vuelve a dormir");
        robot.setOrdenActual(null);
        robot.setEstado(robot.getEstadoDormido());
    }

    /**
     * Aún no se puede preparar una orden que no ha sido confirmada
     */
    @Override 
    public void prepararOrden(){
         System.out.println("Todavía no se puede preparar la orden, primero hay que confirmarla");
    }

    /**
     * Aún no hay nada que entregar mientras se está tomando la orden
     */
    @Override 
    public void entregarOrden(){
        System.out.println("Todavía no hay nada que entregar, la orden no se ha confirmado");
    }
}
