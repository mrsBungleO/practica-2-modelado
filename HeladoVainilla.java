/**
 * Clase que representa un helado de sabor vainilla.
 */
public class HeladoVainilla extends Helado {

    public static final String SABOR = "Helado de Vainilla";
    public static final double PRECIO_BASE = 30.0;

    /**
     * Constructor que asigna la descripcion inicial del helado de vainilla.
     */
    public HeladoVainilla() {
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