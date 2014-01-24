package test.negocio.empleados.servicioaplicacion.imp;

import static org.junit.Assert.*;

import java.util.Random;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.empleados.servicioaplicacion.imp.SAempleadosImp;
import negocio.excepciones.BSoDException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSAEmpleadosImp {
    @Test
    public void altaYbaja() {

	SAEmpleados saempleados = new SAempleadosImp();
	Empleado e = new Empleado();

	e.setDNI(String.valueOf(new Random().nextInt(99999)));
	e.setNombre("asdasd");
	e.setPrimerApellido("asdasd");
	e.setSegundoApellido("asdasd");

	Empleado e1 = null;
	try {
	    e1 = saempleados.anadirEmpleado(e);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

	assertNotNull(e1);
	assertTrue(e1.getId() >= 0);
	assertTrue(e.getDNI().equalsIgnoreCase(e1.getDNI()));

	assertTrue(e.getPrimerApellido().equalsIgnoreCase(
		e1.getPrimerApellido()));
	assertTrue(e.getSegundoApellido().equalsIgnoreCase(
		e1.getSegundoApellido()));

	try {
	    assertTrue(saempleados.borrarEmpleado(e.getDNI()));
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	try {
	    assertFalse(saempleados.borrarEmpleado(String.valueOf(new Random()
	    	.nextInt(99999))));
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

    }

}
