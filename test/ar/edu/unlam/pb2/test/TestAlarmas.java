package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import ar.edu.unlam.exceptions.AlarmaNoEncontrada;
import ar.edu.unlam.exceptions.CodigoActivacionIrreconocible;
import ar.edu.unlam.exceptions.CodigoAlarmaIncorrectoException;
import ar.edu.unlam.exceptions.SensorDuplicadoException;
import ar.edu.unlam.exceptions.UsuarioNoEncontrado;
import ar.edu.unlam.pb2.Accion;
import ar.edu.unlam.pb2.Administrador;
import ar.edu.unlam.pb2.Alarma;
import ar.edu.unlam.pb2.CentralAlarmas;
import ar.edu.unlam.pb2.Configurador;
import ar.edu.unlam.pb2.Sensor;
import ar.edu.unlam.pb2.Usuario;
import ar.edu.unlam.pb2.enumeradores.TipoDeOperacion;

public class TestAlarmas {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");

		assertTrue(securitas.agregarAlarma(alarma));

	}

	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma()
			throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException {
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		securitas.agregarAlarma(alarma);
		Configurador configurador = new Configurador(41026566, "Pancho Cerro");
		securitas.agregarUsuario(configurador);
		alarma.agregarAccion(1, alarma, configurador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);

		assertEquals((Integer) 1, (Integer) alarma.getAccionesRealizadas().size());
		assertTrue(configurador.agregarUnUsuarioALaListaDeUsuariosValidos(securitas, configurador.getDni(),
				alarma.getId(), alarma.getCodigoDeConfiguracion()));

	}

	@Test(expected = CodigoAlarmaIncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmalnvalidoSeLanceCodigoAlarmalncorrectoException()
			throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException {
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		securitas.agregarAlarma(alarma);
		Configurador configurador = new Configurador(41026566, "Pancho Cerro");
		securitas.agregarUsuario(configurador);
		alarma.agregarAccion(1, alarma, configurador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		configurador.agregarUnUsuarioALaListaDeUsuariosValidos(securitas, configurador.getDni(), alarma.getId(), 5555);
	}

	@Test(expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException()
			throws AlarmaNoEncontrada, SensorDuplicadoException {
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		securitas.agregarAlarma(alarma);
		Sensor sensor = new Sensor(1, false);
		Sensor sensor1 = new Sensor(1, false);
		Sensor sensor2 = new Sensor(2, false);
		Configurador configurador = new Configurador(41026566, "Pancho Cerro");
		securitas.agregarUsuario(configurador);
		alarma.agregarAccion(1, alarma, configurador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		configurador.agregarSensorAAlarma(securitas, alarma.getId(), alarma.getCodigoDeConfiguracion(), sensor,
				configurador.getDni());
		configurador.agregarSensorAAlarma(securitas, alarma.getId(), alarma.getCodigoDeConfiguracion(), sensor1,
				configurador.getDni());

	}

	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado()
			throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException, SensorDuplicadoException,
			CodigoActivacionIrreconocible {
		Administrador administrador = new Administrador(41026566, "Pancho Cerro");
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		securitas.agregarUsuario(administrador);
		administrador.agregarAlarma(securitas, alarma);

		administrador.agregarUnUsuarioALaListaDeUsuariosValidos(securitas, administrador.getDni(), alarma.getId(),
				alarma.getCodigoDeConfiguracion());

		alarma.agregarAccion(1, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		Sensor sensor = new Sensor(1, true);
		administrador.agregarSensorAAlarma(securitas, 1, 3333, sensor, administrador.getDni());
		Sensor sensor1 = new Sensor(26, true);
		administrador.agregarSensorAAlarma(securitas, 1, 3333, sensor1, administrador.getDni());

		administrador.activarDesactivarAlarma(securitas, securitas.getAlarma(1), 2222);

		Boolean esperado = true;
		Boolean obtenido = alarma.getEstado();

		assertEquals(esperado, obtenido);
	}

	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAcccionesDeTipoConfiguracionOdenadasPorldDeAccion()
			throws AlarmaNoEncontrada, UsuarioNoEncontrado, CodigoAlarmaIncorrectoException {
		Administrador administrador = new Administrador(41026566, "Pancho Cerro");
		CentralAlarmas securitas = new CentralAlarmas();
		Alarma alarma = new Alarma(1, 2222, 3333, "ProteccionTotal2000");
		securitas.agregarUsuario(administrador);
		administrador.agregarAlarma(securitas, alarma);
		administrador.agregarUnUsuarioALaListaDeUsuariosValidos(securitas, administrador.getDni(), alarma.getId(),
				alarma.getCodigoDeConfiguracion());
		alarma.agregarAccion(1, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(50, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(3000, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		alarma.agregarAccion(8, alarma, administrador, LocalDate.of(2022, 11, 9), TipoDeOperacion.CONFIGURACION);
		

		for (Accion accion : alarma.getAccionesOrdenadasPorId()) {
			System.out.println(accion.toString());

		}
	}
}
