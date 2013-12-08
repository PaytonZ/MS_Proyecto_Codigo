package test.principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integracion.TestsIntegracionSuite;
import test.negocio.TestNegocioSuite;
import test.negocio.clientes.servicioaplicacion.imp.TestSAClientesImp;

@RunWith(Suite.class)
@SuiteClasses({ TestNegocioSuite.class , TestsIntegracionSuite.class })
public class TestAplicacion {

	// Nothing to do here
}
