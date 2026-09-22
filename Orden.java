/**
 * Clase que representa la orden de un cliente. Guarda los productos
 * que el cliente va agregando, y sabe generar el
 * ticket y calcular el total a cobrar.
 */
public class Orden {

    /** Pizza agregada a la orden, o null si aún no se ha agregado ninguna. */
    private Pizza pizza;
    /** Helado agregado a la orden, o null si aún no se ha agregado ninguno. */
    private Helado helado;
    

    /**
     * Construye una orden vacía, sin ningún producto todavía
     */
    public Orden(){
        this.pizza = null;
        this.helado = null;
    }

    /**
     * Agrega una pizza a la orden. Como el clinete solo puede pedir
     * una pizza por orden, si ya había una pizza agregada, esta se
     * reemplaza por la nueva
     * @param pizza la pizza que se agrega a la orden
     */
    public void agregarPizza(Pizza pizza){
        this.pizza = pizza;
    }

    /**
    * Agrega un helado a la orden. Como el cliente solo puede pedir
    * un helado por orden, si ya había uno agregado, este se
    * reemplaza por el nuevo
    * @param helado el helado que se agrega a la orden
    */
    public void agregarHelado(Helado helado){
    this.helado = helado;
    }

    /**
     * Indica si la orden no tiene ningún producto agregado todavía
     * Se usa para no permitir confirmar una orden vacía
     * @return true si no se ha agregado ni pizza ni helado, false en caso contrario
     */
    public boolean estaVacia(){
    return pizza == null && helado == null;
    }

    /**
     * Genera el texto del ticket que se le entrega al cliente
     * Pizza: Solo se muestra su nombre y su precio
     * Helado: Solo se muestra el sabor y cada ingrediente extra
     * @return el texto del ticker con los productos de la orden
    */
    public String generarTicket() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("----- Ticket El Pequeño Cesarín -----\n");
        if (pizza != null) {
            ticket.append(pizza.getNombre()).append(" - $").append(pizza.getPrecio()).append("\n");
        }
        if (helado != null) {
        ticket.append(helado.getDescripcion()).append(" - $").append(helado.getPrecio()).append("\n");
        }
        ticket.append("Total: $").append(calcularTotal());
        return ticket.toString();
    }

    /**
     * Calcula el precio final de la orden sumando 
     * todos los productos que contiene
     * @return el precio total de la orden
    */
    public double calcularTotal() {
        double total = 0.0;
        if (pizza != null) {
            total += pizza.getPrecio();
        }
        if (helado != null) {
        total += helado.getPrecio();
        }
        return total;
    }

    /**
     * Obteiene la pizza de la orden
     * @return la pizza agregada a la orden, o null si no se ha agregado
    */
    public Pizza getPizza() {
        return pizza;
    }

    /**
    * Obtiene el helado de la orden
    * @return el helado agregado a la orden, o null si no se ha agregado
    */
    public Helado getHelado() {
        return helado;
    }
    
}
