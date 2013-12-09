/**
 * 
 */
package presentacion.clientes.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
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
public class PanelConsultaClientes extends JPanel implements GUIInterfazClientes {

	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField txtDni;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;
	
	public PanelConsultaClientes() {
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][]"));
		
		JLabel lblConsultaClientes = new JLabel("Consulta clientes");
		add(lblConsultaClientes, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 2 4,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		add(textDNIBusqueda, "cell 3 4,growx");
		textDNIBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniCliente = textDNIBusqueda.getText();
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE, dniCliente);
			}
		});
		add(btnBuscar, "cell 5 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,aligny center");
		
		JLabel lblDni_1 = new JLabel("DNI: ");
		add(lblDni_1, "cell 2 6,alignx right");
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		add(txtDni, "cell 3 6,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 5 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 6 6,growx");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 2 8,alignx right");
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		add(textApellidos, "cell 3 8,growx");
		textApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección: ");
		add(lblDireccin, "cell 5 8,alignx trailing");
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		add(textDireccion, "cell 6 8,growx");
		textDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		add(lblTelefono, "cell 2 10,alignx trailing");
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		add(textTelefono, "cell 3 10,growx");
		textTelefono.setColumns(10);
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(Object datos) {
		
		if ( datos instanceof TransferCliente) {
			
			TransferCliente cliente = (TransferCliente) datos;
			
			if ( cliente != null ) {
				txtDni.setText(cliente.getDNI());
				textNombre.setText(cliente.getNombre());
				textApellidos.setText(cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
				textDireccion.setText(cliente.getDireccion());
				textTelefono.setText( String.valueOf(cliente.getNumTelefono()) );
			}
		}
	}
}