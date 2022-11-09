package ar.edu.unlam.pb2;

import java.util.Objects;

import ar.edu.unlam.exceptions.SensorDuplicadoException;

public class Sensor {

	private Integer idNumerico;
	private Boolean estado;

	public Sensor(Integer idNumerico, Boolean estado) {
		this.idNumerico = idNumerico;
		this.estado = estado;
	}

	public Integer getIdNumerico() {
		return idNumerico;
	}

	public Boolean getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNumerico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(idNumerico, other.idNumerico);

	}

	public void activar() {
		this.estado = true;

	}

}
