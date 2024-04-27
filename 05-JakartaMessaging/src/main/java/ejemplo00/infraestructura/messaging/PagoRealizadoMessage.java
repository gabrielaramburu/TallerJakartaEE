package ejemplo00.infraestructura.messaging;


import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import jakarta.json.stream.JsonParser;

import java.io.BufferedOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public record PagoRealizadoMessage(
        String descripcion,
        double monto,
        int idCliente
) {
    /**
     * Al librerías de terceros que facilitan el trabajo con json
     * pero preferí usar la librería de jakarta para no importar
     * librerías de terceros.
     *
     * @return
     */
    public String toJson() {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("descripcion", this.descripcion)
                .add("monto", this.monto)
                .add("idCliente", this.idCliente).build();

       StringWriter sw = new StringWriter();
       JsonWriter jsonWriter = Json.createWriter(sw);
       jsonWriter.write(jsonObject);
       jsonWriter.close();
       return sw.toString();
    }

    public static PagoRealizadoMessage buildFromJson(String jsonPagoRealizada) {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonPagoRealizada));
        JsonObject objeto = jsonReader.readObject();
        PagoRealizadoMessage pago = new PagoRealizadoMessage(
                objeto.getString("descripcion"),
                objeto.getInt("monto"),
                objeto.getInt("idCliente"));
        return pago;
    }
}

