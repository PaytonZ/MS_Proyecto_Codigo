/**
 * 
 */
package integracion.transacciones.transactionFactory.imp;

import integracion.transacciones.conexiones.MySQLConnection;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transaction.imp.TransactionMySQL;
import integracion.transacciones.transactionFactory.TransactionFactory;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionFactoryImp extends TransactionFactory {
	/**
	 * (sin Javadoc)
	 * 
	 * @see TransactionFactory#nuevaTransaccion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction nuevaTransaccionMySQL() {

		TransactionMySQL t = new TransactionMySQL();
		t.setJdbConnection(new MySQLConnection().getConnection());

		return t;

	}
}