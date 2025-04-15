package interfaces;

import lombok.Data;

/**
 * En este ejemplo no quiero exponer un objeto del dominio. Por eso creo un DTO
 */
@Data
public class DTOMovimiento {
	public enum TipoMovimientoEnum {
		DEPOSITO,
		RETIRO
	}
	
	public int importe;
	public TipoMovimientoEnum tipoMovimiento;
	public String concepto;
	
}
