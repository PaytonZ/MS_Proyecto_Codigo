/**
 * 
 */
package integracion.reservas.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;
import negocio.excepciones.BSoDException;
import negocio.reservas.transfer.TransferReserva;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOReservaImp implements DAOReserva {
	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#addReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	 private final String addReservaQuery =
	 "INSERT INTO reservas (clientes_idclientes ,habitaciones_numhabitacion , fecha_reserva ,fecha_entrada , fecha_salida) VALUES (?, ? , ? , ? , ?)";
	// private final String addReservaQuery =
	// "INSERT INTO reservas (clientes_idclientes ,habitaciones_numhabitacion , fecha_reserva ,fecha_entrada , fecha_salida) VALUES (?, ? , CURRENT_TIMESTAMP, ? , ?)";
	private final String getReservaQuery = "SELECT * FROM reservas WHERE idreservas = ? FOR UPDATE";
	private final String getReservabyDNIDateQuery = "SELECT idreservas FROM reservas WHERE clientes_idclientes = ? AND fecha_reserva = ? FOR UPDATE";
	private final String deleteReservaQuery = "DELETE FROM reservas WHERE idreservas = ?";
	private final String getAllReservaPorClienteQuery = "SELECT * FROM reservas WHERE clientes_idclientes = ? FOR UPDATE";
	private final String updateReservaQuery = "UPDATE reservas SET clientes_idclientes = ?, habitaciones_numhabitacion = ?, fecha_reserva = ?, fecha_entrada = ?, fecha_salida = ? WHERE idreservas = ?";
	private final String getHabporReservaQuery = "SELECT * from reservas where habitaciones_numhabitacion = ? FOR UPDATE";
	private final String getallReservaquery = "SELECT * from reservas FOR UPDATE";

	public Integer addReserva(TransferReserva reserva) throws BSoDException {
		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection c = t.getResource();

		Integer idreserva = null;

		try {
			PreparedStatement addreserva = c.prepareStatement(addReservaQuery);

			addreserva.setInt(1, reserva.getidusuario());
			addreserva.setInt(2, reserva.getNumeroHabitacion());
			addreserva.setTimestamp(3, new Timestamp(reserva.getFechaReserva().getTime()));
			addreserva.setDate(4,(Date) reserva.getFechaEntrada());
			addreserva.setDate(5,(Date) reserva.getFechaSalida());

			if (addreserva.executeUpdate() == 1) {

				PreparedStatement getreservaDNIDate = c
						.prepareStatement(getReservabyDNIDateQuery);
				getreservaDNIDate.setInt(1, reserva.getidusuario());
				getreservaDNIDate.setTimestamp(2, new Timestamp(reserva.getFechaReserva()
						.getTime()));
				ResultSet resultado = getreservaDNIDate.executeQuery();

				if (resultado.next())
					idreserva = resultado.getInt("idreservas");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al hacer la reserva");
		}

		return idreserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#deleteReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean deleteReserva(Integer idReserva) throws BSoDException {
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		boolean borrado = false;
		try {
			PreparedStatement deletereserva = connection
					.prepareStatement(deleteReservaQuery);
			deletereserva.setInt(1, idReserva);

			borrado = (deletereserva.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al eliminar la reserva");
		}

		return borrado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#getAllReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferReserva> getAllReservasporCliente(Integer idCliente)
			throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		List<TransferReserva> listaReservas = new ArrayList<TransferReserva>();

		try {
			PreparedStatement todaslasreservas = connection
					.prepareStatement(getAllReservaPorClienteQuery);
			todaslasreservas.setInt(1, idCliente);
			ResultSet rowsReservas = todaslasreservas.executeQuery();
			while (rowsReservas.next()) {

				TransferReserva reserva = new TransferReserva();

				reserva.setNumeroReserva(rowsReservas.getInt("idreservas"));
				reserva.setidusuario(rowsReservas.getInt("clientes_idclientes"));
				reserva.setNumeroHabitacion(rowsReservas
						.getInt("habitaciones_numhabitacion"));
				reserva.setFechaReserva(rowsReservas.getDate("fecha_reserva"));
				reserva.setFechaEntrada(rowsReservas.getDate("fecha_entrada"));
				reserva.setFechaSalida(rowsReservas.getDate("fecha_salida"));
				listaReservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al cargar las reservas");
		}

		return listaReservas;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#getReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva getReserva(Integer idReserva) throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		TransferReserva reserva = null;

		try {
			PreparedStatement getreserva = connection
					.prepareStatement(getReservaQuery);
			getreserva.setInt(1, idReserva);

			ResultSet rowReserva = getreserva.executeQuery();

			if (rowReserva.next()) {
				reserva = new TransferReserva();
				reserva.setNumeroReserva(rowReserva.getInt("idreservas"));
				reserva.setidusuario(rowReserva.getInt("clientes_idclientes"));
				reserva.setNumeroHabitacion(rowReserva
						.getInt("habitaciones_numhabitacion"));
				reserva.setFechaReserva(rowReserva.getDate("fecha_reserva"));
				reserva.setFechaEntrada(rowReserva.getDate("fecha_entrada"));
				reserva.setFechaSalida(rowReserva.getDate("fecha_salida"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al cargar la reserva");
		}

		return reserva;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @throws BSoDException
	 * 
	 * @see DAOReserva#updateReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean updateReserva(TransferReserva reserva) throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		boolean exitoupdate = false;
		try {
			PreparedStatement updatereserva = connection
					.prepareStatement(updateReservaQuery);
			updatereserva.setInt(6, reserva.getNumeroReserva());
			updatereserva.setInt(1, reserva.getidusuario());
			updatereserva.setInt(2, reserva.getNumeroHabitacion());
			updatereserva.setDate(3, (Date) reserva.getFechaReserva());
			updatereserva.setDate(4, (Date) reserva.getFechaEntrada());
			updatereserva.setDate(5, (Date) reserva.getFechaSalida());
			exitoupdate = (updatereserva.executeUpdate() == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al actualizar la reserva");
		}

		return exitoupdate;
	}

	@Override
	public List<TransferReserva> getReservasporHabitacion(Integer numhab)
			throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		List<TransferReserva> listaReservas = new ArrayList<TransferReserva>();

		try {
			PreparedStatement todaslasreservas = connection
					.prepareStatement(getHabporReservaQuery);
			todaslasreservas.setInt(1, numhab);
			ResultSet rowsReservas = todaslasreservas.executeQuery();
			while (rowsReservas.next()) {

				TransferReserva reserva = new TransferReserva();

				reserva.setNumeroReserva(rowsReservas.getInt("idreservas"));
				reserva.setidusuario(rowsReservas.getInt("clientes_idclientes"));
				reserva.setNumeroHabitacion(rowsReservas
						.getInt("habitaciones_numhabitacion"));
				reserva.setFechaReserva(rowsReservas.getDate("fecha_reserva"));
				reserva.setFechaEntrada(rowsReservas.getDate("fecha_entrada"));
				reserva.setFechaSalida(rowsReservas.getDate("fecha_salida"));
				listaReservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException(
					"Error al cargar las reservas de la habitacion");
		}

		return listaReservas;

	}

	@Override
	public List<TransferReserva> getAllReservas() throws BSoDException {
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		List<TransferReserva> listaReservas = new ArrayList<TransferReserva>();
		try {
			PreparedStatement todaslasreservas = connection
					.prepareStatement(getallReservaquery);
			ResultSet rowsReservas = todaslasreservas.executeQuery();
			while (rowsReservas.next()) {
				TransferReserva reserva = new TransferReserva();

				reserva.setNumeroReserva(rowsReservas.getInt("idreservas"));
				reserva.setidusuario(rowsReservas.getInt("clientes_idclientes"));
				reserva.setNumeroHabitacion(rowsReservas
						.getInt("habitaciones_numhabitacion"));
				reserva.setFechaReserva(rowsReservas.getDate("fecha_reserva"));
				reserva.setFechaEntrada(rowsReservas.getDate("fecha_entrada"));
				reserva.setFechaSalida(rowsReservas.getDate("fecha_salida"));
				listaReservas.add(reserva);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al cargar las reservas");
		}
		return listaReservas;
	}
}
