/**
 * 
 */
package negocio.habitaciones.servicioaplicacion.imp;

import negocio.excepciones.BSoDException;
import negocio.excepciones.TransaccionNoEliminadaException;
import negocio.habitaciones.servicioaplicacion.SAHabitaciones;
import negocio.habitaciones.transfer.TransferHabitacion;
import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.habitaciones.dao.DAOHabitacion;
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
public class SAHabitacionesImp implements SAHabitaciones {
	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAHabitaciones#anadirHabitacion(TransferHabitacionNormal
	 *      habitacionNueva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer anadirHabitacion(TransferHabitacion habitacionNueva)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		transacion.start();

		DAOHabitacion dao = FactoriaDAO.getInstance().generaDAOHabitacion();
		Integer idHabitacion = null;

		try {
			idHabitacion = dao.addHabitacion(habitacionNueva);
			transacion.commit();
		} catch (Exception e) {
			transacion.rollback();
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(
						SAHabitaciones.class.getName());
			}
		}

		return idHabitacion;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAHabitaciones#actualizarHabitacion(TransferHabitacionNormal
	 *      habitacionModificada)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean actualizarHabitacion(TransferHabitacion habitacionModificada)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOHabitacion dao = FactoriaDAO.getInstance().generaDAOHabitacion();
		transacion.start();
		Boolean correcto = false;
		try {

			correcto = dao.updateHabitacion(habitacionModificada);
			transacion.commit();
			if (!correcto) {

				transacion.rollback();

			}

		} catch (Exception e) {
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(
						SAHabitaciones.class.getName());
			}
		}
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAHabitaciones#borrarHabitacion(Integer idHabitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarHabitacion(Integer idHabitacion) throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOHabitacion dao = FactoriaDAO.getInstance().generaDAOHabitacion();
		transacion.start();
		Boolean resultado = null;
		try {
			resultado = dao.deleteHabitacion(idHabitacion);
			transacion.commit();
		} catch (Exception e) {
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(
						SAHabitaciones.class.getName());
			}
		}
		return resultado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAHabitaciones#obtenerTodaslasHabitaciones()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferHabitacion> obtenerTodaslasHabitaciones()
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOHabitacion dao = FactoriaDAO.getInstance().generaDAOHabitacion();
		transacion.start();
		List<TransferHabitacion> listaHabitaciones = null;
		try {
			listaHabitaciones = dao.getAllHabitaciones();
		} catch (Exception e) {
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {

				throw new TransaccionNoEliminadaException(
						SAHabitaciones.class.getName());
			}
		}

		return listaHabitaciones;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see SAHabitaciones#obtenerHabitacion(Integer idHabitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferHabitacion obtenerHabitacion(Integer idHabitacion)
			throws BSoDException {

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOHabitacion dao = FactoriaDAO.getInstance().generaDAOHabitacion();
		transacion.start();
		TransferHabitacion t = null;

		try {
			t = dao.getHabitacion(idHabitacion);
		} catch (Exception e) {
			throw new BSoDException(e.toString());
		} finally {
			if (!tm.eliminaTransaccion()) {
				throw new TransaccionNoEliminadaException(
						SAHabitaciones.class.getName());
			}
		}

		return t;
	}
}
