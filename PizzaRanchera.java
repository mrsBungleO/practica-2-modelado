/**
 * Clase concreta que representa un tipo de pizza (ranchera).
 */
public class PizzaRanchera extends Pizza{

    /**
     * constructor de PizzaRanchera. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaRanchera(){
        super(54321, "Pizza ranchera", "contiene una capa de frijoles, chorizo, aguacate y queso mozzarella.", 109.99, false);
    }

    /**
     * implemetación del método abstracto colocarProteina, en este caso para que aplique el chorizo y demás acompañamientos.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Alexin agrega la capa de frijoles, los trozos de chorizo frito y las rebanadas de aguacate a la masa de manera uniforme. ");
    }
}