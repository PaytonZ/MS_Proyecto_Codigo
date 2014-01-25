package test.negocio.tareas.servicioaplicacion.imp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;
import negocio.tareas.servicioaplicacion.SATareas;
import negocio.tareas.servicioaplicacion.imp.SATareasImp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSATareasimp {
    @Test
    public void addTarea() {

	SATareas satareas = new SATareasImp();
	
	Tarea t = new Tarea();
	t.setDescripcion("asdasd");
	t.setNombre(String.valueOf(new Random().nextInt(99999)));

	Tarea t1= null;
	try {
	  t1=  satareas.anadirTarea(t);
	} catch (BSoDException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	assertNotNull(t1);
	assertTrue(t.getDescripcion().equalsIgnoreCase((t1.getDescripcion())));
	assertTrue(t.getNombre().equalsIgnoreCase(t1.getNombre()));
	assertTrue(t1.getId() >  0 );
	
    }

}
