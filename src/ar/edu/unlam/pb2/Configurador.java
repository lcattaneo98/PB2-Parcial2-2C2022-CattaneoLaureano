package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.interfaces.IConfigurable;

public class Configurador extends Usuario implements IConfigurable {

	public Configurador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}
 	public boolean agregarAlarma(CentralAlarmas securitas, Alarma alarma) {
		return securitas.agregarAlarma(alarma);
 		
 	}
 	public boolean agregarUsuario(CentralAlarmas securitas, Usuario usuario) {
 		
		return false;
 		
 		
 	}
 	public void agregarUsuarioAUnaAlarma(Integer dniUsuarioAAgregar, Integer idAlarma, String codigoConfiguracionAlarma){
 		
 	}
 	public boolean agregarSensorAAlarma(Integer idAlarma, String codigoConfiguracionAlarma, Sensor sensor, Integer idUsuarioConfigurador) {
		return false;
 		
 	}
 	public boolean activarSensorDeAlarma(int idSensor, int idAlarma, String codigoActivacionAlarma) {
		return false;
 		
 	}
 	public boolean activarDesactivarAlarma(int idAlarma, String codigoActivacionAlarma, Configurador usuario) {
		return false;
 		
 	}
}
