/**
 * Clase que representa un helado de sabor fresa.
 */
public class HeladoFresa extends Helado {

    public static final String SABOR = "Helado de Fresa";
    public static final double PRECIO_BASE = 20.0;

    /**
     * Constructor que asigna la descripcion inicial del helado de fresa.
     */
    public HeladoFresa() {
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
        // Al ser la base sin ingredientes extra, siempre regresa 0
        return 0;
    }
}