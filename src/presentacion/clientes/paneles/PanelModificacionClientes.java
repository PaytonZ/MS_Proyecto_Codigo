/**
 * 
 */
package presentacion.clientes.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class PanelModificacionClientes extends JPanel implements GUIInterfazClientes {
	
	private static final long serialVersionUID = 1L;
	private JTextField textDNIBusqueda;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;
	
	public PanelModificacionClientes() {
		setLayout(new MigLayout("", "[][][60.00,grow][][36.00][][grow][]", "[][][][][][17.00][][10.00][][][][]"));
		
		JLabel lblModificacinDeClientes = new JLabel("Modificación de clientes");
		add(lblModificacinDeClientes, "cell 0 0 7 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 6 1, growx, aligny center");
		
		JLabel label = new JLabel("DNI: ");
		add(label, "cell 1 3,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		textDNIBusqueda.setColumns(10);
		add(textDNIBusqueda, "cell 2 3 2 1,growx");
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniCliente = textDNIBusqueda.getText();
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_MODIFICAR_CLIENTE, dniCliente);
			}
		});
		add(buttonBuscar, "cell 5 3");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 6 1, growx, aligny center");
		
		JLabel label_1 = new JLabel("Nombre: ");
		add(label_1, "cell 1 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		add(textNombre, "cell 2 6 2 1,growx");
		
		JLabel label_2 = new JLabel("Apellidos: ");
		add(label_2, "cell 5 6,alignx trailing");
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		textApellidos.setColumns(10);
		add(textApellidos, "cell 6 6,growx");
		
		JLabel label_3 = new JLabel("Dirección: ");
		add(label_3, "cell 1 8,alignx trailing");
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		add(textDireccion, "cell 2 8 2 1,growx");
		
		JLabel label_4 = new JLabel("Telefono: ");
		add(label_4, "cell 5 8,alignx trailing");
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		add(textTelefono, "cell 6 8,growx");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 10 6 1,growx,aligny center");
		
		JButton btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferCliente cliente = new TransferCliente();
				
				if ( !textApellidos.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& !textDireccion.getText().equals("")
						&& !textTelefono.getText().equals("")) {
					
					cliente.setNombre(textNombre.getText());
					cliente.setDireccion(textDireccion.getText());
					
					String[] apellidos = textApellidos.getText().split(" ");
					
					if ( apellidos.length < 1 ) {
						JOptionPane.showConfirmDialog(null, "No ha introducido los apellidos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						if ( apellidos.length >= 1 )
							cliente.setPrimerApellido(apellidos[0]);
						else if (apellidos.length == 2)
							cliente.setSegundoApellido(apellidos[1]);
						
						
						try {
							cliente.setNumTelefono( Integer.valueOf(textTelefono.getText()) );
						}
						catch(NumberFormatException nu) {
							JOptionPane.showConfirmDialog(null, "El teléfono contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_CLIENTE, cliente);
					}
				}
				else {
					JOptionPane.showConfirmDialog(null, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnModificarCliente, "cell 6 11");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(Object datos) {
		
	}
}