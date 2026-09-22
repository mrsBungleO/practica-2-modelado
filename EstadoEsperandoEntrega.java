/**
 * Estado concreto que representa al robot esperando a que el cliente
 * solicite la entrega de su orden ya preparada 
 * La única acción válida en este estado es entregarOrden(), tras la cual el robot vuelve a
 * dormir, listo para atender a otro cliente
 */
public class EstadoEsperandoEntrega implements EstadoRobot {

    /** Referencia al robot al que pertenece este estado */
    private Robot robot;

    /**
     * Construye el estado esperando entrega
     * @param robot el robot al que pertenece este estado
     */
    public EstadoEsperandoEntrega(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot todavía tiene una entrega pendiente, no puede atender a
     * otro cliente hasta terminar con esta
     */
    @Override
    public void llamar(){
        System.out.println("EL robot está aún en la entrega de la orden anterior, no puede atender a otro cliente todavía");
    }

    /**
     * Ya no se pueden agregar productos, pq la orden ya fue preparada
     */
    @Override 
    public void ordenarPizza(){
        System.out.println("La orden ya fue preparada, no puedes agregar más productos");
    }

    //falta helado

    /**
     * La orden no se puede confirmar de nuevo
     */
    @Override 
    public void confirmarOrden(){
        System.out.println("La orden ya fue confirmada y preparada");
    }

    /**
     * Ya no se puede cancelar una orden que ya está preparada
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("OH NO! La orden ya no se puede cancelar, la comida ya está preparada y lista para entregarse");
    }

    /**
     * La orden ya fue preparada, no hay que volver a prepararla
     */
    @Override 
    public void prepararOrden(){
        System.out.println("La orden ya fue preparada, solo falta entregarla");
    }

    /**
     * Entrega la orden al cliente junto con su ticket
     * vacía la orden actual del robot y lo regresa a dormir
     */
    @Override 
    public void entregarOrden(){
        System.out.println("Robot Cesarín: ¡Gracias por tu compra!, aquí tienes tu ticket: ");
        System.out.println(robot.getOrdenActual().generarTicket());
        robot.setOrdenActual(null);
        System.out.println("El robot vuelve a dormir.");
        robot.setEstado(robot.getEstadoDormido());
    }
}