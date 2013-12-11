/**
 * 
 */
package negocio.habitaciones.servicioaplicacion.imp;

import integracion.factorias.factoriaDAO.FactoriaDAO;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.List;

import negocio.excepciones.BSoDException;
import negocio.habitaciones.servicioaplicacion.SAHabitaciones;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
import negocio.reservas.transfer.TransferReserva;

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
			if(habitacionNueva == null){
				transacion.rollback();
				throw new BSoDException("La habitacion no existe");
			}
			else if(habitacionNueva.getNumHabitacion() <0 
					|| habitacionNueva.getPrecio() < 0d){
				
				transacion.rollback();
				throw new BSoDException("Faltan daots necesarios");
							
			}
			else if(dao.getHabitacion(habitacionNueva.getNumHabitacion()) != null){
					
				transacion.rollback();
				throw new BSoDException("El cliente ya existe");
			}
			else{
				idHabitacion = dao.addHabitacion(habitacionNueva);
				transacion.commit();
			}
		} catch (BSoDException e) {
			transacion.rollback();
			throw e;
		} finally {
			tm.eliminaTransaccion();
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
			List<TransferReserva> listareservas = FactoriaDAO.getInstance().generaDAOReserva().getReservasporHabitacion(idHabitacion);
			if(listareservas.isEmpty()) // Si la habitacion no tiene reservas activas
			{
			resultado = dao.deleteHabitacion(idHabitacion);
			transacion.commit();
			}
			else
			{
				resultado=false;
				listareservas=null;
				transacion.rollback();
			}
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
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
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
		} catch (BSoDException e) {
			throw e;
		} finally {
			tm.eliminaTransaccion();
		}

		return t;
	}
}
