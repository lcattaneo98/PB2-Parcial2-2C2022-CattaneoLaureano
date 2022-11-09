package ar.edu.unlam.pb2;

import java.util.Iterator;

import ar.edu.unlam.exceptions.AlarmaNoEncontrada;
import ar.edu.unlam.exceptions.CodigoActivacionIrreconocible;
import ar.edu.unlam.pb2.interfaces.IActivable;

public class Administrador extends Usuario implements IActivable {

	public Administrador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

	public Boolean agregarAlarma(CentralAlarmas securitas, Alarma alarma) {
		return securitas.agregarAlarma(alarma);
	}

	public Boolean agregarUsuario(CentralAlarmas securitas, Usuario usuario) {
		return securitas.agregarUsuario(usuario);

	}

	public boolean activarDesactivarAlarma(CentralAlarmas securitas, Integer idAlarma, Integer codigoActivacionAlarma,
			Usuario usuario) throws AlarmaNoEncontrada {
		Alarma alarmaACambiarEstado = securitas.getAlarma(idAlarma);
		if (alarmaACambiarEstado.getCodigoDeActivacion() == codigoActivacionAlarma) {

		}
		return false;

	}

	public boolean activarDesactivarAlarma(CentralAlarmas securitas, Alarma alarma, Integer codigoActivacionAlarma)
			throws CodigoActivacionIrreconocible, AlarmaNoEncontrada {

		Alarma alarmaAActivar = securitas.getAlarma(alarma.getId());
		if (alarmaAActivar.getCodigoDeActivacion().equals(codigoActivacionAlarma) && alarmaAActivar
				.getCantidadSensoresDesactivados() == 0) {
			alarmaAActivar.setEstado(true);
			return true;
		} else {
			alarmaAActivar.setEstado(false);
			return false;
		}
		
	}
}
