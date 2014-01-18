/**
 * 
 */
package presentacion.departamentos.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
import negocio.departamentos.objetonegocio.Departamento;
import negocio.excepciones.BSoDException;
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
public class PanelConsultaDepartamento extends JPanel implements GUIPanelesInterfaz {


	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField textNombre;
	
	public PanelConsultaDepartamento() {
		
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][]"));
		
		JLabel lblConsultaClientes = new JLabel("Consulta departamentos");
		add(lblConsultaClientes, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("Nombre: ");
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
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_DEPARTAMENTO, dniCliente);
			}
		});
		add(btnBuscar, "cell 5 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx,aligny center");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 2 6,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 3 6,growx");
		textNombre.setColumns(10);
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_DEPARTAMENTO == idEvento ) {
		
			if ( datos instanceof Departamento) {
				
				Departamento departamento = (Departamento) datos;
				
				if ( departamento != null ) {
					textNombre.setText(departamento.getNombre());
				}
					
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener el departamento", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(this, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}