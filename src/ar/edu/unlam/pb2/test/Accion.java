package ar.edu.unlam.pb2.test;

import ar.edu.unlam.pb2.Configurador;

public class Accion {

	private Integer alarma;
	private Configurador usuario;
	private String fecha;
	private TipoDeOperacion configuracion;

	public Accion(Integer alarma, Configurador usuario, String fecha, TipoDeOperacion configuracion) {
		this.alarma = alarma;
		this.usuario = usuario;
		this.fecha = fecha;
		this.configuracion = configuracion;
	}

}
