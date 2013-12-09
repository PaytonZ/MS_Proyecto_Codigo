package test.presentacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.presentacion.controlador.comandos.TestComandosClientes;
import test.presentacion.controlador.comandos.TestComandosHabitaciones;



@RunWith(Suite.class)
@SuiteClasses({ TestComandosClientes.class, TestComandosHabitaciones.class})
public class TestPresentacionSuite {

}
