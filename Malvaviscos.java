/**
 * Decorador concreto para agregar malvaviscos al helado.
 */
public class Malvaviscos extends IngredienteExtra {

    public static final String NOMBRE = "malvaviscos";
    public static final double COSTO = 10.0;

    public Malvaviscos(Helado helado) {
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