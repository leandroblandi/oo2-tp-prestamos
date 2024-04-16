package modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cuota {
	private long idCuota;
	private int nroCuota;
	private LocalDate fechaVencimiento;
	private LocalDate fechaPago;
	private double saldoPendiente;
	private double amortizacion;
	private double interesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private double punitorios;
	private Prestamo prestamo;

	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", nroCuota=" + nroCuota + ", fechaVencimiento=" + fechaVencimiento
				+ ", fechaPago=" + fechaPago + ", saldoPendiente=" + saldoPendiente + ", amortizacion=" + amortizacion
				+ ", interesCuota=" + interesCuota + ", cuota=" + cuota + ", deuda=" + deuda + ", cancelada="
				+ cancelada + ", punitorios=" + punitorios + "]";
	}
}
