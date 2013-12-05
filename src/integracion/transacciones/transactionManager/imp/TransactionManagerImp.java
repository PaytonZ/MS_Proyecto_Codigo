/**
 * 
 */
package integracion.transacciones.transactionManager.imp;

import java.util.concurrent.ConcurrentHashMap;

import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionFactory.TransactionFactory;
import integracion.transacciones.transactionManager.TransactionManager;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap<Long, Transaction> mapa = new ConcurrentHashMap<>();

	/**
	 * (sin Javadoc)
	 * 
	 * @see TransactionManager#nuevaTransaccion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction nuevaTransaccion() {

		Transaction t;
		Long threadId = Thread.currentThread().getId();
		if (mapa.containsKey(threadId)) {
			t = mapa.get(threadId);
		} else {
			t = TransactionFactory.getInstance().nuevaTransaccionMySQL();
			mapa.put(threadId, t);
		}

		return t;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see TransactionManager#getTransaccion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction getTransaccion() {

		return nuevaTransaccion();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see TransactionManager#eliminaTransaccion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean eliminaTransaccion() {
		Long threadId = Thread.currentThread().getId();
		boolean resultado;
		if (mapa.containsKey(threadId)) {
			mapa.remove(threadId);
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
	}
}