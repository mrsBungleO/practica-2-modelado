/**
 * Clase abstracta base para los helados.
 * Define la estructura general y la validacion de limite de ingredientes.
 */
public abstract class Helado {

    protected String descripcion;
    public static final int MAX_POR_INGREDIENTE = 3;

    /**
     * Constructor vacio para las subclases.
     */
    public Helado() {
    }

    /**
     * Devuelve la descripcion del helado con sus ingredientes acumulados.
     * @return descripcion del helado.
     */
    public abstract String getDescripcion();

    /**
     * Devuelve el precio actual del helado.
     * @return precio en double.
     */
    public abstract double getPrecio();

    /**
     * Cuenta cuantas veces se ha agregado un ingrediente especifico.
     * @param nombre nombre del ingrediente a buscar.
     * @return cantidad de veces que aparece el ingrediente.
     */
    public abstract int contarIngrediente(String nombre);

    /**
     * Revisa si todavia se puede agregar un ingrediente sin superar el limite de 3.
     * @param nombre nombre del ingrediente a validar.
     * @return true si se puede agregar, false si ya alcanzo el maximo.
     */
    public boolean puedeAgregar(String nombre) {
        return contarIngrediente(nombre) < MAX_POR_INGREDIENTE;
    }
}