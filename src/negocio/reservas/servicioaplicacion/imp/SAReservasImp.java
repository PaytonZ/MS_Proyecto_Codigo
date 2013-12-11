/**
 * 
 */
package negocio.reservas.servicioaplicacion.imp;

import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.List;

import negocio.excepciones.BSoDException;
import negocio.reservas.servicioaplicacion.SAReservas;
import negocio.reservas.transfer.TransferReserva;

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
	 * @throws BSoDException
	 * 
	 * @see SAReservas#actualizarReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarReserva(TransferReserva reserva)
			throws BSoDException {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();
		transacion.start();
		Boolean correcto = false;
		try {
			correcto = dao.updateReserva(reserva);
			transacion.commit();
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
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
			List<TransferReserva> listareservasporhabitacion = dao.getReservasporHabitacion(reserva.getNumeroHabitacion());
			if(!listareservasporhabitacion.isEmpty())
			{
				Date diaentradanuevareserva =(Date) reserva.getFechaEntrada();
				Date diasalidanuevareserva = (Date) reserva.getFechaReserva();
				for(TransferReserva reservaporhabitacion : listareservasporhabitacion)
				{
					Date diaentrada = (Date) reservaporhabitacion.getFechaEntrada();
					Date diasalida = (Date) reservaporhabitacion.getFechaSalida();
				
					if((diaentrada.after(diaentradanuevareserva) && diasalida.before(diaentradanuevareserva)))
							{
						
						
							}
						
						
						
					
					
					
					
					
					
				}
			}
			
			idReserva = dao.addReserva(reserva);
			transacion.commit();
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}

		return idReserva;
	}

	/**
	 * (sin Javadoc)
	 * 
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
		try {

			resultado = dao.deleteReserva(idReserva);
			transacion.commit();
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return resultado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#obtenerReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva obtenerReserva(Integer idReserva)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		TransferReserva reserva = null;

		transacion.start();
		try {
			reserva = dao.getReserva(idReserva);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}

		return reserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAReservas#obtenerTodaslasReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferReserva> obtenerTodaslasReservas(Integer idCliente)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();

		List<TransferReserva> listaReserva = null;
		try {
			listaReserva = dao.getAllReservas(idCliente);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return listaReserva;
	}

	@Override
	public List<TransferReserva> obtenerReservasporHabitacion(
			Integer numhabitacion) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();

		DAOReserva dao = FactoriaDAO.getInstance().generaDAOReserva();

		transacion.start();

		List<TransferReserva> listaReserva = null;
		try {
			listaReserva = dao.getReservasporHabitacion(numhabitacion);
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}
		return listaReserva;

	}
}