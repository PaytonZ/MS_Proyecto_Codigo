/**
 * 
 */
package presentacion.comandos.commandFactory.imp;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.cliente.CommandAltaCliente;
import presentacion.comandos.cliente.CommandBajaCliente;
import presentacion.comandos.cliente.CommandConsultaCliente;
import presentacion.comandos.cliente.CommandConsultaClienteVentanaBorrar;
import presentacion.comandos.cliente.CommandConsultaClienteVentanaModificar;
import presentacion.comandos.cliente.CommandConsultaTodosClientes;
import presentacion.comandos.cliente.CommandModificarCliente;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.departamento.CommandAltaDepartamento;
import presentacion.comandos.departamento.CommandBajaDepartamento;
import presentacion.comandos.departamento.CommandConsultaDepartamento;
import presentacion.comandos.departamento.CommandConsultaTodosDepartamentos;
import presentacion.comandos.departamento.CommandModificarDepartamento;
import presentacion.comandos.departamento.redireccion.CommandRConsultarDepartamentoVBorrar;
import presentacion.comandos.departamento.redireccion.CommandRConsultarDepartamentoVModificar;
import presentacion.comandos.empleado.CommandAltaEmpleado;
import presentacion.comandos.empleado.CommandBajaEmpleado;
import presentacion.comandos.empleado.CommandConsultaEmpleado;
import presentacion.comandos.empleado.CommandConsultaEmpleadoPorTarea;
import presentacion.comandos.empleado.CommandConsultaTodosEmpleados;
import presentacion.comandos.empleado.CommandModificarEmpleado;
import presentacion.comandos.empleado.redireccion.CommandRConsultarDepartamentosVAltaEmpleado;
import presentacion.comandos.empleado.redireccion.CommandRConsultarDepartamentosVModificarEmpleado;
import presentacion.comandos.empleado.redireccion.CommandRConsultarEmpleadoVAsignarTarea;
import presentacion.comandos.empleado.redireccion.CommandRConsultarEmpleadosVBorrar;
import presentacion.comandos.empleado.redireccion.CommandRConsultarEmpleadosVModificar;
import presentacion.comandos.empleado.redireccion.CommandRConsultarTareasVAsignarTarea;
import presentacion.comandos.empleado.redireccion.CommandRConsultarTareasVConsultarEmpleadosPorTarea;
import presentacion.comandos.habitacion.CommandAltaHabitacion;
import presentacion.comandos.habitacion.CommandBajaHabitacion;
import presentacion.comandos.habitacion.CommandConsultaHabitacion;
import presentacion.comandos.habitacion.CommandConsultaHabitacionVentanaAlta;
import presentacion.comandos.habitacion.CommandConsultaHabitacionVentanaBaja;
import presentacion.comandos.habitacion.CommandConsultaHabitacionVentanaModificar;
import presentacion.comandos.habitacion.CommandConsultaTodasHabitaciones;
import presentacion.comandos.habitacion.CommandModificarHabitacion;
import presentacion.comandos.reserva.CommandAltaReserva;
import presentacion.comandos.reserva.CommandBajaReserva;
import presentacion.comandos.reserva.CommandConsultaClienteVentanaBorrarReserva;
import presentacion.comandos.reserva.CommandConsultaReserva;
import presentacion.comandos.reserva.CommandConsultaReservaVentanaBorrarReserva;
import presentacion.comandos.reserva.CommandConsultaTodasReservas;
import presentacion.comandos.reserva.CommandConsultaTodasReservasPorCliente;
import presentacion.comandos.reserva.CommandConsultarClienteReserva;
import presentacion.comandos.reserva.CommandConsultarReservaModificar;
import presentacion.comandos.reserva.CommandModificarReserva;
import presentacion.comandos.tarea.CommandAltaTarea;
import presentacion.comandos.tarea.CommandBajaTarea;
import presentacion.comandos.tarea.CommandConsultaTarea;
import presentacion.comandos.tarea.CommandConsultaTodasTareas;
import presentacion.comandos.tarea.CommandModificarTarea;
import presentacion.comandos.tarea.redireccion.CommandRConsultarTareasVBorrar;
import presentacion.comandos.tarea.redireccion.CommandRConsultarTareasVModificar;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {
    /**
     * (sin Javadoc)
     * 
     * @see CommandFactory#nuevoComando(Integer id_comando)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Command nuevoComando(IDEventos id_comando) {

	Command c = null;

	switch (id_comando) {
	/* CLIENTES */
	case EVENTO_ALTA_CLIENTE:
	    c = new CommandAltaCliente();
	    break;

	case EVENTO_BAJA_CLIENTE:
	    c = new CommandBajaCliente();
	    break;

	case EVENTO_MODIFICAR_CLIENTE:
	    c = new CommandModificarCliente();
	    break;

	case EVENTO_CONSULTAR_CLIENTE:
	    c = new CommandConsultaCliente();
	    break;

	case EVENTO_CONSULTAR_TODOS_CLIENTE:
	    c = new CommandConsultaTodosClientes();
	    break;
	case EVENTO_CONSULTAR_CLIENTE_V_BORRAR:
	    c = new CommandConsultaClienteVentanaBorrar();
	    break;
	case EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR:
	    c = new CommandConsultaClienteVentanaModificar();
	    break;

	/* RESERVAS */

	case EVENTO_ALTA_RESERVA:
	    c = new CommandAltaReserva();
	    break;
	case EVENTO_BAJA_RESERVA:
	    c = new CommandBajaReserva();
	    break;
	case EVENTO_MODIFICAR_RESERVA:
	    c = new CommandModificarReserva();
	    break;
	case EVENTO_CONSULTAR_RESERVA:
	    c = new CommandConsultaReserva();
	    break;
	case EVENTO_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE:
	    c = new CommandConsultaTodasReservasPorCliente();
	    break;
	case EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS:
	    c = new CommandConsultarClienteReserva();
	    break;
	case EVENTO_CONSULTAR_TODAS_RESERVAS:
	    c = new CommandConsultaTodasReservas();
	    break;
	case EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS:
	    c = new CommandConsultarReservaModificar();
	    break;
	case EVENTO_CONSULTAR_RESERVA_V_BORRAR_RESERVAS:
	    c = new CommandConsultaReservaVentanaBorrarReserva();
	    break;
	case EVENTO_CONSULTAR_CLIENTE_V_BORRAR_RESERVAS:
	    c = new CommandConsultaClienteVentanaBorrarReserva();
	    break;

	/* HABITACIONES */

	case EVENTO_ALTA_HABITACION:
	    c = new CommandAltaHabitacion();
	    break;
	case EVENTO_CONSULTAR_HABITACION:
	    c = new CommandConsultaHabitacion();
	    break;
	case EVENTO_BAJA_HABITACION:
	    c = new CommandBajaHabitacion();
	    break;
	case EVENTO_MODIFICAR_HABITACION:
	    c = new CommandModificarHabitacion();
	    break;
	case EVENTO_CONSULTAR_TODAS_HABITACION:
	    c = new CommandConsultaTodasHabitaciones();
	    break;
	case EVENTO_CONSULTAR_HABITACION_V_ALTA:
	    c = new CommandConsultaHabitacionVentanaAlta();
	    break;
	case EVENTO_CONSULTAR_HABITACION_V_BAJA:
	    c = new CommandConsultaHabitacionVentanaBaja();
	    break;
	case EVENTO_CONSULTAR_HABITACION_V_MODIFICAR:
	    c = new CommandConsultaHabitacionVentanaModificar();
	    break;

	/* DEPARTAMENTOS */

	case EVENTO_ALTA_DEPARTAMENTO:
	    c = new CommandAltaDepartamento();
	    break;
	case EVENTO_BAJA_DEPARTAMENTO:
	    c = new CommandBajaDepartamento();
	    break;
	case EVENTO_MODIFICAR_DEPARTAMENTO:
	    c = new CommandModificarDepartamento();
	    break;
	case EVENTO_CONSULTAR_DEPARTAMENTO:
	    c = new CommandConsultaDepartamento();
	    break;
	case EVENTO_CONSULTAR_TODOS_DEPARTAMENTO:
	    c = new CommandConsultaTodosDepartamentos();
	    break;
	case EVENTO_CONSULTAR_DEPARTAMENTO_V_BORRAR:
	    c = new CommandRConsultarDepartamentoVBorrar();
	    break;
	case EVENTO_CONSULTAR_DEPARTAMENTO_V_MODIFICAR:
	    c = new CommandRConsultarDepartamentoVModificar();
	    break;

	/* EMPLEADOS */

	case EVENTO_ALTA_EMPLEADO:
	    c = new CommandAltaEmpleado();
	    break;
	case EVENTO_CONSULTAR_EMPLEADO:
	    c = new CommandConsultaEmpleado();
	    break;
	case EVENTO_BAJA_EMPLEADO:
	    c = new CommandBajaEmpleado();
	    break;
	case EVENTO_MODIFICAR_EMPLEADO:
	    c = new CommandModificarEmpleado();
	    break;
	case EVENTO_CONSULTAR_TODOS_EMPLEADOS:
	    c = new CommandConsultaTodosEmpleados();
	    break;
	case EVENTO_CONSULTAR_TAREAS_V_ASIGARTAREA:
	    c = new CommandRConsultarTareasVAsignarTarea();
	    break;
	case EVENTO_CONSULTAR_EMPLEADO_V_ASIGARTAREA:
	    c = new CommandRConsultarEmpleadoVAsignarTarea();
	    break;
	case EVENTO_CONSULTAR_EMPLEADOS_V_BORRAR:
	    c = new CommandRConsultarEmpleadosVBorrar();
	    break;
	case EVENTO_CONSULTAR_EMPLEADOS_V_MODIFICAR:
	    c = new CommandRConsultarEmpleadosVModificar();
	    break;
	case EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO:
	    c = new CommandRConsultarDepartamentosVAltaEmpleado();
	    break;
	case EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO:
	    c = new CommandRConsultarDepartamentosVModificarEmpleado();
	    break;
	case EVENTO_CONSULTAR_EMPLEADO_POR_TAREA:
	    c = new CommandConsultaEmpleadoPorTarea();
	    break;
	case EVENTO_CONSULTAR_TAREA_V_CONSULTAR_EMPLEADOS_POR_TAREA:
	    c = new CommandRConsultarTareasVConsultarEmpleadosPorTarea();
	    break;

	/* TAREAS */

	case EVENTO_ALTA_TAREA:
	    c = new CommandAltaTarea();
	    break;
	case EVENTO_BAJA_TAREA:
	    c = new CommandBajaTarea();
	    break;
	case EVENTO_MODIFICAR_TAREA:
	    c = new CommandModificarTarea();
	    break;
	case EVENTO_CONSULTAR_TAREA:
	    c = new CommandConsultaTarea();
	    break;
	case EVENTO_CONSULTAR_TODAS_TAREAS:
	    c = new CommandConsultaTodasTareas();
	    break;
	case EVENTO_CONSULTAR_TAREAS_V_BORRAR:
	    c = new CommandRConsultarTareasVBorrar();
	    break;
	case EVENTO_CONSULTAR_TAREAS_V_MODIFICAR:
	    c = new CommandRConsultarTareasVModificar();
	    break;

	default:
	    break;

	}

	return c;

    }
}