import java.util.Scanner;
import java.util.InputMismatchException;
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
     * El robot ya esta atendiendo a un cliente, no puede atender a otro
     */
    @Override
    public void llamar(){
        System.out.println("\nEl robot ya esta tomando una orden, no puede atender a otro cliente todavia.\n");
    }

    /**
     * Agrega la pizza indicada a la orden actual, siempre y cuando la
     * orden no tenga ya una pizza, pues el cliente solo puede pedir
     * una pizza por orden
     */
    @Override 
    public void ordenarPizza(){
        if (robot.getOrdenActual().tienePizza()) {
            System.out.println("\nTu orden ya tiene una pizza, solo puedes pedir una por orden.\n");
            return;
        }
        Pizza pizza = this.elegirPizza();
        robot.getOrdenActual().agregarPizza(pizza);
        System.out.println("\nSe agregó " + pizza.getNombre() + " a la orden.\n");
    }

    /**
     * Agrega un helado a la orden actual, siempre y cuando la orden no
     * tenga ya un helado, pues el cliente solo puede pedir un helado
     * por orden
     */
    @Override
    public void ordenarHelado(){
        if (robot.getOrdenActual().tieneHelado()) {
            System.out.println("\nTu orden ya tiene un helado, solo puedes pedir uno por orden.\n");
            return;
        }
        Helado helado = this.elegirHelado();
        robot.getOrdenActual().agregarHelado(helado);
        System.out.println("\nSe agregó " + helado.getDescripcion() + " a la orden.\n");
    }


     /**
     * Confirma la orden si esta no esta vacia y el robot pasa a
     * preparar la orden, si la orden está vacia la confirmacion se ignora
     */
    @Override 
    public void confirmarOrden(){
         if (!robot.getOrdenActual().estaVacia()) {
            System.out.println("\nRobot ALexin: Orden CONFIRMADA, comenzare a preparar tu orden, ¡A partir de este momento no se puede cancelar!\n");
            robot.setEstado(robot.getEstadoPreparando());
        } else {
            System.out.println("\nNo se puede confirmar una orden vacia, agrega al menos un producto por favor.\n");
        }
    }

    /**
     * Cancela la orden actual y el robot vuelve a dormir
     * Solo se puede cancelar antes de confirmar
     */
    @Override 
    public void cancelarOrden(){
        System.out.println("\nRobot Alexin: Orden Cancelada\n");
        System.out.println("\nEl robot vuelve a dormir\n");
        robot.setOrdenActual(null);
        robot.setEstado(robot.getEstadoDormido());
    }

    /**
     * Aún no se puede preparar una orden que no ha sido confirmada
     */
    @Override 
    public void prepararOrden(){
         System.out.println("\nTodavia no se puede preparar la orden, primero hay que confirmarla.\n");
    }

    /**
     * Aún no hay nada que entregar mientras se esta tomando la orden
     */
    @Override 
    public void entregarOrden(){
        System.out.println("\nTodavia no hay nada que entregar, la orden no se ha confirmado\n");
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
                    System.out.println("\nOpcion no disponible. Elige una pizza del menu.\n");
                }
            } catch(InputMismatchException e){
                System.out.println("\nElige una opción valida.\n");
                leerCliente.nextLine();
            }
        }

        return listaDePizzas.get(eleccionPizza-1);

    }

     /**
     * Metodo adicional para validar y obtener que sabor de helado quiere
     * el usuario, respetando el maximo de 3 veces por
     * ingrediente y sin poder quitar un ingrediente ya agregado
     * @return el helado con sus ingredientes extra
     */
    public Helado elegirHelado(){

        Scanner leerCliente = new Scanner(System.in);
        int eleccionSabor = 0;
        boolean entradaValida = false;

        System.out.println("\n¡HOLA!, Elige el sabor de helado que quieres:\n");
        System.out.println("----MENU DE HELADO----");
        System.out.println("1. " + HeladoFresa.SABOR + " - $" + HeladoFresa.PRECIO_BASE);
        System.out.println("2. " + HeladoVainilla.SABOR + " - $" + HeladoVainilla.PRECIO_BASE);
        System.out.println("3. " + HeladoChocolate.SABOR + " - $" + HeladoChocolate.PRECIO_BASE);
        System.out.println("-----------------------\n");

        while(!entradaValida){
            try{
                eleccionSabor = leerCliente.nextInt();
                if(eleccionSabor>=1 && eleccionSabor<=3){
                    entradaValida = true;
                } else {
                    System.out.println("\nOpcion no disponible. Elige un sabor del menú.\n");
                }
            } catch(InputMismatchException e){
                System.out.println("\nElige una opcion valida.\n");
                leerCliente.nextLine();
            }
        }

        Helado helado;
        if(eleccionSabor==1){
            helado = new HeladoFresa();
        } else if(eleccionSabor==2){
            helado = new HeladoVainilla();
        } else {
            helado = new HeladoChocolate();
        }

        System.out.println("\nSabor confirmado: " + helado.getDescripcion() + "\n");

        boolean siguePidiendo = true;
        while(siguePidiendo){

            System.out.println("¿Quieres agregar un ingrediente extra a tu helado?\n" +
                    "1.- Gomitas de gusano.\n" +
                    "2.- Gomitas de panda.\n" +
                    "3.- Gomitas de aro.\n" +
                    "4.- Chispas de chocolate.\n" +
                    "5.- Malvaviscos.\n" +
                    "6.- Fresitas.\n" +
                    "7.- Manguitos.\n" +
                    "8.- Kiwis.\n" +
                    "9.- Ya no quiero agregar mas ingredientes.\n");

            int eleccionIngrediente = 0;
            boolean opcionValida = false;

            while(!opcionValida){
                try{
                    eleccionIngrediente = leerCliente.nextInt();
                    if(eleccionIngrediente>=1 && eleccionIngrediente<=9){
                        opcionValida = true;
                    } else {
                        System.out.println("\nOpcion no disponible. Elige una de las opciones anteriores.\n");
                    }
                } catch(InputMismatchException e){
                    System.out.println("\nElige una opcion valida.\n");
                    leerCliente.nextLine();
                }
            }

            if(eleccionIngrediente==9){
                siguePidiendo = false;
                continue;
            }

            String nombreIngrediente = "";
            switch(eleccionIngrediente){
                case 1: nombreIngrediente = GomitasDeGusano.NOMBRE; break;
                case 2: nombreIngrediente = GomitasDePanda.NOMBRE; break;
                case 3: nombreIngrediente = GomitasDeAro.NOMBRE; break;
                case 4: nombreIngrediente = ChispasDeChocolate.NOMBRE; break;
                case 5: nombreIngrediente = Malvaviscos.NOMBRE; break;
                case 6: nombreIngrediente = Fresitas.NOMBRE; break;
                case 7: nombreIngrediente = Manguitos.NOMBRE; break;
                case 8: nombreIngrediente = Kiwis.NOMBRE; break;
            }

            if(!helado.puedeAgregar(nombreIngrediente)){
                System.out.println("\nYa alcanzaste el maximo de " + Helado.MAX_POR_INGREDIENTE +
                        " para " + nombreIngrediente + ", elige otro ingrediente.\n");
                continue;
            }

            switch(eleccionIngrediente){
                case 1: helado = new GomitasDeGusano(helado); break;
                case 2: helado = new GomitasDePanda(helado); break;
                case 3: helado = new GomitasDeAro(helado); break;
                case 4: helado = new ChispasDeChocolate(helado); break;
                case 5: helado = new Malvaviscos(helado); break;
                case 6: helado = new Fresitas(helado); break;
                case 7: helado = new Manguitos(helado); break;
                case 8: helado = new Kiwis(helado); break;
            }

            System.out.println("\nSe agrego " + nombreIngrediente + " a tu helado.\n");
        }

        return helado;
    }
}

