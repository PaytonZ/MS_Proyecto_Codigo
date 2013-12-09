package presentacion.clientes.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;



import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.clientes.GUIInterfazClientes;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

public class PanelAltaClientes extends JPanel implements GUIInterfazClientes {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textDNI;

	/**
	 * Create the panel.
	 */
	public PanelAltaClientes() {
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta clientes");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 8 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 9 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 0 3,alignx right,aligny center");
		
		textDNI = new JTextField();
		add(textDNI, "cell 2 3,growx");
		textDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 5,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 2 5,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 5 5,alignx left,aligny center");
		
		textApellidos = new JTextField();
		add(textApellidos, "cell 6 5 3 1,growx,aligny top");
		textApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección: ");
		add(lblDireccin, "cell 0 7,alignx right,aligny center");
		
		textDireccion = new JTextField();
		add(textDireccion, "cell 2 7,growx,aligny top");
		textDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		add(lblTelefono, "cell 5 7,growx,aligny center");
		
		textTelefono = new JTextField();
		add(textTelefono, "cell 6 7 2 1,growx,aligny top");
		textTelefono.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 10 8 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferCliente cliente = new TransferCliente();
				
				if ( !textDNI.getText().equals("") 
						&& !textApellidos.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& !textDireccion.getText().equals("")
						&& !textTelefono.getText().equals("")) {
					
					cliente.setDNI(textDNI.getText());
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
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_CLIENTE, cliente);
					}
				}
				else {
					JOptionPane.showConfirmDialog(null, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnAceptar, "cell 7 11,alignx left,aligny top");
	}

	@Override
	public void actualizarVentana(Object datos) {
		
		if ( datos == null) {
			
			JOptionPane.showConfirmDialog(this, "Error al dar de alta un cliente", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if ( datos instanceof Integer ) {
			
			JOptionPane.showConfirmDialog(this, "Cliente creado correctamente", "Aviso", JOptionPane.PLAIN_MESSAGE);

			textDNI.setText("");
			textApellidos.setText("");
			textNombre.setText("");
			textDireccion.setText("");
			textTelefono.setText("");
		}
		else {
			
			BSoDException bsod = (BSoDException) datos;
			
			JOptionPane.showConfirmDialog(this, bsod.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
