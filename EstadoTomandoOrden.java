import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

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
        System.out.println("\nEl robot ya está tomando una orden, no puede atender a otro cliente todavía.\n");
    }

    /**
     * Agrega la pizza indicada a la orden actual,
     * el robot pueden seguir agregando productos
     */
    @Override 
    public void ordenarPizza(){
        Pizza pizza = this.elegirPizza();
        robot.getOrdenActual().agregarPizza(pizza);
        System.out.println("\nSe agregó " + pizza.getNombre() + " a la orden.\n");
    }

    /**
    * Agrega el helado indicado a la orden actual,
     * el robot puede seguir agregando productos
     * @param helado el helado que el cliente quiere agregar a su orden
    */
    @Override
    public void ordenarHelado(Helado helado){
    robot.getOrdenActual().agregarHelado(helado);
    System.out.println("\nSe agregó " + helado.getDescripcion() + " a la orden.\n");
    }

     /**
     * Confirma la orden si esta no está vacía y el robot pasa a
     * preparar la orden, si la orden está vacía la confirmación se ignora
     */
    @Override 
    public void confirmarOrden(){
         if (!robot.getOrdenActual().estaVacia()) {
            System.out.println("\nRobot Cesarín: Orden CONFIRMADA, comenzaré a preparar tu orden, ¡A partir de este momento no se puede cancelar!\n");
            robot.setEstado(robot.getEstadoPreparando());
        } else {
            System.out.println("\nNo se puede confirmar una orden vacía, agrega al menos un producto por favor.\n");
        }
    }

    /**
     * Cancela la orden actual y el robot vuelve a dormir
     * Solo se puede cancelar antes de confirmar
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("\nRobot Cesarín: Orden Cancelada\n");
        System.out.println("\nEl robot vuelve a dormir\n");
        robot.setOrdenActual(null);
        robot.setEstado(robot.getEstadoDormido());
    }

    /**
     * Aún no se puede preparar una orden que no ha sido confirmada
     */
    @Override 
    public void prepararOrden(){
         System.out.println("\nTodavía no se puede preparar la orden, primero hay que confirmarla.\n");
    }

    /**
     * Aún no hay nada que entregar mientras se está tomando la orden
     */
    @Override 
    public void entregarOrden(){
        System.out.println("\nTodavía no hay nada que entregar, la orden no se ha confirmado\n");
    }

    /**
     * Muestra que el robot esta tomando orden
     */
    @Override
    public String mostrarEstado(){
        return "TOMANDO ORDEN";
    }

    /**
     * Método adicional para mostrar las pizzas al usuario.
     * @return un arreglo que contiene todas las pizzas disponibles al público
     */
    public ArrayList<Pizza> imprimirPizzas(){

        PizzaDePepperoni pizzaDePepperoni= new PizzaDePepperoni();
        PizzaHawaiiana pizzaHawaiiana= new PizzaHawaiiana();
        PizzaRanchera pizzaRanchera= new PizzaRanchera();
        PizzaVegetariana pizzaVegetariana= new PizzaVegetariana();
        PizzaDeMariscos pizzaDeMariscos= new PizzaDeMariscos();
        PizzaAlPastor pizzaAlPastor= new PizzaAlPastor();

        ArrayList<Pizza> listaDePizzas= new ArrayList<>();

        listaDePizzas.add(pizzaDePepperoni);
        listaDePizzas.add(pizzaHawaiiana);
        listaDePizzas.add(pizzaRanchera);
        listaDePizzas.add(pizzaVegetariana);
        listaDePizzas.add(pizzaDeMariscos);
        listaDePizzas.add(pizzaAlPastor);
    
        System.out.println("----MENÚ DE PIZZA----");
        for(int i=0; i<listaDePizzas.size();i++){
            Pizza pizza= listaDePizzas.get(i);
            System.out.println(i+1 + ". " + pizza.getNombre() + ":" + pizza.getID());
            System.out.println("Descripción: " + pizza.getDescripcion());
            if(pizza.getEsVegetariana()){
                System.out.println("Esta pizza es apta para vegetarianos.");
            }

            System.out.println("$" + pizza.getPrecio());
            System.out.println("-----------------------");
        }
        System.out.println("");

        return listaDePizzas;

    }

    /**
     * Método adicional para validar y obtener que pizza quiere el usuario
     * @return la pizza que el usuario quiere
     */
    public Pizza elegirPizza(){
        
        Scanner leerCliente= new Scanner(System.in);
        int eleccionPizza=0;
        boolean entradaValida= false;

        System.out.println("\nElige alguna de las opciones de pizza que tenemos para ti:\n");

        ArrayList<Pizza> listaDePizzas= this.imprimirPizzas();

        while(!entradaValida){
            try{
                eleccionPizza= leerCliente.nextInt();
                if(eleccionPizza>=1 && eleccionPizza<=6){
                    entradaValida=true;
                } else {
                    System.out.println("\nOpción no disponible. Elige una pizza del menú.\n");
                }
            } catch(InputMismatchException e){
                System.out.println("\nElige una opción válida.\n");
                leerCliente.nextLine();
            }
        }

        return listaDePizzas.get(eleccionPizza-1);

    }
}
