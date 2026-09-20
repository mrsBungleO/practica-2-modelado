/**
 * Clase concreta que representa un tipo de pizza (de mariscos).
 */
public class PizzaDeMariscos extends Pizza{

    /**
     * constructor de PizzaDeMariscos. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaDeMariscos(){
        super(44445, "Pizza de mariscos", "contiene camarón, pulpo y queso manchego.", 159.99,false);
    }

    /**
     * método que sobreescribe el método hook para un caso donde la pizza contiene un queso distinto al mozzarella (manchego).
     */
    @Override
    public void colocarQuesoConHook(){
        System.out.println("El robot Cesarín agrega queso manchego rayado a la masa.");
    }

    /**
     * implemetación del método abstracto colocarProteina, en este caso para que aplique los camarones y el pulpo a la masa.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Cesarín agrega algunos camarones y un poco de pulpo en trozos a la masa de manera uniforme.");
    }
}