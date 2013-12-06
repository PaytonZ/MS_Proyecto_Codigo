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
	private final String getClientebyDNIQuery ="SELECT idclientes FROM clientes WHERE DNI = ? AND activo = true";
	private final String getClienteQuery = "SELECT * FROM clientes WHERE idcliente = ? AND activado = true";
	private final String deleteClienteQuery = "UPDATE clientes SET activo = false WHERE idclientes = ?";
	private final String getAllClientesQuery = "SELECT * FROM clientes WHERE activo = true";
	private final String updateClienteQuery = "UPDATE clientes SET DNI = ?, nombre = ?, direccion = ?, 1apellido = ?, 2apellido = ?, telefono = ? WHERE idclientes = ?";
	

	public Integer addCliente(TransferCliente cliente) {

		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection c = t.getResource();

		Integer idCliente = null;
		
		try {
			PreparedStatement addcliente = c.prepareStatement(addClienteQuery);

			addcliente.setString(1, cliente.getDNI());
			addcliente.setString(2, cliente.getNombre());
			addcliente.setString(3, cliente.getDireccion());
			addcliente.setString(4, cliente.getPrimerApellido());
			addcliente.setString(5, cliente.getSegundoApellido());
			addcliente.setInt(6, cliente.getNumTelefono());

			if ( addcliente.executeUpdate() == 1 ) {
				
				PreparedStatement getClienteDNI = c.prepareStatement(getClientebyDNIQuery);
				getClienteDNI.setString(1, cliente.getDNI());
				
				ResultSet resultado = getClienteDNI.executeQuery();
				
				if ( resultado.next() )
				
				idCliente = resultado.getInt("idClientes");
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
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(getClienteQuery);
			preparedStatement.setInt(1, idCliente);
			
			ResultSet rowCliente = preparedStatement.executeQuery();
			
			cliente = new TransferCliente();
			
			cliente.setID( rowCliente.getInt("idClientes") );
			cliente.setDNI( rowCliente.getString("DNI") );
			cliente.setDireccion( rowCliente.getString("direccion") );
			cliente.setNombre( rowCliente.getString("nombre") );
			cliente.setPrimerApellido( rowCliente.getString("1apellido") );
			cliente.setSegundoApellido( rowCliente.getString("2apellido") );
			cliente.setNumTelefono( rowCliente.getInt("telefono") );
			
			
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
		
		boolean correcto = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteClienteQuery);
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
	public List<TransferCliente> getAllClientes() {
		
		Transaction transaction = TransactionManager.getInstance().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		List<TransferCliente> listaClientes = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(getAllClientesQuery);

			ResultSet rowsClientes = preparedStatement.executeQuery();
			
			while ( rowsClientes.next() ) {
				
				TransferCliente cliente = new TransferCliente();
				
				cliente.setID( rowsClientes.getInt("idClientes") );
				cliente.setDNI( rowsClientes.getString("DNI") );
				cliente.setDireccion( rowsClientes.getString("direccion") );
				cliente.setNombre( rowsClientes.getString("nombre") );
				cliente.setPrimerApellido( rowsClientes.getString("1apellido") );
				cliente.setSegundoApellido( rowsClientes.getString("2apellido") );
				cliente.setNumTelefono( rowsClientes.getInt("telefono") );
				
				listaClientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listaClientes;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#updateCliente(TransferCliente cliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean updateCliente(TransferCliente cliente) {
		
		Transaction transaction = TransactionManager.getInstance().getTransaccion();
		Connection connection = (Connection) transaction.getResource();
		
		boolean correcto = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateClienteQuery);
			preparedStatement.setString(1, cliente.getDNI());
			preparedStatement.setString(2, cliente.getNombre());
			preparedStatement.setString(3, cliente.getDireccion());
			preparedStatement.setString(4, cliente.getPrimerApellido());
			preparedStatement.setString(5, cliente.getSegundoApellido());
			preparedStatement.setInt(6, cliente.getNumTelefono());
			
			correcto = (preparedStatement.executeUpdate() == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return correcto;
	}
}