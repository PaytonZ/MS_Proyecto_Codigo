package test.negocio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integracion.dao.TestDAOCliente;
import test.negocio.clientes.servicioaplicacion.imp.TestSAClientesImp;
import test.negocio.clientes.servicioaplicacion.imp.TestSAHabitacionesImp;

@RunWith(Suite.class)
@SuiteClasses({ TestSAClientesImp.class,TestSAHabitacionesImp.class})
public class TestNegocioSuite {

}
