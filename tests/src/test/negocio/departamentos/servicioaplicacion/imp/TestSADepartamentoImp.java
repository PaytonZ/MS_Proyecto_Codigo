package test.negocio.departamentos.servicioaplicacion.imp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.departamentos.servicioaplicacion.SADepartamentos;
import negocio.departamentos.servicioaplicacion.imp.SADepartamentosImp;
import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.empleados.servicioaplicacion.imp.SAempleadosImp;
import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import negocio.tareas.objetonegocio.Tarea;
import negocio.tareas.servicioaplicacion.SATareas;
import negocio.tareas.servicioaplicacion.imp.SATareasImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSADepartamentoImp {
	
@Test
public void altaYbaja() {

	SADepartamentos sadepartamento = new SADepartamentosImp();
	Departamento d = new Departamento();


	d.setNombre("asdasd");

	Departamento d1 = null;
	try {
	    d1 = sadepartamento.anadirDepartamento(d);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

	assertNotNull(d1);
	assertTrue(d1.getID() >= 0);
	assertTrue(d.getNombre().equalsIgnoreCase(d1.getNombre()));

//	try {
//	    assertTrue(sadepartamento.borrarDepartamento(d.getNombre()));
//	} catch (BSoDException e2) {
//	    // TODO Auto-generated catch block
//	    e2.printStackTrace();
//	}
//	try {
//	    assertFalse(sadepartamento.borrarDepartamento(String.valueOf(new Random()
//		    .nextInt(99999))));
//	} catch (BSoDException e2) {
//	    // TODO Auto-generated catch block
//	}

   } 
  @Test
   public void altaYConsulta() {

	SADepartamentos sadepartamento = new SADepartamentosImp();
	Departamento d = new Departamento();


	d.setNombre("asdasd");

	Departamento d1 = null;
	try {
	    d1 = sadepartamento.anadirDepartamento(d);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

	assertNotNull(d1);
	assertTrue(d1.getID() >= 0);
	assertTrue(d.getNombre().equalsIgnoreCase(d1.getNombre()));

	try {
	    d1 = sadepartamento.obternerDepartamento(d.getNombre());
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	assertTrue(d1.getID() >= 0);
	assertTrue(d.getNombre().equalsIgnoreCase(d1.getNombre()));


   }
}
