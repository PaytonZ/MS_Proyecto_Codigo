/**
 * 
 */
package integración.transacciones.TransactionManagerimp;

import integración.transacciones.TransactionManager;
import java.util.concurrent.ConcurrentHashMap;
import integración.transacciones.Transaction;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author NASAIII
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransactionManagerImp extends TransactionManager {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private ConcurrentHashMap<Thread,Transaction> mapa;

	/** 
	 * @return el mapa
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ConcurrentHashMap<Thread,Transaction> getMapa() {
		// begin-user-code
		return mapa;
		// end-user-code
	}

	/** 
	 * @param mapa el mapa a establecer
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setMapa(ConcurrentHashMap<Thread,Transaction> mapa) {
		// begin-user-code
		this.mapa = mapa;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#nuevaTransaccion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction nuevaTransaccion() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return null;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#getTransaccion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Transaction getTransaccion() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return null;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see TransactionManager#eliminaTransaccion()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean eliminaTransaccion() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return null;
		// end-user-code
	}
}