package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class CentralAlarmas {

	List <Alarma> alarmas;
	List <Usuario> usuariosValidos;
	
	public CentralAlarmas() {
		this.alarmas = new ArrayList();
		this.usuariosValidos = new ArrayList();
	}
	public boolean agregarAlarma(Alarma alarma) {
		alarmas.add(alarma);
		return true;
		
		
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuariosValidos.add(usuario);
		
	}

}
