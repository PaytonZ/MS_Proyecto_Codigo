/**
 * 
 */
package negocio.reservas.servicioaplicacion.imp;

import negocio.clientes.transfer.TransferCliente;
import negocio.reservas.servicioaplicacion.SAReservas;
import negocio.reservas.transfer.TransferReserva;
import integracion.clientes.dao.DAOCliente;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAReservasImp implements SAReservas {
	/**
	 * (sin Javadoc)
	 * 
	 * @see SAReservas#actualizarReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarReserva(TransferReserva reserva) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		transacion.start();
		Boolean correcto = false;
		try
		{
			
			correcto =  dao.updateReserva(reserva);
			transacion.commit();
			if(!correcto)
			{
				
				transacion.rollback();
				
			}
			
		}
		catch(Exception e)
		{
			//tratar
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAReservas#anadirReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirReserva(TransferReserva reserva) {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		Integer idReserva = null;
		
		try {
			idReserva = dao.addReserva(reserva);
			transacion.commit();
		} catch (Exception e) {
			transacion.rollback();
		} finally {
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}

		return idReserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAReservas#borrarReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarReserva(Integer idReserva) {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		transacion.start();
		Boolean resultado = null;
		try
		{
				resultado = dao.deleteReserva(idReserva);
				transacion.commit();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		return resultado;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAReservas#obtenerReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva obtenerReserva(Integer idReserva) 
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		TransferReserva reserva = null;
		transacion.start();
		try
		{
				reserva = dao.getReserva(idReserva);
		}catch(Exception e)
		{
			
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}
		
		return reserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAReservas#obtenerTodaslasReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferReserva> obtenerTodaslasReservas(Integer idCliente) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		transacion.start();
		List<TransferReserva> listaReserva = null;
		try
		{
			listaReserva = dao.getAllReservas(idCliente);
		}
		catch(Exception e)
		{
			//
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				// ERROR
			}
		}	
		return listaReserva;
	}
}