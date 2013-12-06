package test.integracion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integracion.dao.TestDAOCliente;

@RunWith(Suite.class)
@SuiteClasses({ TestDAOCliente.class })
public class TestsIntegracionSuite {

}
