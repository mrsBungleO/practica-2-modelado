/**
 * Estado concreto que representa al robot dormido
 * Es el estado inicial del robot y al que
 * siempre regresa despues de cancelar o entregar una orden
 * La unica acción válida en este estado es llamar()
 */
public class EstadoDormido implements EstadoRobot{
    
     /** Referencia al robot al que pertenece este estado */
    private Robot robot;

    /**
     * Construye el estado dormido
     * @param robot el robot al que pertenece este estado
     */
    public EstadoDormido(Robot robot){
        this.robot = robot;
    }

    /**
     * El cliente llama al robot, se crea una orden nueva 
     * y el robot toma la orden 
     */
    @Override
    public void llamar(){
        System.out.println("\n¡Has llamado a el robot Cesarín!, Cesarín ha despertado y está listo para tomar tu orden :) \n");
        robot.setOrdenActual(new Orden());
        robot.setEstado(robot.getEstadoTomandoOrden());
    }

    /**
     * No se puede ordenar mientras el robot está dormido, primero hay
     * que llamarlo.
     */
    @Override 
    public void ordenarPizza(){
        System.out.println("\nEl robot está dormido, por favor llamalo primero.\n");
    }

    /**
    * No se puede ordenar mientras el robot está dormido, primero hay
    * que llamarlo.
    * @param helado el helado que se intentó ordenar
    */
    @Override
    public void ordenarHelado(Helado helado){
        System.out.println("\nEl robot está dormido, por favor llamalo primero.\n");
    }

    /**
     * No hay ninguna orden que confirmar mientras el robot está dormido
     */
    @Override 
    public void confirmarOrden(){
        System.out.println("\nEl robot está dormido, no hay ninguna orden que confirmar\n.");
    }

    /**
     * No hay ninguna orden que cancelar mientras el robot está dormido
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("\nEl robot está dormido, no hay orden para cancelar\n");
    }


    /**
     * No hay nada que preparar mientras el robot está dormido
     */
    @Override 
    public void prepararOrden(){
        System.out.println("\nEl robot está dormido, no hay una orden para preparar\n");
    }

    /**
     * No hay nada que entregar mientras el robot está dormido
     */
    @Override 
    public void entregarOrden(){
        System.out.println("\nEl robot está dormido, no hay ninguna orden que entregar\n");
    }

    /**
     * Muestra el estado del robot
     */
    @Override
    public String mostrarEstado(){
        return "DORMIDO";
    }
}
