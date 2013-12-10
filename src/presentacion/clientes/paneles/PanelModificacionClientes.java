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
	private JTextField textSegundoApellido;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private Integer idCliente;
	private JTextField textPrimerApellido;
	
	private JPanel contentPane;
	
	public PanelModificacionClientes() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][][60.00,grow][][36.00][][grow][]", "[][][][][18.00][17.00][][10.00][][9.00][][16.00][13.00][]"));
		
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
				
				textDNIBusqueda.setEditable(false);
				
				String dniCliente = textDNIBusqueda.getText();
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR, dniCliente);
			}
		});
		add(buttonBuscar, "cell 5 3");
		
		JButton btnNuevaBsqueda = new JButton("Nueva búsqueda");
		btnNuevaBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				idCliente = null;
				textDNIBusqueda.setText("");
				textDNIBusqueda.setEditable(true);
				textNombre.setText("");
				textNombre.setEditable(false);
				textPrimerApellido.setText("");
				textPrimerApellido.setEditable(false);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(false);
				textDireccion.setText("");
				textDireccion.setEditable(false);
				textTelefono.setText("");
				textTelefono.setEditable(false);
			}
		});
		add(btnNuevaBsqueda, "cell 6 3");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 6 1, growx, aligny center");
		
		JLabel label_1 = new JLabel("Nombre: ");
		add(label_1, "cell 1 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		add(textNombre, "cell 2 6 2 1,growx");
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 5 6,alignx trailing");
		
		textPrimerApellido = new JTextField();
		textPrimerApellido.setEditable(false);
		add(textPrimerApellido, "cell 6 6,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel label_3 = new JLabel("Dirección: ");
		add(label_3, "cell 1 8,alignx trailing");
		
		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		add(textDireccion, "cell 2 8 2 1,growx");
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido: ");
		add(lblSegundoApellido, "cell 5 8,alignx trailing");
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setToolTipText("Más de dos apellidos serán ingonrados.");
		textSegundoApellido.setEditable(false);
		textSegundoApellido.setColumns(10);
		add(textSegundoApellido, "cell 6 8,growx");
		
		JLabel label_4 = new JLabel("Telefono: ");
		add(label_4, "cell 5 10,alignx trailing");
		
		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		add(textTelefono, "cell 6 10,growx");
		
		JButton btnModificarCliente = new JButton("Modificar cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textDNIBusqueda.setEditable(false);
				
				TransferCliente cliente = new TransferCliente();
				
				if ( idCliente != null 
						&& !textDNIBusqueda.getText().equals("")
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& !textDireccion.getText().equals("")
						&& !textTelefono.getText().equals("")) {
					
					cliente.setDNI(textDNIBusqueda.getText());
					cliente.setNombre(textNombre.getText());
					cliente.setDireccion(textDireccion.getText());
					
					if ( textPrimerApellido.getText().equals("") ) {
						JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						cliente.setPrimerApellido(textPrimerApellido.getText().trim());
						if ( !textSegundoApellido.getText().equals("") )
							cliente.setSegundoApellido(textSegundoApellido.getText().trim());
						
						
						try {
							cliente.setNumTelefono( Integer.valueOf(textTelefono.getText()) );
						}
						catch(NumberFormatException nu) {
							JOptionPane.showMessageDialog(contentPane, "El teléfono contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_CLIENTE, cliente);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 12 7 1,growx,aligny center");
		add(btnModificarCliente, "cell 6 13");
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
				
				idCliente = cliente.getID();
				textNombre.setText(cliente.getNombre());
				textNombre.setEditable(true);
				textPrimerApellido.setText(cliente.getPrimerApellido());
				textPrimerApellido.setEditable(true);
				textSegundoApellido.setText(cliente.getSegundoApellido());
				textSegundoApellido.setEditable(true);
				textDireccion.setText(cliente.getDireccion());
				textDireccion.setEditable(true);
				textTelefono.setText( String.valueOf(cliente.getNumTelefono()) );
				textTelefono.setEditable(true);
			}
		}
		else if ( datos instanceof Boolean ) {
			
			Boolean correcto = (Boolean) datos;
			
			if ( correcto ) {
				textDNIBusqueda.setText("");
				textDNIBusqueda.setEditable(true);
				textNombre.setText("");
				textNombre.setEditable(true);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(true);
				textSegundoApellido.setText("");
				textSegundoApellido.setEditable(true);
				textDireccion.setText("");
				textDireccion.setEditable(true);
				textTelefono.setText("");
				textTelefono.setEditable(true);
				
				JOptionPane.showMessageDialog(contentPane, "El cliente se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "El cliente no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
			idCliente = null;
		}
	}
}