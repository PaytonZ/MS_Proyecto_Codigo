package test.negocio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.negocio.clientes.servicioaplicacion.imp.TestSAClientesImp;
import test.negocio.empleados.servicioaplicacion.imp.TestSAEmpleadosImp;
import test.negocio.habitaciones.servicioaplicacion.imp.TestSAHabitacionesImp;
import test.negocio.jpa.TestJPAEmpleado;
import test.negocio.reservas.servicioaplicacion.imp.TestSAReservasimp;

@RunWith(Suite.class)
@SuiteClasses({ TestSAClientesImp.class, TestSAHabitacionesImp.class, TestSAReservasimp.class , TestJPAEmpleado.class , TestSAEmpleadosImp.class})
public class TestNegocioSuite {

	// Nothing to do here
}
