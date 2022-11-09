package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.exceptions.AlarmaNoEncontrada;
import ar.edu.unlam.exceptions.UsuarioNoEncontrado;

public class CentralAlarmas {

	List<Alarma> alarmas;
	List<Usuario> usuarios;

	public CentralAlarmas() {
		this.alarmas = new ArrayList<Alarma>();
		this.usuarios = new ArrayList<Usuario>();
	}

	public List<Alarma> getAlarmas() {
		return alarmas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Boolean agregarAlarma(Alarma alarma) {
		return alarmas.add(alarma);

	}

	public Boolean agregarUsuario(Usuario usuario) {
		return usuarios.add(usuario);

	}

	public Alarma getAlarma(Integer idIdentificacion) throws AlarmaNoEncontrada {

		for (Alarma alarma : alarmas) {
			if (alarma.getId().equals(idIdentificacion)) {
				return alarma;
			}
		}
		throw new AlarmaNoEncontrada();

	}

	public Usuario getUsuario(Integer dni) throws UsuarioNoEncontrado {
		for (Usuario usuario : usuarios) {
			if (usuario.getDni() == dni) {
				return usuario;
			}
		}
		throw new UsuarioNoEncontrado();
	}

}
