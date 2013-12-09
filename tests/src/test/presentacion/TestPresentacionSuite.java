package test.presentacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.presentacion.controlador.TestComandos;



@RunWith(Suite.class)
@SuiteClasses({ TestComandos.class})
public class TestPresentacionSuite {

}
