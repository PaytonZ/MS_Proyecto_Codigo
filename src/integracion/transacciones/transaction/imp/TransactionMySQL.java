/**
 * 
 */
package integracion.transacciones.transaction.imp;

import integracion.transacciones.conexiones.MySQLConnection;
import integracion.transacciones.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
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
	 * @throws BSoDException 
	 * 
	 * @see Transaction#start()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() throws BSoDException {
		try {

			jdbConnection = new MySQLConnection().getConnection();
			PreparedStatement starttransaction = jdbConnection
					.prepareStatement(queryStartTransaction);

			if (starttransaction.execute()) {
				// error

			}
		} catch (Exception e) {
			throw new BSoDException("Error al comenzar la conexión");
		}

	}

	public void end() throws BSoDException {
		try {
			commit();
			jdbConnection.close();
		} catch (Exception e) {
			throw new BSoDException("Error al cerrar la conexión");
		}
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see Transaction#commit()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() throws BSoDException {
		try {
			PreparedStatement commit = jdbConnection
					.prepareStatement(queryCommit);
			commit.execute();
		} catch (Exception e) {
			rollback();
			throw new BSoDException("Error al comenzar la conexión");
		}
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see Transaction#rollback()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() throws BSoDException {
		try {
			PreparedStatement rollback = jdbConnection
					.prepareStatement(queryRollback);
			rollback.execute();
		} catch (Exception e) {
			throw new BSoDException("Error al hacer rollback");
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