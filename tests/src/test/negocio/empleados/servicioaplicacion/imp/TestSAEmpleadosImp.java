package test.negocio.empleados.servicioaplicacion.imp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.empleados.servicioaplicacion.imp.SAempleadosImp;
import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;
import negocio.tareas.servicioaplicacion.SATareas;
import negocio.tareas.servicioaplicacion.imp.SATareasImp;

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
	}

    }

    @Test
    public void altaYConsulta() {

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
	    e1 = saempleados.obtenerEmpleado(e.getDNI());
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	assertTrue(e1.getId() >= 0);
	assertTrue(e.getDNI().equalsIgnoreCase(e1.getDNI()));

	assertTrue(e.getPrimerApellido().equalsIgnoreCase(
		e1.getPrimerApellido()));
	assertTrue(e.getSegundoApellido().equalsIgnoreCase(
		e1.getSegundoApellido()));

    }

    @Test
    public void anadirandObtenerTarea() {

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

	Tarea t = new Tarea();
	t.setDescripcion("asdasd");
	t.setNombre(String.valueOf(new Random().nextInt(99999)));

	SATareas satareas = new SATareasImp();
	Tarea t1 = null;
	try {
	    t1 = satareas.anadirTarea(t);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

	assertNotNull(t1);
	assertTrue(t.getDescripcion().equalsIgnoreCase((t1.getDescripcion())));
	assertTrue(t.getNombre().equalsIgnoreCase(t1.getNombre()));
	List<Tarea> l = new ArrayList<>();

	l.add(t1);

	Boolean b = null;
	try {
	    b = saempleados.anadirTareaEmpleado(e.getDNI(), l);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	assertTrue(b);

	List<Empleado> j = null;
	try {
	    j = saempleados.obtenerEmpleadosporTareas(t1);
	} catch (BSoDException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}

	assertNotNull(j);

	assertTrue(j.get(0).equals(e1));

    }
}
