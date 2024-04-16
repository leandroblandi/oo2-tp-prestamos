package modelo;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantidadCuotas;
	private boolean cancelado;
	private Cliente cliente;
	private Set<Cuota> cuotas;
	
	public boolean agregarCuota(Cuota c) {
		return this.cuotas.add(c);
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + fecha + ", monto=" + monto + ", interes=" + interes
				+ ", cantidadCuotas=" + cantidadCuotas + ", cancelado=" + cancelado + ", cuotas=" + cuotas + "]";
	}
}
