/**
 * Decorador concreto para agregar fresitas al helado.
 */
public class Fresitas extends IngredienteExtra {

    public static final String NOMBRE = "fresitas";
    public static final double COSTO = 15.0;

    public Fresitas(Helado helado) {
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