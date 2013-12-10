/**
 * 
 */
package integracion.clientes.dao.imp;

import integracion.clientes.dao.DAOCliente;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */

public class DAOClienteImp implements DAOCliente {
	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#addCliente(TransferCliente Cliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private final String addClienteQuery = "INSERT INTO clientes (DNI ,nombre , direccion ,1apellido , 2apellido , telefono ) VALUES (?, ? , ? , ? , ? , ? )";
	private final String getClientebyDNIQuery = "SELECT idclientes FROM clientes WHERE DNI = ? AND activo = true FOR UPDATE";
	private final String getClienteQuery = "SELECT * FROM clientes WHERE DNI = ? AND activo = true FOR UPDATE";
	private final String deleteClienteQuery = "UPDATE clientes SET activo = false WHERE idclientes = ?";
	private final String getAllClientesQuery = "SELECT * FROM clientes WHERE activo = true FOR UPDATE";
	private final String updateClienteQuery = "UPDATE clientes SET DNI = ?, nombre = ?, direccion = ?, 1apellido = ?, 2apellido = ?, telefono = ? WHERE idclientes = ?";
	
	//TODO discutir el tema de reactivar los clientes
	private final String getClienteDesactivadoByDNI = "SELECT DNI FROM clientes WHERE DNI = ? AND activo = false";
	private final String activateClienteByDNI = "UPDATE clientes SET activo = true WHERE DNI = ?";

	public Integer addCliente(TransferCliente cliente) throws BSoDException {

		Transaction transaccion = TransactionManager.getInstance().getTransaccion();
		Connection connection = transaccion.getResource();

		Integer idCliente = null;

		try {
			
			boolean queryCorrecta = false;
			
			//Si hay un cliente borrado con DNI X, si vas a dar de alta alguien con el mismo DNI, se activa el cliente con los datos antiguos
			PreparedStatement consultaClienteDesactivado = connection.prepareStatement(getClienteDesactivadoByDNI);
			consultaClienteDesactivado.setString(1, cliente.getDNI());
			
			ResultSet res = consultaClienteDesactivado.executeQuery();
			
			if (res.next()) {
				
				//Si devuelve algo es que teniamos el cliente pero inactivo
				PreparedStatement activaCliente = connection.prepareStatement(activateClienteByDNI);
				activaCliente.setString(1, cliente.getDNI());
				
				if ( activaCliente.executeUpdate() == 1 ) {
				
					queryCorrecta = true;
				}
			}
			else {
			
				PreparedStatement addcliente = connection.prepareStatement(addClienteQuery);
	
				addcliente.setString(1, cliente.getDNI());
				addcliente.setString(2, cliente.getNombre());
				addcliente.setString(3, cliente.getDireccion());
				addcliente.setString(4, cliente.getPrimerApellido());
				addcliente.setString(5, cliente.getSegundoApellido());
				addcliente.setInt(6, cliente.getNumTelefono());
				
	
				if (addcliente.executeUpdate() == 1) {
					queryCorrecta = true;
				}
			}
			
			if ( queryCorrecta ) {

				PreparedStatement getClienteDNI = connection.prepareStatement(getClientebyDNIQuery);
				getClienteDNI.setString(1, cliente.getDNI());

				ResultSet resultado = getClienteDNI.executeQuery();

				if (resultado.next()) {
					
					idCliente = resultado.getInt("idclientes");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al crear el usuario");
			// TRATAR

		} finally {
		}

		return idCliente;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see DAOCliente#getCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente getCliente(String dniCliente) throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		TransferCliente cliente = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(getClienteQuery);
			preparedStatement.setString(1, dniCliente);

			ResultSet rowCliente = preparedStatement.executeQuery();

			if (rowCliente.next()) {
				cliente = new TransferCliente();

				cliente.setID(rowCliente.getInt("idClientes"));
				cliente.setDNI(rowCliente.getString("DNI"));
				cliente.setDireccion(rowCliente.getString("direccion"));
				cliente.setNombre(rowCliente.getString("nombre"));
				cliente.setPrimerApellido(rowCliente.getString("1apellido"));
				cliente.setSegundoApellido(rowCliente.getString("2apellido"));
				cliente.setNumTelefono(rowCliente.getInt("telefono"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al cargar el usuario");
		}

		return cliente;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see DAOCliente#deleteCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteCliente(Integer idCliente) throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		boolean correcto = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(deleteClienteQuery);
			preparedStatement.setInt(1, idCliente);

			correcto = (preparedStatement.executeUpdate() == 1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al eliminar el usuario");
		}

		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see DAOCliente#getAllClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<TransferCliente> getAllClientes() throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		List<TransferCliente> listaClientes = null;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(getAllClientesQuery);

			ResultSet rowsClientes = preparedStatement.executeQuery();

			listaClientes = new ArrayList<>();
			
			while (rowsClientes.next()) {

				TransferCliente cliente = new TransferCliente();

				cliente.setID(rowsClientes.getInt("idClientes"));
				cliente.setDNI(rowsClientes.getString("DNI"));
				cliente.setDireccion(rowsClientes.getString("direccion"));
				cliente.setNombre(rowsClientes.getString("nombre"));
				cliente.setPrimerApellido(rowsClientes.getString("1apellido"));
				cliente.setSegundoApellido(rowsClientes.getString("2apellido"));
				cliente.setNumTelefono(rowsClientes.getInt("telefono"));

				listaClientes.add(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al cargar los usuarios");
		}

		return listaClientes;
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see DAOCliente#updateCliente(TransferCliente cliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean updateCliente(TransferCliente cliente) throws BSoDException {

		Transaction transaction = TransactionManager.getInstance()
				.getTransaccion();
		Connection connection = (Connection) transaction.getResource();

		Boolean correcto = false;




		try {

			 PreparedStatement getClienteDNI = connection.prepareStatement(getClientebyDNIQuery);
			 getClienteDNI.setString(1, cliente.getDNI());
			
			 ResultSet clienteID = getClienteDNI.executeQuery();
			
			 if (clienteID.next()) {
				 Integer idCliente = clienteID.getInt("idclientes");
	
				PreparedStatement preparedStatement = connection
						.prepareStatement(updateClienteQuery);
				preparedStatement.setString(1, cliente.getDNI());
				preparedStatement.setString(2, cliente.getNombre());
				preparedStatement.setString(3, cliente.getDireccion());
				preparedStatement.setString(4, cliente.getPrimerApellido());
				preparedStatement.setString(5, cliente.getSegundoApellido());
				preparedStatement.setInt(6, cliente.getNumTelefono());
				preparedStatement.setInt(7, idCliente);
	
				correcto = (preparedStatement.executeUpdate() == 1);

			 }




		} catch (SQLException e) {
			e.printStackTrace();
			throw new BSoDException("Error al actualizar el cliente");
		} finally {

		}

		return correcto;
	}
}
