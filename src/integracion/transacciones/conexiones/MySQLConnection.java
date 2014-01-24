/**
 * 
 */
package integracion.transacciones.conexiones;

import java.sql.*;
import java.util.Properties;

import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MySQLConnection {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String username = "Alex";
	private String password = "zabalamanco";
	private String dbms = "mysql";
	private String serverName = "test.motopoliza.com";
	private int portNumber = 3306;
	private String dbname = "alex";

	public Connection getConnection() throws BSoDException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.username);
		connectionProps.put("password", this.password);

		try {
			conn = DriverManager.getConnection("jdbc:" + this.dbms + "://"
					+ this.serverName + ":" + this.portNumber + "/" + dbname,
					connectionProps);
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

		} catch (Exception e) {
			throw new BSoDException(e.toString());
		}

		return conn;
	}
}