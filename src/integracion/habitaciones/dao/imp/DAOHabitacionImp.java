/**
 * 
 */
package integracion.habitaciones.dao.imp;

import integracion.habitaciones.dao.DAOHabitacion;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.habitaciones.transfer.TipoHabitacion;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
import negocio.habitaciones.transfer.TransferHabitacionSuite;

//TODO FALTA TEST

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOHabitacionImp implements DAOHabitacion {
	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOHabitacion#addHabitacion(TransferHabitacionNormal habitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	
	private final String addHabitacionQuery = "INSERT INTO habitaciones (numhabitacion ,precio ,tipohabitacion) VALUES (?, ? , ?)";
	private final String getHabitacionQuery = "SELECT * FROM habitaciones WHERE numhabitacion = ? AND activo = true FOR UPDATE";
	private final String deleteHabitacionQuery = "UPDATE habitaciones SET activo = false WHERE numhabitacion = ?";
	private final String getAllHabitacionesQuery = "SELECT * FROM habitaciones WHERE activo = true FOR UPDATE";
	private final String updateHabitacionQuery = "UPDATE habitaciones SET  precio = ?, tipohabitacion = ? WHERE numhabitacion = ?";
	
	public Integer addHabitacion(TransferHabitacion habitacion) {

		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection c = t.getResource();

		Integer idHabitacion = null;

		try {
			PreparedStatement addhabitacion = c.prepareStatement(addHabitacionQuery);

			addhabitacion.setInt(1, habitacion.getNumHabitacion());
			addhabitacion.setDouble(2, habitacion.getPrecio());
			
			if(habitacion instanceof TransferHabitacionNormal)
				addhabitacion.setString(3, TipoHabitacion.HABITACION_NORMAL.name());
			else addhabitacion.setString(3, TipoHabitacion.HABITACION_SUITE.name());
	

			if (addhabitacion.executeUpdate() == 1) {

				PreparedStatement getHabitacionID = c
						.prepareStatement(getHabitacionQuery);
				getHabitacionID.setInt(1,habitacion.getNumHabitacion());

				ResultSet resultado = getHabitacionID.executeQuery();

				if (resultado.next())

					idHabitacion = resultado.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return idHabitacion;
		
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOHabitacion#getHabitacion(Object idHabitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferHabitacion getHabitacion(Integer idHabitacion) {
		
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		TransferHabitacion habitacion = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(getHabitacionQuery);
			preparedStatement.setInt(1, idHabitacion);

			ResultSet rowHabitacion = preparedStatement.executeQuery();

			if (rowHabitacion.next()) {
				
				switch (rowHabitacion.getString("tipohabitacion")) {
				case "Normal":
					habitacion = new TransferHabitacionNormal();
					break;
				case "Suite":
					habitacion = new TransferHabitacionSuite();
					break;
				default:
					habitacion = new TransferHabitacionNormal();
					break;
				}


				habitacion.setNumHabitacion(rowHabitacion.getInt("numhabitacion"));
				habitacion.setPrecio(rowHabitacion.getDouble("precio"));
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return habitacion;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOHabitacion#getAllHabitaciones()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferHabitacion> getAllHabitaciones() {
		
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		List<TransferHabitacion> listaHabitaciones = new ArrayList<TransferHabitacion>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(getAllHabitacionesQuery);

			ResultSet rowsHabitaciones = preparedStatement.executeQuery();

			while (rowsHabitaciones.next()) {

				TransferHabitacion habitacion = new TransferHabitacion();
				
				switch (rowsHabitaciones.getString("tipohabitacion")) {
				case "Normal":
					habitacion = new TransferHabitacionNormal();
					break;
				case "Suite":
					habitacion = new TransferHabitacionSuite();
					break;
				default:
					break;
				}

				habitacion.setNumHabitacion(rowsHabitaciones.getInt("numhabitacion"));
				habitacion.setPrecio(rowsHabitaciones.getInt("precio"));
		
				listaHabitaciones.add(habitacion);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaHabitaciones;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOHabitacion#updateHabitacion(TransferHabitacionNormal habitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean updateHabitacion(TransferHabitacion habitacion) {
		
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		boolean correcto = false;
		try {


			PreparedStatement preparedStatement = connection
					.prepareStatement(updateHabitacionQuery);
			preparedStatement.setDouble(1, habitacion.getPrecio());
			if(habitacion instanceof TransferHabitacionNormal)
				preparedStatement.setString(2, TipoHabitacion.HABITACION_NORMAL.name());
			else preparedStatement.setString(2, TipoHabitacion.HABITACION_SUITE.name());
			preparedStatement.setInt(3, habitacion.getNumHabitacion());

			correcto = (preparedStatement.executeUpdate() == 1);
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOHabitacion#deleteHabitacion(Object idHabitacion)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteHabitacion(Integer idHabitacion) {
		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		boolean correcto = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(deleteHabitacionQuery);
			preparedStatement.setInt(1, idHabitacion);
			
			correcto = (preparedStatement.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return correcto;
	}
}