/**
 * 
 */
package integracion.transacciones.transaction.imp;

import integracion.transacciones.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.swing.JButton;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionMySQL implements Transaction {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Connection jdbConnection;
	private Savepoint puntoguardado;
	
	/**
	 * @return el jdbConnection
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getJdbConnection() {
		// begin-user-code
		return jdbConnection;
		// end-user-code
	}

	/**
	 * @param jdbConnection
	 *            el jdbConnection a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setJdbConnection(Connection jdbConnection) {
		// begin-user-code
		this.jdbConnection = jdbConnection;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see Transaction#start()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {
		try {
			jdbConnection.setAutoCommit(false);
			puntoguardado= jdbConnection.setSavepoint();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see Transaction#commit()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		try {
			jdbConnection.commit();
			jdbConnection.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see Transaction#rollback()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() {
		try {
			jdbConnection.rollback(puntoguardado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see Transaction#getResource()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getResource() {
		
		return jdbConnection;
		
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see Transaction#lock()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void lock() {
	
			
	}
}