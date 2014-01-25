package presentacion.comandos.empleado.redireccion;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandRConsultarDepartamentosVModificarEmpleado implements
	Command {

    @Override
    public CommandResponse execute(Object datos) {

	Command command = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTO);

	CommandResponse cr = command.execute(datos);
	
	if ( cr.getEvento().equals(IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTO) ) {
		
		cr.setEvento(IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO);
	}
	else {
		
		cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO);
	}
	
	return cr;
}

}
