/**
 * 
 */
package integracion.reservas.dao.imp;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracion.reservas.dao.DAOReserva;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;
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
	private final String addReservaQuery = "INSERT INTO reservas (clientes_idclientes ,habitaciones_numhabitacion , fecha_reserva ,fecha_entrada , fecha_salida) VALUES (?, ? , ? , ? , ?)";
	private final String getReservaQuery = "SELECT * FROM reservas WHERE idreservas = ?";
	private final String getReservabyDNIDateQuery = "SELECT idreservas FROM reservas WHERE DNI = ? AND fecha_reserva = ?";
	private final String deleteReservaQuery = "DELETE FROM reservas WHERE idreservas = ?";
	private final String getAllReservaQuery = "SELECT * FROM reservas WHERE clientes_idclientes = ?";
	private final String updateReservaQuery = "UPDATE reservas SET clientes_idclientes = ?, habitaciones_numhabitacion = ?, fecha_reserva = ?, fecha_entrada = ?, fecha_salida = ? WHERE idreservas = ?";

	public Integer addReserva(TransferReserva reserva) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection c = t.getResource();

		Integer idreserva = null;

		try {
			PreparedStatement addreserva = c.prepareStatement(addReservaQuery);

			addreserva.setString(1, reserva.getDNI());
			addreserva.setInt(2, reserva.getNumeroHabitacion());
			addreserva.setDate(3, (Date) reserva.getFechaReserva());
			addreserva.setDate(4, (Date) reserva.getFechaEntrada());
			addreserva.setDate(5, (Date) reserva.getFechaSalida());

			if (addreserva.executeUpdate() == 1) {

				PreparedStatement getreservaDNIDate = c.prepareStatement(getReservabyDNIDateQuery);
				getreservaDNIDate.setString(1, reserva.getDNI());
				getreservaDNIDate.setDate(2, (Date) reserva.getFechaReserva());

				ResultSet resultado = getreservaDNIDate.executeQuery();

				if (resultado.next())
					idreserva = resultado.getInt("idreservas");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return idreserva;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#deleteReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean deleteReserva(Integer idReserva) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#getAllReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferReserva> getAllReservas() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#getReserva(Integer idReserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferReserva getReserva(Integer idReserva) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOReserva#updateReserva(TransferReserva reserva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean updateReserva(TransferReserva reserva) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
}
