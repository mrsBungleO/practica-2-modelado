import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Clase que se encarga de la interacción principal con el usuario o cliente.
 */
public class SistemaCliente{
    
    /**
     * Método que se encarga de mostrar las opciones de lo que se le puede mandar al robot que haga y 
     * de validar que lo que el usuario le mande a hacer este dentro de las opciones. 
     */
    public void accionRobot(){
        Scanner sc= new Scanner(System.in);
        int opcion=0;

        Robot robot= new Robot();
        System.out.println("\n----------EL PEQUEÑO CESARÍN----------\n");
        System.out.println("¡Bienvenido a \"El Pequeño Cesarín\"!");
        System.out.println("Nuestro robot Alexin te atendera.");

        do{
            System.out.println("El robot (Alexin se encuentra: " + robot.mostrarEstado() + ").");
            //agregar cuantas pizzas y cuantos helados le pidieron al robot

            System.out.println("Indica que accion quieres que realice Alexin:\n" + 
                    "\n1.- Llamar al robot.\n" + 
                    "2.- Ordenar una pizza.\n" +
                    "3.- Ordenar un helado.\n" + 
                    "4.- Confirmar la orden.\n" + 
                    "5.- Cancelar la orden.\n" + 
                    "6.- Preparar la orden.\n" + 
                    "7.- Entregar la orden.\n" + 
                    "8.- Salir del restaurante.\n");

                    while(true){
                        try{
                            opcion=sc.nextInt();
                            break;
                        } catch(InputMismatchException e){

                            System.out.println("\nError. Debes ingresar un numero entero.\n");
                            sc.nextLine();
                            
                            System.out.println("Ingresa una opcion valida:");
                            System.out.println("1.- Llamar al robot.\n" + 
                                "2.- Ordenar una pizza.\n" +
                                "3.- Ordenar un helado.\n" + 
                                "4.- Confirmar la orden.\n" + 
                                "5.- Cancelar la orden.\n" + 
                                "6.- Preparar la orden.\n" + 
                                "7.- Entregar la orden.\n" + 
                                "8.- Salir del restaurante.\n");

                        }
                    }

                    switch(opcion){
                        case 1: 
                            robot.llamar();
                            break;
                        
                        case 2:
                            robot.ordenarPizza();
                            break;

                        case 3: 
                            robot.ordenarHelado();
                            break;

                        case 4: 
                            robot.confirmarOrden();
                            break;

                        case 5: 
                            robot.cancelarOrden();
                            break;

                        case 6:
                            robot.prepararOrden();
                            break;

                        case 7:
                            robot.entregarOrden();
                            break;

                        case 8: 
                            System.out.println("\n¡Gracias por visitarnos! Vuelve pronto.");
                            break;
                       
                        default:
                            System.out.println("\nEsta opcion no está disponible. Ingresa una de las siguientes opciones:\n");
                            break;

                    }
        } while(opcion!=8);
        sc.close();

    }
}