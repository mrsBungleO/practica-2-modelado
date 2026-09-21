/**
 * Clase abstracta que representa la base de un helado.
 * Maneja la descripcion general y valida que no se repitan ingredientes mas del limite.
 */
public abstract class Helado {

    protected String descripcion;
    public static final int MAX_POR_INGREDIENTE = 3;

    /**
     * Constructor vacio para inicializar el helado base.
     */
    public Helado() {
    }

    /**
     * Devuelve la descripcion o lista de ingredientes acumulados.
     * @return texto con la descripcion.
     */
    public abstract String getDescripcion();

    /**
     * Devuelve el precio total del helado.
     * @return precio en double.
     */
    public abstract double getPrecio();

    /**
     * Cuenta cuantas veces se ha agregado un ingrediente especifico en este helado.
     * @param nombre nombre del ingrediente a buscar.
     * @return cantidad de veces que aparece.
     */
    public abstract int contarIngrediente(String nombre);

    /**
     * Revisa si todavia se puede agregar un ingrediente sin pasar el limite de 3.
     * @param nombre nombre del ingrediente que se quiere poner.
     * @return true si se puede agregar, false si ya llego al limite.
     */
    public boolean puedeAgregar(String nombre) {
        return contarIngrediente(nombre) < MAX_POR_INGREDIENTE;
    }
}