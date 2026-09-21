/**
 * Decorador concreto para agregar chispas de chocolate al helado.
 */
public class ChispasDeChocolate extends IngredienteExtra {

    public static final String NOMBRE = "chispas de chocolate";
    public static final double COSTO = 8.0;

    public ChispasDeChocolate(Helado helado) {
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