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
        System.out.println("\nEL robot está aún en la entrega de la orden anterior, no puede atender a otro cliente todavía\n");
    }

    /**
     * Ya no se pueden agregar productos, pq la orden ya fue preparada
     */
    @Override 
    public void ordenarPizza(){
        System.out.println("\nLa orden ya fue preparada, no puedes agregar más productos\n");
    }

    /**
    * Ya no se pueden agregar productos, pq la orden ya fue preparada
    * @param helado el helado que se intentó agregar
    */
    @Override
    public void ordenarHelado(Helado helado){
        System.out.println("\nLa orden ya fue preparada, no puedes agregar más productos\n");
    }

    /**
     * La orden no se puede confirmar de nuevo
     */
    @Override 
    public void confirmarOrden(){
        System.out.println("\nLa orden ya fue confirmada y preparada\n");
    }

    /**
     * Ya no se puede cancelar una orden que ya está preparada
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("\nOH NO! La orden ya no se puede cancelar, la comida ya está preparada y lista para entregarse\n");
    }

    /**
     * La orden ya fue preparada, no hay que volver a prepararla
     */
    @Override 
    public void prepararOrden(){
        System.out.println("\nLa orden ya fue preparada, solo falta entregarla\n");
    }

    /**
     * Entrega la orden al cliente junto con su ticket
     * vacía la orden actual del robot y lo regresa a dormir
     */
    @Override 
    public void entregarOrden(){
        System.out.println("\nRobot Cesarín: ¡Gracias por tu compra!, aquí tienes tu ticket: \n");
        System.out.println(robot.getOrdenActual().generarTicket());
        robot.setOrdenActual(null);
        System.out.println("\nEl robot vuelve a dormir.\n");
        robot.setEstado(robot.getEstadoDormido());
    }

    /**
     * Muestra el estado del robot
     */
    @Override
    public String mostrarEstado(){
        return "ESPERANDO ENTREGA";
    }
}