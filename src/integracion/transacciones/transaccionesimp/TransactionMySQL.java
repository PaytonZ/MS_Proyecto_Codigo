/**
 * 
 */
package integracion.transacciones.transaccionesimp;

import integracion.transacciones.Transaction;

import java.sql.Connection;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author NASAIII
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionMySQL implements Transaction {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Connection jdbConnection;

	/** 
	 * @return el jdbConnection
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getJdbConnection() {
		// begin-user-code
		return jdbConnection;
		// end-user-code
	}

	/** 
	 * @param jdbConnection el jdbConnection a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setJdbConnection(Connection jdbConnection) {
		// begin-user-code
		this.jdbConnection = jdbConnection;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#start()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#commit()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		// begin-user-code
		// TODO Apéndice de método generado autom�ticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#rollback()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollback() {
		// begin-user-code
		// TODO Apéndice de método generado autom�ticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#getResource()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Connection getResource() {
		// begin-user-code
		// TODO Apéndice de método generado autom�ticamente
		return null;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see Transaction#lock()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void lock() {
		// begin-user-code
		// TODO Apéndice de método generado autom�ticamente

		// end-user-code
	}
}