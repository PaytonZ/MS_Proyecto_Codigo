/**
 * 
 */
package presentacion.habitaciones.paneles;

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
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelBajaHabitaciones extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField txtDni;
	private JTextField textNombre;
	private Integer idCliente;
	private JButton btnBorrarHab;
	
	private JPanel contentPane;
	
	public PanelBajaHabitaciones() {
		
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][15.00][][13.00][][][][]"));
		
		contentPane = this;
		
		JLabel lblBajaHab = new JLabel("Baja habitaciones");
		add(lblBajaHab, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblNumHab = new JLabel("Número de habitación: ");
		add(lblNumHab, "cell 2 4,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		add(textDNIBusqueda, "cell 3 4 3 1,growx");
		textDNIBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniCliente = textDNIBusqueda.getText();
				
				if ( !"".equals(dniCliente) ) {
					
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_BORRAR, dniCliente);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede ser vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 6 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx,aligny center");
		
		btnBorrarHab = new JButton("Borrar habitación");
		btnBorrarHab.setEnabled(false);
		btnBorrarHab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idCliente != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_CLIENTE, idCliente);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al cargar el cliente, búsquelo otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblDni_1 = new JLabel("DNI: ");
		add(lblDni_1, "cell 2 7,alignx right");
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		add(txtDni, "cell 3 7,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 5 7,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 6 7,growx");
		textNombre.setColumns(10);
		add(btnBorrarHab, "cell 5 12 2 1");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( datos instanceof TransferCliente) {
			
			TransferCliente cliente = (TransferCliente) datos;
			
			if ( cliente != null ) {
				idCliente = cliente.getID();
				txtDni.setText(cliente.getDNI());
				textNombre.setText(cliente.getNombre());
				btnBorrarHab.setEnabled(true);
			}
		}
		else if ( datos instanceof Boolean ) {
			
			Boolean correcto = (Boolean) datos;
			
			if ( correcto ) {
				textDNIBusqueda.setText("");
				idCliente = null;
				txtDni.setText("");
				textNombre.setText("");
				btnBorrarHab.setEnabled(false);
				
				JOptionPane.showMessageDialog(this, "El cliente se ha borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "El cliente no se ha borrado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}