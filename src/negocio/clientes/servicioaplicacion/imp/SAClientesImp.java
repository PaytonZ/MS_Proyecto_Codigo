/**
 * 
 */
package negocio.clientes.servicioaplicacion.imp;

import integracion.clientes.dao.DAOCliente;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.List;

import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.excepciones.TransaccionNoEliminadaException;
import negocio.reservas.transfer.TransferReserva;

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
	 * @throws BSoDException 
	 * 
	 * @see SAClientes#anadirCliente(TransferCliente clienteNuevo)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirCliente(TransferCliente clienteNuevo) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		
		
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		Integer idCliente = null;
		
		try {
			if( clienteNuevo != null &&
				!clienteNuevo.getDNI().equals("") &&
				!clienteNuevo.getNombre().equals("") &&
				!clienteNuevo.getPrimerApellido().equals("") &&
				!clienteNuevo.getDireccion().equals("") &&
				clienteNuevo.getNumTelefono() >-1){
				
			
					idCliente = dao.addCliente(clienteNuevo);
					transacion.commit();
					
			}
			else {
				
				idCliente = null;
				transacion.rollback();
			}
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
			
		} finally {
			tm.eliminaTransaccion();
		}

		return idCliente;
	}

	/**
	 * (sin Javadoc)
	 * @throws TransaccionNoEliminadaException 
	 * 
	 * @see SAClientes#obtenerTodoslosClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferCliente> obtenerTodoslosClientes() throws BSoDException {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		
		transacion.start();
		
		List<TransferCliente> listaClientes = null;
		
		try {
			listaClientes = dao.getAllClientes();
		}
		catch(BSoDException e) {
			throw e;
		}
		finally {
			tm.eliminaTransaccion();
		}	
		return listaClientes;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAClientes#actualizarCliente(TransferCliente clienteActualizado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarCliente(TransferCliente clienteActualizado) throws BSoDException {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		
		transacion.start();
		
		Boolean correcto = false;
		
		try {
			correcto =  dao.updateCliente(clienteActualizado);
			transacion.commit();
		}
		catch(BSoDException e ) {
			transacion.rollback();
			throw e;
		}
		finally {
			tm.eliminaTransaccion();
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAClientes#borrarCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarCliente(Integer idCliente) throws BSoDException {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		transacion.start();
		Boolean resultado = null;
		try
		{		List<TransferReserva> l = FactoriaDAO.getInstance().generaDAOReserva().getAllReservas(idCliente);
				if(l.isEmpty()) //Si el cliente no tiene reservas activas , se puede dar de baja.
				{
					resultado = dao.deleteCliente(idCliente);
					transacion.commit();
				}
				else
				{
					resultado=false;
					transacion.rollback();
				}
				
		}
		catch(BSoDException e)
		{
			transacion.rollback();
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}
		return resultado;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * @throws TransaccionNoEliminadaException 
	 * 
	 * @see SAClientes#obtenerCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente obtenerCliente(String dniCliente) throws BSoDException {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		TransferCliente t = null;
		transacion.start();
		try
		{
				t = dao.getCliente(dniCliente);
		}catch(BSoDException e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}
		
		return t;
	}
}
