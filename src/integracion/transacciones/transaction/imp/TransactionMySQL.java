/**
 * 
 */
package integracion.transacciones.transaction.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import integracion.transacciones.conexiones.MySQLConnection;
import integracion.transacciones.transaction.Transaction;

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
	private final String queryStartTransaction = "START TRANSACTION";
	private final String queryCommit = "COMMIT";
	private final String queryRollback = "ROLLBACK";

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

			jdbConnection = new MySQLConnection().getConnection();
			PreparedStatement starttransaction = jdbConnection
					.prepareStatement(queryStartTransaction);

			if (starttransaction.execute()) {
				// error

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void end() {
		try {
			commit();
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
			PreparedStatement commit = jdbConnection
					.prepareStatement(queryCommit);
			commit.execute();
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
			PreparedStatement rollback = jdbConnection
					.prepareStatement(queryRollback);
			rollback.execute();
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