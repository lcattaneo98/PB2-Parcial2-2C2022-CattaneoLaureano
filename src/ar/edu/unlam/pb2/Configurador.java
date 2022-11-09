package ar.edu.unlam.pb2;

import ar.edu.unlam.exceptions.AlarmaNoEncontrada;
import ar.edu.unlam.exceptions.CodigoAlarmaIncorrectoException;
import ar.edu.unlam.exceptions.SensorDuplicadoException;
import ar.edu.unlam.exceptions.SensorYaEstabaActivado;
import ar.edu.unlam.exceptions.UsuarioNoEncontrado;
import ar.edu.unlam.pb2.interfaces.IConfigurable;

public class Configurador extends Usuario implements IConfigurable {

	public Configurador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

//	public boolean agregarUnUsuarioALaListaDeUsuariosValidos(CentralAlarmas securitas, Integer idUsuarioConfigurador, Integer idAlarma,
//			Integer codigoConfiguracionAlarma) throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException {
//		Alarma alarmaAUtilizar = securitas.getAlarma(idAlarma);
//		Usuario usuarioAgregado = securitas.getUsuario(idUsuarioConfigurador);
//		if (alarmaAUtilizar.getCodigoDeConfiguracion() == codigoConfiguracionAlarma) {
//			alarmaAUtilizar.agregarUsuarioValido(usuarioAgregado);
//			return true;
//		}
//			throw new CodigoAlarmaIncorrectoException();
//	}
//	
// 	public boolean agregarSensorAAlarma(CentralAlarmas securitas, Integer idAlarma, Integer codigoConfiguracionAlarma, Sensor sensor,Integer idUsuarioConfigurador) throws AlarmaNoEncontrada, UsuarioNoEncontrado, SensorDuplicadoException {
// 		Alarma alarmaAUtilizar = securitas.getAlarma(idAlarma);
//		Usuario usuarioAgregado = securitas.getUsuario(idUsuarioConfigurador);
//		if (alarmaAUtilizar.getCodigoDeConfiguracion() == codigoConfiguracionAlarma) {
//			alarmaAUtilizar.agregarSensor(sensor);
//			return true;
//		}
//		return false;
// 	}
// 	
// 	public boolean activarSensorDeAlarma(CentralAlarmas securitas, Integer idSensor, Integer idAlarma, String codigoActivacionAlarma) throws AlarmaNoEncontrada, SensorYaEstabaActivado {
// 		Alarma alarmaAUtilizar = securitas.getAlarma(idAlarma);
// 		Sensor sensorAActivar = alarmaAUtilizar.getSensor(idSensor);
//		if (sensorAActivar.getEstado() == false) {
//			sensorAActivar.activar();
//			return true;
//		}
// 		throw new SensorYaEstabaActivado();
// 	}

}
