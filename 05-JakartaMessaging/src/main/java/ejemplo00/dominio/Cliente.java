package ejemplo00.dominio;
import lombok.Data;

@Data
public class Cliente {
    private int id;
    private String nombre;

    public Cliente(int id) {
        this.id = id;
    }
}
