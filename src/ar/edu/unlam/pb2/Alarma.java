package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.exceptions.SensorDuplicadoException;
import ar.edu.unlam.pb2.enumeradores.TipoDeOperacion;

public class Alarma {

	Integer id;
	Integer codigoDeActivacion;
	Integer codigoDeConfiguracion;
	String nombre;
	List<Usuario> usuariosValidos;
	List<Accion> accionesRealizadas;
	Set<Sensor> sensores;
	Boolean estado;

	public Alarma(Integer id, Integer codigoDeActivacion, Integer codigoDeConfiguracion, String string) {
		this.id = id;
		this.codigoDeActivacion = codigoDeActivacion;
		this.codigoDeConfiguracion = codigoDeConfiguracion;
		this.nombre = string;
		this.usuariosValidos = new ArrayList<Usuario>();
		this.accionesRealizadas = new ArrayList<Accion>();
		this.sensores = new HashSet<Sensor>();
		this.estado = false;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCodigoDeActivacion() {
		return codigoDeActivacion;
	}

	public Integer getCodigoDeConfiguracion() {
		return codigoDeConfiguracion;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void agregarUsuarioValido(Usuario usuario) {
		usuariosValidos.add(usuario);
	}

	public List<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}

	public List<Accion> getAccionesRealizadas() {
		return accionesRealizadas;
	}

	public Set<Sensor> getSensores() {
		return sensores;
	}

	public void agregarAccion(Integer identificadorDeAccion, Alarma alarma, Usuario quienLaRealizo, LocalDate fecha,
			TipoDeOperacion tipoDeOperacion) {
		Accion operacionRealizada = new Accion(identificadorDeAccion, alarma, quienLaRealizo, fecha, tipoDeOperacion);
		accionesRealizadas.add(operacionRealizada);

	}

	public void agregarSensor(Sensor sensor) throws SensorDuplicadoException {
		if (sensores.add(sensor) == false) {
			throw new SensorDuplicadoException();
		}
		sensores.add(sensor);

	}

	public Sensor getSensor(Integer idSensor) {
		for (Sensor sensor : sensores) {
			if (sensor.getIdNumerico() == idSensor)
				return sensor;
		}
		return null;
	}

	public Integer getCantidadSensoresDesactivados() {
		Integer cantidadSensoresDesactivados = 0;
		for (Sensor sensor : sensores) {
			if (sensor.getEstado() == false)
				cantidadSensoresDesactivados++;
		}
		return cantidadSensoresDesactivados;
	}

	public Set<Accion> getAccionesOrdenadasPorId() {
		Set <Accion> accionesOrdenadasPorId = new TreeSet<>();
		accionesOrdenadasPorId.addAll(this.accionesRealizadas);
		return accionesOrdenadasPorId;

		
	}
}
