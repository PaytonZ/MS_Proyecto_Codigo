package test.negocio.empleados.servicioaplicacion.imp;

import java.util.Random;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.empleados.servicioaplicacion.imp.SAempleadosImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSAEmpleadosImp {
	@Test
	public void addEmpleados() {

		SAEmpleados saempleados = new SAempleadosImp();
		Empleado e = new Empleado();

		e.setDNI(String.valueOf(new Random().nextInt(99999)));
		e.setNombre("asdasd");
		e.setPrimerApellido("asdasd");
		e.setSegundoApellido("asdasd");

		saempleados.anadirEmpleado(e);
	}

}
