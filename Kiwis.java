/**
 * Decorador concreto para agregar kiwis al helado.
 */
public class Kiwis extends IngredienteExtra {

    public static final String NOMBRE = "kiwis";
    public static final double COSTO = 15.0;

    public Kiwis(Helado helado) {
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