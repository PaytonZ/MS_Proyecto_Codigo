/**
 * 
 */
package integracion.clientes.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.clientes.dao.DAOCliente;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;
import negocio.clientes.transfer.TransferCliente;

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
	private final String addClienteQuery = "INSERT INTO clientes (DNI ,nombre , direccion ,1apellido , 2apellido , activo , telefono ) VALUES (?, ? , ? , ? , ? , ? , ? )";
	private final String getClientebyDNIQuery ="SELECT idClientes FROM clientes WHERE DNI = ? AND activo = true";
	private final String getClienteQuery = "SELECT * FROM clientes WHERE id = ? AND activado = true";
	private final String deleteClienteQuery = "UPDATE clientes SET activo = false WHERE idClientes = ?";

	public Integer addCliente(TransferCliente cliente) {

		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection c = t.getResource();

		Integer idCliente = null;
		
		PreparedStatement addcliente = null;
		try {
			addcliente = c.prepareStatement(addClienteQuery);

			addcliente.setString(1, cliente.getDNI());
			addcliente.setString(2, cliente.getNombre());
			addcliente.setString(3, cliente.getDireccion());
			addcliente.setString(4, cliente.getPrimerApellido());
			addcliente.setString(5, cliente.getSegundoApellido());
			addcliente.setBoolean(6, true);
			addcliente.setString(7, cliente.getNumTelefono());

			if (addcliente.execute()) {
				
				PreparedStatement getClienteDNI = c.prepareStatement(getClientebyDNIQuery);
				getClienteDNI.setString(1, cliente.getDNI());
				
				idCliente = getClienteDNI.executeQuery().getInt("idClientes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}

		return idCliente;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#getCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente getCliente(Integer idCliente) {
		
		Transaction transaction = TransactionManager.getInstance().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		TransferCliente cliente = null;
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(getClienteQuery);
			preparedStatement.setInt(1, idCliente);
			
			ResultSet rowCliente = preparedStatement.executeQuery();
			
			cliente = new TransferCliente();
			
			cliente.setID( rowCliente.getInt("idClientes") );
			cliente.setDNI( rowCliente.getString("DNI") );
			cliente.setDireccion( rowCliente.getString("direccion") );
			cliente.setNombre( rowCliente.getString("nombre") );
			cliente.setPrimerApellido( rowCliente.getString("1apellido") );
			cliente.setSegundoApellido( rowCliente.getString("2apellido") );
			cliente.setNumTelefono( rowCliente.getString("telefono") );
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#deleteCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteCliente(Integer idCliente) {
		
		Transaction transaction = TransactionManager.getInstance().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		PreparedStatement preparedStatement;
		
		boolean correcto = false;
		try {
			preparedStatement = connection.prepareStatement(getClienteQuery);
			preparedStatement.setInt(1, idCliente);
			
			correcto = (preparedStatement.executeUpdate() == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return correcto;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#getAllClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TransferCliente> getAllClientes() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#updateCliente(TransferCliente cliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean updateCliente(TransferCliente cliente) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return false;
		// end-user-code
	}
}