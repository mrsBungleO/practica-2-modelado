/**
 * Estado concreto que representa al robot preparando la orden ya
 * confirmada, mientras se prepara la orden, esta ya no puede
 * modificarse ni cancelarse
 */
public class EstadoPreparando implements EstadoRobot{

    /** Referencia al robot al que pertenece este estado. */
    private Robot robot;

    /**
     * Construye el estado preparando del robot
     * @param robot el robot al que pertenece este estado
     */
    public EstadoPreparando(Robot robot){
        this.robot = robot;
    }

    /**
     * El robot está ocupado preparando una orden, no puede atender a otro cliente
     */
    @Override
    public void llamar(){
        System.out.println("El robot está cocinando, por favor espera, no puede atender a otro cliente aún");
    }

    /**
     * Ya no se pueden agregar productos a una orden que ya está en preparación
     */
    @Override 
    public void ordenarPizza(){
        System.out.println("La orden ya está en preparación, no se pueden agregar más productos.");
    }

    /**
    * Ya no se pueden agregar productos a una orden que ya está en preparación
    * @param helado el helado que se intentó agregar
    */
    @Override
    public void ordenarHelado(Helado helado){
        System.out.println("La orden ya está en preparación, no se pueden agregar más productos.");
    }

    /**
     * La orden ya fue confirmada, no se puede confirmar de nuevo
     */
    @Override 
    public void confirmarOrden(){
        System.out.println("La orden ya fue confirmada :D");
    }

    /**
     * Ya no se puede cancelar una orden que está en preparación
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("La orden ya no se puede cancelar, ya se confirmó y se está en preparación");
    }

     /**
     * Prepara la pizza de la orden actual siguiendo su receta
     * y al terminar, el robot pasa a esperar que el cliente recoja su orden.
     */
    @Override 
    public void prepararOrden(){
        System.out.println("\nRobot Cesarín: Iniciando la preparación de tu pedido...");
        if (robot.getOrdenActual().getPizza() != null) {
            robot.getOrdenActual().getPizza().prepararPizza();
        }
        if (robot.getOrdenActual().getHelado() != null) {
        System.out.println("Preparando: " + robot.getOrdenActual().getHelado().getDescripcion());
        }
        System.out.println("La orden está lista. El robot Cesarín espera a que el cliente la recoja.");
        robot.setEstado(robot.getEstadoEsperandoEntrega());
    }

    /**
     * Aún no se puede entregar una orden que sigue en preparación
     */
    @Override 
    public void entregarOrden(){
        System.out.println("La orden se está preparadno, aún no se puede entregar");
    }
    
}
