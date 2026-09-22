/**
 * Clase concreta que representa un tipo de pizza (al pastor). 
 */
public class PizzaAlPastor extends Pizza{

    /**
     * constructor de PizzaAlPastor. Utiliza la herencia de Pizza y, por ende, su constructor.
     */
    public PizzaAlPastor(){
        super(55551, "Pizza de carne al pastor", "Contiene carne al pastor, trozos de piña, cebolla picada, cilantro picado y queso gouda.", 150.50,false);
    }
    
    /**
     * método que sobreescribe el método hook para un caso donde la pizza contiene un queso distinto al mozzarella (gouda).
     */
    @Override
    public void colocarQuesoConHook(){
        System.out.println("El robot Alexin agrega queso gouda rayado a la masa.");
    }

    /**
     * implementación del método abstracto colocarProteina, en este caso para que aplique carne al pastor y demás acompañamientos.
     */
    @Override
    public void colocarProteina(){
        System.out.println("El robot Alexin agrega la carne al pastor con trozos de piña y cebolla y cilantro picados de manera uniforme a la masa.");
    }
}