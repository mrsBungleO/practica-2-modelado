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
     * El robot esta ocupado preparando una orden, no puede atender a otro cliente
     */
    @Override
    public void llamar(){
        System.out.println("El robot esta cocinando, por favor espera, no puede atender a otro cliente aun");
    }

    /**
     * Ya no se pueden agregar productos a una orden que ya esta en preparacion
     * @param pizza la pizza que se intentó agregar
     */
    @Override 
    public void ordenarPizza(){
        System.out.println("La orden ya esta en preparacion, no se pueden agregar mas productos.");
    }

    /**
    * Ya no se pueden agregar productos a una orden que ya esta en preparacion
    * @param helado el helado que se intentó agregar
    */
    @Override
    public void ordenarHelado(){
        System.out.println("La orden ya esta en preparacion, no se pueden agregar mas productos.");
    }

    /**
     * La orden ya fue confirmada, no se puede confirmar de nuevo
     */
    @Override 
    public void confirmarOrden(){
        System.out.println("La orden ya fue confirmada :D");
    }

    /**
     * Ya no se puede cancelar una orden que esta en preparacion
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("La orden ya no se puede cancelar, ya se confirmo y se esta en preparacion");
    }

     /**
     * Prepara la pizza y helado de la orden actual siguiendo su receta
     * y al terminar, el robot pasa a esperar que el cliente recoja su orden.
     */
    @Override 
    public void prepararOrden(){
        System.out.println("\nRobot Alexin: Iniciando la preparacion de tu pedido...");
        if (robot.getOrdenActual().getPizza() != null) {
            robot.getOrdenActual().getPizza().prepararPizza();
        }
        if (robot.getOrdenActual().getHelado() != null) {
        System.out.println("\nPreparando: " + robot.getOrdenActual().getHelado().getDescripcion());
        }
        System.out.println("La orden esta lista. El robot Alexin espera a que el cliente la recoja.");
        robot.setEstado(robot.getEstadoEsperandoEntrega());
    }

    /**
     * Aun no se puede entregar una orden que sigue en preparacion
     */
    @Override 
    public void entregarOrden(){
        System.out.println("La orden se esta preparando, aun no se puede entregar");
    }
    
    /**
     * Muestra el estado del robot
     */
    @Override
    public String mostrarEstado(){
        return "PREPARANDO LA ORDEN";
    }
}
