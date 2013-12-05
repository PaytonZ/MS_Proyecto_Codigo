/**
 * 
 */
package integracion.transacciones.conexiones;

import java.sql.*;
import java.util.Properties;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author NASAIII
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class MySqlConnection {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String username="Alex";
	private String password="zabalamanco";
	
	
	public Connection getConnection() {
		 Connection conn = null;
		    Properties connectionProps = new Properties();
		    connectionProps.put("user", this.userName);
		    connectionProps.put("password", this.password);

		    if (this.dbms.equals("mysql")) {
		        conn = DriverManager.getConnection(
		                   "jdbc:" + this.dbms + "://" +
		                   this.serverName +
		                   ":" + this.portNumber + "/",
		                   connectionProps);
		    } else if (this.dbms.equals("derby")) {
		        conn = DriverManager.getConnection(
		                   "jdbc:" + this.dbms + ":" +
		                   this.dbName +
		                   ";create=true",
		                   connectionProps);
		    }
		    System.out.println("Connected to database");
		    return conn;
	}
}