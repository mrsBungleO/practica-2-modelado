/**
 * Clase concreta que representa un tipo de pizza (hawaiiana).
 */
public class PizzaHawaiiana extends Pizza{
    
    /**
     * constructor de PizzaHawaiiana. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaHawaiiana(){
        super(22345,"Pizza Hawaiiana", "contiene cubos de jamón, cubos de piña y queso mozzarella.", 109.99, false);
    }
   
    /**
     * implementación del método abstracto colocarProteina, en este caso para que aplique el jamón con la piña.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Cesarin agrega los cubitos de jamón y de piña a la masa de manera uniforme.");
    }
}