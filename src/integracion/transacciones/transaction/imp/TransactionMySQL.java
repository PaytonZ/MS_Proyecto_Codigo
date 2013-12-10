/**
 * 
 */
package integracion.transacciones.transaction.imp;

import integracion.transacciones.conexiones.MySQLConnection;
import integracion.transacciones.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

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

	public TransactionMySQL() {
		jdbConnection = new MySQLConnection().getConnection();
	}

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
			// jdbConnection.setAutoCommit(false);
			puntoguardado = jdbConnection.setSavepoint();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void end() {
		try {
			jdbConnection.close();
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
			// jdbConnection.setAutoCommit(true);
		} catch (SQLException e) {
			rollback();
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
			/*
			 * PreparedStatement unlocktables = jdbConnection
			 * .prepareStatement(queryUnlockTables); unlocktables.execute();
			 */
			jdbConnection.rollback(puntoguardado);
		} catch (SQLException e) {
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
}