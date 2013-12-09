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
		correcto =  dao.updateReserva(reserva);
		if(correcto)
			transacion.commit();
		else
		{
			transacion.rollback();
		}
		tm.eliminaTransaccion();
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
		idReserva = dao.addReserva(reserva);
		if(idReserva != null)
		{
			transacion.commit();
		}
		else
		{
			transacion.rollback();
		}
		tm.eliminaTransaccion();
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
		resultado = dao.deleteReserva(idReserva);
		if(resultado)
		{
			transacion.commit();
		}
		else
		{
			transacion.rollback();
		}
		tm.eliminaTransaccion();
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
		reserva = dao.getReserva(idReserva);
		tm.eliminaTransaccion();
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
		listaReserva = dao.getAllReservas(idCliente);
		tm.eliminaTransaccion();
		return listaReserva;
	}
}