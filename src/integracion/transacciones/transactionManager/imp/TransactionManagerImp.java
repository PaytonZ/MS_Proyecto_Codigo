/**
 * 
 */
package integracion.transacciones.transactionManager.imp;

import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionFactory.TransactionFactory;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
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

		Long threadId = Thread.currentThread().getId();
		
		Transaction t = null;
		if(mapa.containsKey((threadId))) {
			t = mapa.get(threadId);
		}
		else {
			//THROWEXCEPTION
		}
		
		return t;
		 
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see TransactionManager#eliminaTransaccion()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean eliminaTransaccion() throws BSoDException {
		
		Long threadId = Thread.currentThread().getId();
		
		boolean resultado;
		if (mapa.containsKey(threadId)) {
			
			Transaction t = mapa.get(threadId);
			
			t.commit();
			t.end();
			
			mapa.remove(threadId);
			
			resultado = true;
		} else {
			
			resultado = false;
		}
		
		return resultado;
	}
}