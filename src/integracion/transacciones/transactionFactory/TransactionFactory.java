/**
 * 
 */
package integracion.transacciones.transactionFactory;

import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionFactory.imp.TransactionFactoryImp;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class TransactionFactory {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static TransactionFactory transactionFactoryInstance;

	private synchronized static void createTransactionFactory() {
		if (transactionFactoryInstance == null)
			transactionFactoryInstance = new TransactionFactoryImp();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static TransactionFactory getInstance() {

		createTransactionFactory();
		return transactionFactoryInstance;
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract Transaction nuevaTransaccionMySQL();
}