/**
 * Clase que representa un helado de sabor chocolate.
 */
public class HeladoChocolate extends Helado {

    public static final String SABOR = "Helado de Chocolate";
    public static final double PRECIO_BASE = 40.0;

    /**
     * Constructor que asigna la descripcion inicial del helado de chocolate.
     */
    public HeladoChocolate() {
        this.descripcion = SABOR;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public double getPrecio() {
        return PRECIO_BASE;
    }

    @Override
    public int contarIngrediente(String nombre) {
        return 0;
    }
}