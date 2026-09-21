/**
 * Decorador concreto para agregar manguitos al helado.
 */
public class Manguitos extends IngredienteExtra {

    public static final String NOMBRE = "manguitos";
    public static final double COSTO = 15.0;

    public Manguitos(Helado helado) {
        super(helado);
    }

    @Override
    public String getDescripcion() {
        return helado.getDescripcion() + ", " + NOMBRE;
    }

    @Override
    public double getPrecio() {
        return helado.getPrecio() + COSTO;
    }

    @Override
    public int contarIngrediente(String nombre) {
        if (NOMBRE.equalsIgnoreCase(nombre)) {
            return helado.contarIngrediente(nombre) + 1;
        }
        return helado.contarIngrediente(nombre);
    }
}