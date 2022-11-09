package ar.edu.unlam.pb2;

import java.time.LocalDate;

import ar.edu.unlam.pb2.enumeradores.TipoDeOperacion;

public class Accion implements Comparable<Accion> {

	private Integer identificadorDeAccion;
	private Alarma alarma;
	private Usuario quienLaRealizo;
	private Configurador usuario;
	private LocalDate fecha;
	private TipoDeOperacion tipoDeOperacion;

//	public Accion(Integer alarma, Configurador usuario, String fecha, TipoDeOperacion configuracion) {
//		this.alarma = alarma;
//		this.usuario = usuario;
//		this.fecha = fecha;
//		this.configuracion = configuracion;
//	}

	public Accion(Integer identificadorDeAccion, Alarma alarma, Usuario quienLaRealizo, LocalDate fecha,
			TipoDeOperacion tipoDeOperacion) {
		this.identificadorDeAccion = identificadorDeAccion;
		this.alarma = alarma;
		this.quienLaRealizo = quienLaRealizo;
		this.fecha = fecha;
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public Integer getIdentificadorDeAccion() {
		return identificadorDeAccion;
	}

	@Override
	public String toString() {
		return "Accion [identificadorDeAccion=" + identificadorDeAccion + ", fecha=" + fecha + ", tipoDeOperacion="
				+ tipoDeOperacion + "]";
	}

	@Override
	public int compareTo(Accion o) {
		return this.identificadorDeAccion.compareTo(o.getIdentificadorDeAccion());

	}

}
