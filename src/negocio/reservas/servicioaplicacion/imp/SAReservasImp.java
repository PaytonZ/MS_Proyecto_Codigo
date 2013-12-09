/**
 * 
 */
package negocio.reservas.servicioaplicacion.imp;


import negocio.excepciones.BSoDException;
import negocio.excepciones.TransaccionNoEliminadaException;
import negocio.reservas.servicioaplicacion.SAReservas;
import negocio.reservas.transfer.TransferReserva;

import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;


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
	 * @throws BSoDException 
	 * 
	 * @see SAReservas#actualizarReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarReserva(TransferReserva reserva) throws BSoDException {
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
			throw new BSoDException(e.toString());
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(SAReservas.class.getName());
			}
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAReservas#anadirReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirReserva(TransferReserva reserva) throws BSoDException {

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
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(SAReservas.class.getName());
			}
		}

		return idReserva;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAReservas#borrarReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarReserva(Integer idReserva) throws BSoDException {

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
			throw new BSoDException(e.toString());
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(SAReservas.class.getName());
			}
		}
		return resultado;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAReservas#obtenerReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva obtenerReserva(Integer idReserva) throws BSoDException 
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
			throw new BSoDException(e.toString());
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(SAReservas.class.getName());
			}
		}
		
		return reserva;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAReservas#obtenerTodaslasReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferReserva> obtenerTodaslasReservas(Integer idCliente) throws BSoDException {
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
			throw new BSoDException(e.toString());
		}
		finally
		{
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(SAReservas.class.getName());
			}
		}	
		return listaReserva;
	}
}