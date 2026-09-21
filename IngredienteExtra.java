/**
 * Clase abstracta que sirve como decorador para los ingredientes extra del helado.
 * Guarda una referencia al helado anterior y delega el comportamiento.
 */
public abstract class IngredienteExtra extends Helado {

    protected Helado helado;

    /**
     * Constructor que envuelve al helado actual.
     * @param helado el objeto helado sobre el cual se agregara el ingrediente.
     */
    public IngredienteExtra(Helado helado) {
        this.helado = helado;
    }

    @Override
    public String getDescripcion() {
        return helado.getDescripcion();
    }

    @Override
    public double getPrecio() {
        return helado.getPrecio();
    }

    @Override
    public int contarIngrediente(String nombre) {
        return helado.contarIngrediente(nombre);
    }
}