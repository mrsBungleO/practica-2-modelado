/**
 * Clase concreta que representa un tipo de pizza (de pepperoni).
 */
public class PizzaDePepperoni implements Pizza{
    
    /**
     * constructor de PizzaDePepperoni. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaDePepperoni(){
        super(12345,"Pizza de pepperoni", "contiene queso mozzarella y pepperoni.", 99.99, false);
    }

    /**
     * implemetación del método abstracto colocarProteina, en este caso para que aplique pepperoni.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Cesarín agrega pepperoni a la masa de manera uniforme.");
    }
}