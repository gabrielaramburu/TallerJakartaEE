package ejemplo00.interfase.api.rest.dto;

import lombok.Data;

@Data
public class MovimientoDTO  {
    private double importe;
    private String desc;

    public MovimientoDTO() {

    }
    public MovimientoDTO(double importe, String desc) {
        this.importe = importe;
        this.desc = desc;
    }
}
