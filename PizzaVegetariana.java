/**
 * Clase concreta que representa un tipo de pizza (vegetariana).
 */
public class PizzaVegetariana implements Pizza{

    /**
     * constructor de PizzaVegetariana. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaVegetariana(){
        super(33345,"Pizza vegetariana", "contiene champiñones, berenjena, elote dulce, cebolla morada en rodajas y queso mozzarella", 135.0, true);
    }

    /**
     * implementación del método abstracto colocarProteina, en este caso para que aplique el conjunto de vegetales.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Cesarín agrega la ensalada de champiñones, berenjena en rodajas y cebolla morada en rodajas a la masa de manera uniforme.");
    }
}