package test.principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.integracion.TestsIntegracionSuite;
import test.negocio.TestNegocioSuite;
import test.presentacion.TestPresentacionSuite;

@RunWith(Suite.class)
@SuiteClasses({ TestNegocioSuite.class , TestsIntegracionSuite.class  , TestPresentacionSuite.class})
public class TestAplicacion {

	// Nothing to do here
}
