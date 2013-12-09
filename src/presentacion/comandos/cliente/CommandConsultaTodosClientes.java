/**
 * 
 */
package presentacion.comandos.cliente;

import java.util.List;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandConsultaTodosClientes implements Command {
	/**
	 * (sin Javadoc)
	 * 
	 * @see Command#execute(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public CommandResponse execute(Object datos) {
		
			
		CommandResponse cr = new CommandResponse();
		try {
				
			cr.setDatos(FactorySA.getInstance().getSAClientes().obtenerTodoslosClientes());;
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE);
			
		} catch (BSoDException bsod) {
			
			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_TODOS_CLIENTE);
		}
		
		return cr;
	}
}