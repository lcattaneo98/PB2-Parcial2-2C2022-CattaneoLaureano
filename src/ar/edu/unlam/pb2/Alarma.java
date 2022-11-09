package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.pb2.test.Accion;

public class Alarma {
	
	Integer id;
	Integer codigoDeActivacion;
	Integer codigoDeConfiguracion;
	String nombre;
	List<Usuario> usuariosValidos;
	List<Identificador> identificador;
	List<Sensor> sensores;
	Boolean estado;

	public Alarma(Integer id, Integer codigoDeActivacion, Integer codigoDeConfiguracion, String string) {
		this.id = id;
		this.codigoDeActivacion = codigoDeActivacion;
		this.codigoDeConfiguracion = codigoDeConfiguracion;
		this.nombre = nombre;
		this.usuariosValidos = new ArrayList<Usuario>();
		this.identificador = new ArrayList<Identificador>();
		this.sensores = new ArrayList<Sensor>();
	}

}
