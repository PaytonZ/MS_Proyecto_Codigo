/**
 * 
 */
package negocio.clientes.servicioaplicacion.imp;

import integracion.clientes.dao.DAOCliente;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.transfer.TransferCliente;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAClientesImp implements SAClientes {
	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#anadirCliente(TransferCliente clienteNuevo)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente anadirCliente(TransferCliente clienteNuevo) {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		Integer idCliente = null;
		try {
			idCliente = dao.addCliente(clienteNuevo);
			clienteNuevo = dao.getCliente(idCliente);
			transacion.commit();
		} catch (NullPointerException e) {
			transacion.rollback();
		} finally {
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}

		return clienteNuevo;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#obtenerTodoslosClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferCliente> obtenerTodoslosClientes() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#actualizarCliente(TransferCliente clienteActualizado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente actualizarCliente(TransferCliente clienteActualizado) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#borrarCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer borrarCliente(Integer idCliente) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#obtenerCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente obtenerCliente(Integer idCliente) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
}