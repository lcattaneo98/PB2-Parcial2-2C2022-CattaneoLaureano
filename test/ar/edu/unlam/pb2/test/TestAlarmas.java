package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.pb2.Alarma;
import ar.edu.unlam.pb2.CentralAlarmas;
import ar.edu.unlam.pb2.Configurador;
import ar.edu.unlam.pb2.Usuario;

public class TestAlarmas {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		CentralAlarmas securitas = new CentralAlarmas();
//		Configurador usuario = new Configurador(41026566, "Laureano Cattaneo");
//		Accion accion = new Accion(1, usuario, "9/11/2022", TipoDeOperacion.CONFIGURACION);
//		usuario.agregarUsuario(securitas, usuario);
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		assertTrue(securitas.agregarAlarma(alarma));


	}

}
