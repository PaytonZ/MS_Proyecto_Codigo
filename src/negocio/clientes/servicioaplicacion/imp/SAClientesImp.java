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
 * @author BSoD Software 
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
			if(clienteNuevo == null)
			{
				transacion.rollback();
				throw new BSoDException("El cliente no existe");
			}
			else if(clienteNuevo.getDNI().equals("")
					||clienteNuevo.getNombre().equals("")
					||clienteNuevo.getPrimerApellido().equals("")
					||clienteNuevo.getDireccion().equals("")) 
			{
				transacion.rollback();
				throw new BSoDException("Falta informacion necesaria del usuario");
			}
			else if(clienteNuevo.getNumTelefono()< 0)
			{
				transacion.rollback();
				throw new BSoDException("El telefono no puede ser un numero negativo");
			}
			else if((dao.getCliente(clienteNuevo.getDNI()) != null))
			{
				transacion.rollback();
				throw new BSoDException("El cliente ya existe");
			}
			else 
			{
				idCliente = dao.addCliente(clienteNuevo);
				transacion.commit();
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
			if(clienteActualizado == null)
			{
				transacion.rollback();
				throw new BSoDException("El cliente no existe");
			}
			else if(clienteActualizado.getDNI().equals("")
					||clienteActualizado.getNombre().equals("")
					||clienteActualizado.getPrimerApellido().equals("")
					||clienteActualizado.getDireccion().equals("")) 
			{
				transacion.rollback();
				throw new BSoDException("Falta informacion necesaria del usuario");
			}
			else if(clienteActualizado.getNumTelefono()< 0)
			{
				transacion.rollback();
				throw new BSoDException("El telefono no puede ser un numero negativo");
			}
			else
			{
				correcto =  dao.updateCliente(clienteActualizado);
				transacion.commit();
			}
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
		{		
			if(dao.getClienteByID(idCliente) == null)
			{
				throw new BSoDException("El cliente no existe");
			}
			List<TransferReserva> l = FactoriaDAO.getInstance().generaDAOReserva().getAllReservasporCliente(idCliente);
			if(l.isEmpty()) //Si el cliente no tiene reservas activas , se puede dar de baja.
			{
				resultado = dao.deleteCliente(idCliente);
				transacion.commit();
			}
			else
			{
				resultado=false;
				transacion.rollback();
				throw new BSoDException("El cliente tiene reservasm, no se puede borrar");
			
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
	
	public TransferCliente obtenerClienteByID(Integer idCliente) throws BSoDException {
		
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		TransferCliente t = null;
		transacion.start();
		try
		{
				t = dao.getClienteByID(idCliente);
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
