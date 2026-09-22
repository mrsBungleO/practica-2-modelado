import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Clase abstracta que da la "plantilla" para un objeto Pizza. 
 * Le asigna propiedades como un id para identificarla, un nombre,
 * una descripción, un precio y un identificador para saber si es vegetariana. 
 * También contiene varios métodos que construyen al patrón template en el método prepararPizza.
 */
public abstract class Pizza{
    /**
     * Los atributos son protected para que las clases que implementen a Pizza puedan acceder a ellos si es que lo necesita.
     */
    /**ID de la pizza. */
    protected int id;

    /**Nombre de la pizza */
    protected String nombre;

    /**Descripción de la pizza (qué ingredientes contiene). */
    protected String descripcion;

    /**Precio de la pizza */
    protected double precio;

    /**Identificador para saber si la pizza es vegetariana */
    protected boolean esVegetariana;

    /**Constructor de Pizza
     * @param id El ID para identificar la pizza.
     * @param nombre El nombre de la pizza
     * @param descripcion Una especificación de los ingredientes que contiene la pizza
     * @param precio El precio de la pizza
     * @param esVegetariana Indicador para saber si la pizza es vegetariana
     */
    public Pizza(int id, String nombre, String descripcion, double precio, boolean esVegetariana){
        
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.esVegetariana=esVegetariana;

    }

    /**
     * obtiene el ID de la pizza
     * @return el ID de la pizza
     */
    public int getID(){
        return id;
    }

    /**
     * obtiene el nombre de la pizza
     * @return el nombre de la pizza
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * obtiene la descripción de la pizza 
     * @return la descripcion de la pizza
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * obtiene el precio de la pizza
     * @return el precio de la pizza
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * obtiene el dato que nos dice si la pizza es vegetariana
     * @return si la pizza es vegetariana o no
     */
    public boolean getEsVegetariana(){
        return esVegetariana;
    }

    /**
     * método template que amalgama otros métodos que describen los pasos para preparar una pizza.
     */
    public void prepararPizza(){

        Scanner leer= new Scanner(System.in);
        int tipoMasa=0;
        boolean entradaValida=false;

        System.out.println("----Comenzando la preparación----");
        System.out.println("¿Qué tipo de masa le gustaría que llevara su pizza?\n");
        
        while(!entradaValida){
            try{
                System.out.println("1. Napolitana \n2. Romana\n3. Americana\n");
        
                tipoMasa=leer.nextInt();

                if(tipoMasa>=1 && tipoMasa<=3){
                    entradaValida=true;
                } else{
                    System.out.println("\nOpción no disponible. Elige una de las siguientes opciones:\n");
                }
            }catch(InputMismatchException e){
                System.out.println("\nIntroduce una opción válida.\n");
                leer.nextLine();
            }
        }
        
       

        System.out.println("\nTipo de masa confirmada. En un momento estará lista su pizza.\n");

        this.prepararMasa(tipoMasa);
        this.aplanarMasa();
        this.colocarSalsaDeTomate();
        this.colocarQuesoConHook();
        this.colocarEspecias();
        this.colocarProteina();
        this.hornear();
        this.esperar();
        this.sacarDelHorno();
        this.empaquetar();

    }

    /**
     * método que explica como nuestro robot preparará la masa dependiendo de que masa escoja el cliente.
     * @param tipoMasa el numero que indica el tipo de masa
     */
    public void prepararMasa(int tipoMasa){
        if(tipoMasa==1){
            System.out.println("El robot Cesarín prepara una masa napolitana.");
        } else if(tipoMasa==2){
            System.out.println("El robot Cesarín prepara una masa romana.");
        }else if(tipoMasa==3){
            System.out.println("El robot Cesarín prepara una masa americana.");
        }
    }

    /**
     * método que explica como nuestro robot aplana la masa.
     */
    public void aplanarMasa(){
        System.out.println("El robot Cesarín aplana la masa con su rodillo.");
    }

    /**
     * método que explica como nuestro robot aplica la salsa de tomate en la masa
     */
    public void colocarSalsaDeTomate(){
        System.out.println("El robot Cesarín agrega la salsa de tomate a la masa y la esparce con su cucharón.");
    }

    /**
     * método hook que hace que nuestra opción por default de queso sea el queso mozzarella.
     */
    public void colocarQuesoConHook(){
        System.out.println("El robot Cesarín agrega queso mozzarella a la masa");
    }

    /**
     * método que explica como nuestro robot pone las especias en la masa.
     */
    public void colocarEspecias(){
        System.out.println("El robot cesarín espolvorea orégano, albahaca y tomillo a la masa.");
    }

    /**
     * método abstracto que indicará como se coloca la proteina de cada pizza en las clases concretas.
     */
    public abstract void colocarProteina();

    /**
     * método que explica como nuestro robot hornea la pizza.
     */
    public void hornear(){
        System.out.println("El robot Cesarín lleva la pizza al horno para que se cocine.");
    }

    /**
     * método que explica como nuestro robot espera a que se termine de hornear la pizza.
     */
    public void esperar(){
        System.out.println("El robot Cesarín espera pacientemente a que este lista la pizza.");
    }

    /**
     * método que explica como nuestro robot saca del horno la pizza.
     */
    public void sacarDelHorno(){
        System.out.println("El robot Cesarín saca del horno con una pala especial la pizza del horno y la coloca en una charola.");
    }

    /**
     * método que explica como nuestro robot empaqueta la pizza.
     */
    public void empaquetar(){
        System.out.println("El robot Cesarín pasa la pizza a una caja, la cierra y agrega chile quebrado y sobres de ketchup a la orden.");
    }




}