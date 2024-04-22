package ejemplo00.dominio;

import ejemplo00.dominio.exception.SaldoInsuficienteException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    private int id;
    private String nombre;
    private double saldo; //valor calculado

    @Transient
    private List<Movimiento> movimientos;

    public Cliente() {

    }

    public Cliente(int id, String nombre, double saldo, List<Movimiento> movimientos) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.movimientos = movimientos;
    }

    public void actualizarSaldo(Movimiento mov) throws SaldoInsuficienteException {
        if (mov.getTipoMov().equals(TipoMovimiento.DEBITO)){
           if (this.getSaldo() < mov.getImporte()) {
               throw new SaldoInsuficienteException();
           } else {
               this.setSaldo(
                       this.getSaldo() - mov.getImporte());
           }
        } else {
            this.setSaldo(
                    this.getSaldo() + mov.getImporte());
        }
        System.out.println("Nuevo saldo: " + this.toString() );
    }
}
