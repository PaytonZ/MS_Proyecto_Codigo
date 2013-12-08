/**
 * 
 */
package presentacion.comandos.cliente;

import java.util.List;

import excepciones.BSoDException;
import negocio.clientes.transfer.TransferCliente;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
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
		
		FactorySA factoriaSa = FactorySA.getInstance();
		
		List<TransferCliente> lista = null;
		CommandResponse cr = new CommandResponse();
		try {
			lista = factoriaSa.getSAClientes().obtenerTodoslosClientes();
			
			cr.setDatos(lista);
//			cr.setEvento();
			
		} catch (BSoDException bsod) {
			
			cr.setDatos(bsod);
		}
		
		return cr;
	}
}