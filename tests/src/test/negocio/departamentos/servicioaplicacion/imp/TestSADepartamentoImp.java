package test.negocio.departamentos.servicioaplicacion.imp;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.factorias.serviciosAplicacion.FactorySA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestSADepartamentoImp {
	
	@Test
	public void anadirClienteyObtener() {
		
		Departamento d = crearDepartamento();
		
		FactorySA.getInstance().getSADepartamentos().anadirDepartamento(d);
	}

	@Test
	public void obtenerTodoslosClientes() {
	}

	@Test
	public void actualizarCliente() {
		
	}
	@Test
	public void borrarCliente() {
	}

	private Departamento crearDepartamento() {
		
		Departamento dep = new Departamento();
		
		dep.setID(1);
		dep.setNombre("Fregoneros");
		
		return dep;
	}
}
