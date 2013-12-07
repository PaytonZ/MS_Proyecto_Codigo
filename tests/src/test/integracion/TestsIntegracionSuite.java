package test.integracion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integracion.dao.TestDAOCliente;
import test.integracion.dao.TestDAOHabitaciones;
import test.integracion.dao.TestDAOReservas;

@RunWith(Suite.class)
@SuiteClasses({ TestDAOCliente.class , TestDAOReservas.class  , TestDAOHabitaciones.class })

public class TestsIntegracionSuite {

}
