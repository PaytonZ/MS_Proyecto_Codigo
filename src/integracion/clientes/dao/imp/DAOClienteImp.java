/**
 * 
 */
package integracion.clientes.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	private final String addClienteQuery= "INSERT INTO clientes (DNI ,nombre , direccion ,1apellido , 2apellido , activo , telefono )"
			+ 											"VALUES (?, ? , ? , ? , ? , ? , ? )" ;
			
	
	public Integer addCliente(TransferCliente Cliente) {
		
		Transaction t = TransactionManager.getInstance().getTransaccion();
		Connection  c = t.getResource();
	
		
		
		
		PreparedStatement addcliente = null;
		try{
			addcliente = c.prepareStatement(addClienteQuery);
			
			addcliente.setString(1, Cliente.getDNI());
			addcliente.setString(2,Cliente.getNombre());
			addcliente.setString(3,Cliente.getDireccion());
			addcliente.setString(4,Cliente.getPrimerApellido());
			addcliente.setString(5,Cliente.getSegundoApellido());
			addcliente.setBoolean(6,true);
			addcliente.setInt(7,Cliente.getNumTelefono());
			
			addcliente.execute();
			
			
			
			
			
			
		}catch(SQLException e )
		{
			e.printStackTrace();
		}
		finally { 
		}
			
		
		
		return -1;
		}
		
		
		


	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#getCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferCliente getCliente(Integer idCliente) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see DAOCliente#deleteCliente(Clase idCliente)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean deleteCliente(Integer idCliente) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return false;
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