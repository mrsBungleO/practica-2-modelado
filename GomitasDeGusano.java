/**
 * Decorador concreto para agregar gomitas de gusano al helado.
 */
public class GomitasDeGusano extends IngredienteExtra {

    public static final String NOMBRE = "gomitas de gusano";
    public static final double COSTO = 12.0;

    /**
     * Agrega gomitas de gusano al helado recibido.
     * @param helado helado al que se le sumara este ingrediente.
     */
    public GomitasDeGusano(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripcion acumulada sumando el ingrediente a la lista.
     * @return texto con los ingredientes previos mas estos.
     */
    @Override
    public String getDescripcion() {
        return helado.getDescripcion() + ", " + NOMBRE;
    }

    /**
     * Calcula el precio acumulado sumando el costo del ingrediente.
     * @return precio total con el costo extra.
     */
    @Override
    public double getPrecio() {
        return helado.getPrecio() + COSTO;
    }

    /**
     * Cuenta cuantas veces se ha agregado un ingrediente buscando capa por capa.
     * Si esta capa coincide con el ingrediente buscado, le suma 1 al conteo
     * de las capas de adentro; si no, solo pasa la consulta hacia abajo.
     * 
     * @param nombre nombre del ingrediente que se esta buscando/validando.
     * @return total de veces que aparece este ingrediente en el helado.
     */
    @Override
    public int contarIngrediente(String nombre) {
        if (NOMBRE.equalsIgnoreCase(nombre)) {
            return helado.contarIngrediente(nombre) + 1;
        }
        return helado.contarIngrediente(nombre);
    }
}