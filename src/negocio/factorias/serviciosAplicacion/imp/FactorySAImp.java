/**
 * 
 */
package negocio.factorias.serviciosAplicacion.imp;

import negocio.factorias.serviciosAplicacion.FactorySA;
import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.servicioaplicacion.imp.SAClientesImp;
import negocio.reservas.servicioaplicacion.SAReservas;
import negocio.reservas.servicioaplicacion.imp.SAReservasImp;
import negocio.departamentos.servicioaplicacion.SADepartamentos;
import negocio.departamentos.servicioaplicacion.imp.SADepartamentosImp;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.empleados.servicioaplicacion.imp.SAempleadosImp;
import negocio.tareas.servicioaplicacion.SATareas;
import negocio.tareas.servicioaplicacion.imp.SATareasImp;
import negocio.habitaciones.servicioaplicacion.SAHabitaciones;
import negocio.habitaciones.servicioaplicacion.imp.SAHabitacionesImp;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactorySAImp extends FactorySA {
	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSAClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAClientes getSAClientes() {

		return new SAClientesImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSAReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAReservas getSAReservas() {

		return new SAReservasImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSADepartamentos()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SADepartamentos getSADepartamentos() {

		return new SADepartamentosImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSAEmpleados()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAEmpleados getSAEmpleados() {

		return new SAempleadosImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSATareas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SATareas getSATareas() {

		return new SATareasImp();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see FactorySA#getSAHabitaciones()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAHabitaciones getSAHabitaciones() {

		return new SAHabitacionesImp();
	}
}