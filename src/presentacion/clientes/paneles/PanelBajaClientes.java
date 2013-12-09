/**
 * 
 */
package presentacion.clientes.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import presentacion.clientes.GUIInterfazClientes;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelBajaClientes extends JPanel implements GUIInterfazClientes {
	private static final long serialVersionUID = 1L;
	
	private JList<TransferCliente> list;
	
	public PanelBajaClientes() {
		
		setLayout(new BorderLayout(0, 0));
		
//		ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
//		controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE_V_BORRA, null);
		
		// TODO esto son datos de prueba, se tienen que conseguir del comando a través del método actualizaVentana
//		TransferCliente cliente1 = new TransferCliente();
//		cliente1.setID(1);
//		cliente1.setDNI("111111");
//		cliente1.setDireccion("dondesea");
//		cliente1.setNombre("pepito");
//		cliente1.setNumTelefono(98374598);
//		cliente1.setPrimerApellido("apellido1");
//		cliente1.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente2 = new TransferCliente();
//		cliente2.setID(1);
//		cliente2.setDNI("222222222");
//		cliente2.setDireccion("dondesea");
//		cliente2.setNombre("juanito");
//		cliente2.setNumTelefono(54345678);
//		cliente2.setPrimerApellido("apellido1");
//		cliente2.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente3 = new TransferCliente();
//		cliente3.setID(1);
//		cliente3.setDNI("111111");
//		cliente3.setDireccion("dondesea");
//		cliente3.setNombre("pepito");
//		cliente3.setNumTelefono(98374598);
//		cliente3.setPrimerApellido("apellido1");
//		cliente3.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente4 = new TransferCliente();
//		cliente4.setID(1);
//		cliente4.setDNI("222222222");
//		cliente4.setDireccion("dondesea");
//		cliente4.setNombre("juanito");
//		cliente4.setNumTelefono(54345678);
//		cliente4.setPrimerApellido("apellido1");
//		cliente4.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente5 = new TransferCliente();
//		cliente5.setID(1);
//		cliente5.setDNI("111111");
//		cliente5.setDireccion("dondesea");
//		cliente5.setNombre("pepito");
//		cliente5.setNumTelefono(98374598);
//		cliente5.setPrimerApellido("apellido1");
//		cliente5.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente6 = new TransferCliente();
//		cliente6.setID(1);
//		cliente6.setDNI("222222222");
//		cliente6.setDireccion("dondesea");
//		cliente6.setNombre("juanito");
//		cliente6.setNumTelefono(54345678);
//		cliente6.setPrimerApellido("apellido1");
//		cliente6.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente7 = new TransferCliente();
//		cliente7.setID(1);
//		cliente7.setDNI("111111");
//		cliente7.setDireccion("dondesea");
//		cliente7.setNombre("pepito");
//		cliente7.setNumTelefono(98374598);
//		cliente7.setPrimerApellido("apellido1");
//		cliente7.setSegundoApellido("apellido2");
//		
//		TransferCliente cliente8 = new TransferCliente();
//		cliente8.setID(1);
//		cliente8.setDNI("222222222");
//		cliente8.setDireccion("dondesea");
//		cliente8.setNombre("juanito");
//		cliente8.setNumTelefono(54345678);
//		cliente8.setPrimerApellido("apellido1");
//		cliente8.setSegundoApellido("apellido2");
//		
//		TransferCliente[] listaClientes = { cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8 };
//		
//		// NO SE PARAMETRIZA LA INTANCIA DE LIST PORQUE SINO EL WINDOW BUILDER PRO NO LO PARSEA BIEN
//		list = new JList(listaClientes);
		
		list = new JList();
		
		add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMinimumSize(new Dimension(15, 14));
		add(panel, BorderLayout.SOUTH);
		
		LC layoutconstraits = new LC();
		layoutconstraits.fillX();
		
		panel.setLayout(new MigLayout("fillx", "[208.00,right]", "[]"));
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferCliente clienteaBorrar = list.getSelectedValue();
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_BAJA_CLIENTE, clienteaBorrar);
			}
		});
		panel.add(btnNewButton, "cell 0 1,alignx center");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(Object datos) {
		
		if ( datos instanceof List) {
			
			@SuppressWarnings("unchecked")
			List<TransferCliente> listaClientes = (List<TransferCliente>) datos;
			
			TransferCliente[] clientes = new TransferCliente[listaClientes.size()];
			listaClientes.toArray(clientes);
			
			list.setListData(clientes);
		}
		else if ( datos instanceof BSoDException ) {
			
		}
	}
	
	public void cargaDatosInit() {
		ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
		controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE_V_BORRA, null);
	}
}