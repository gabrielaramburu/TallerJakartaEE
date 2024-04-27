package ejemplo00.interfase.api;

/**
 * Data Transfer Object es un patrón de diseño que permite intercambiar información
 * entre las diferentes capas de un aplicación.
 *
 * @param descripcion
 * @param monto
 * @param idCliente
 */
public record PagoDTO (
        String descripcion,
        double monto,
        int idCliente) {
}
