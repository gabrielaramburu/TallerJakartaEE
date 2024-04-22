package ejemplo00.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime fecha;

    //desc es una palabra reservada del sql, no se puede usar como nombre de campo
    //sería más cambiar el nombre del atributo, pero lo dejo comentado para tenerlo presete
    @Column(name = "description")
    private String desc;
    private double importe;
    private TipoMovimiento tipoMov;

    @ManyToOne
    private Cliente cliente;

    public Movimiento() {

    }
    public Movimiento(int id, LocalDateTime fecha, String desc, double importe, TipoMovimiento tipoMov) {
        this.id = id;
        this.fecha = fecha;
        this.desc = desc;
        this.importe = importe;
        this.tipoMov = tipoMov;
    }

    public Movimiento(LocalDateTime fecha, String desc, double importe, TipoMovimiento tipoMov) {
        this.id = id;
        this.fecha = fecha;
        this.desc = desc;
        this.importe = importe;
        this.tipoMov = tipoMov;
    }
}
