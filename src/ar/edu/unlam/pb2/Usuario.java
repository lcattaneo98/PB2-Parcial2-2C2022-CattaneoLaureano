package ar.edu.unlam.pb2;

import ar.edu.unlam.exceptions.AlarmaNoEncontrada;
import ar.edu.unlam.exceptions.CodigoAlarmaIncorrectoException;
import ar.edu.unlam.exceptions.SensorDuplicadoException;
import ar.edu.unlam.exceptions.SensorYaEstabaActivado;
import ar.edu.unlam.exceptions.UsuarioNoEncontrado;

public class Usuario {

	private Integer dni;
	private String nombre;

	public Usuario(Integer dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean agregarUnUsuarioALaListaDeUsuariosValidos(CentralAlarmas securitas, Integer idUsuarioConfigurador,
			Integer idAlarma, Integer codigoConfiguracionAlarma)
			throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException {
		Alarma alarmaAUtilizar = securitas.getAlarma(idAlarma);
		Usuario usuarioAgregado = securitas.getUsuario(idUsuarioConfigurador);
		if (alarmaAUtilizar.getCodigoDeConfiguracion() == codigoConfiguracionAlarma) {
			alarmaAUtilizar.agregarUsuarioValido(usuarioAgregado);
			return true;
		}
		throw new CodigoAlarmaIncorrectoException();
	}

	public Boolean agregarSensorAAlarma(CentralAlarmas securitas, Integer idAlarma, Integer codigoConfiguracionAlarma,
			Sensor sensor, Integer idUsuarioConfigurador)
			throws AlarmaNoEncontrada, SensorDuplicadoException {
		Alarma alarmaAAgregarSensor = securitas.getAlarma(idAlarma);
		if (alarmaAAgregarSensor.getCodigoDeConfiguracion().equals(codigoConfiguracionAlarma)) {
			alarmaAAgregarSensor.agregarSensor(sensor);
		}
		return null;
			
	}

	public boolean activarSensorDeAlarma(CentralAlarmas securitas, Integer idSensor, Integer idAlarma,
			String codigoActivacionAlarma) throws AlarmaNoEncontrada, SensorYaEstabaActivado {
		Alarma alarmaAUtilizar = securitas.getAlarma(idAlarma);
		Sensor sensorAActivar = alarmaAUtilizar.getSensor(idSensor);
		if (sensorAActivar.getEstado() == false) {
			sensorAActivar.activar();
			return true;
		}
		throw new SensorYaEstabaActivado();
	}

}
