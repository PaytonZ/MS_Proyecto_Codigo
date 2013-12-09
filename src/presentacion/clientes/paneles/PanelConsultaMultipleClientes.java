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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import presentacion.clientes.GUIInterfazClientes;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelConsultaMultipleClientes extends JPanel implements GUIInterfazClientes {

	private static final long serialVersionUID = 1L;
	
	private JList<TransferCliente> list;
	
	public PanelConsultaMultipleClientes() {
		
		setLayout(new BorderLayout(0, 0));

		list = new JList<TransferCliente>();
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMinimumSize(new Dimension(15, 14));
		add(panel, BorderLayout.SOUTH);
		
		LC layoutconstraits = new LC();
		layoutconstraits.fillX();
		
		panel.setLayout(new MigLayout("fillx", "[208.00,right]", "[]"));
		
		JButton btnNewButton = new JButton("Consultar clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE, null);
			}
		});
		panel.add(btnNewButton, "cell 0 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDni = new JLabel("DNI");
		panel_1.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel_1.add(lblApellidos);
		
		JLabel lblDireccin = new JLabel("Dirección");
		panel_1.add(lblDireccin);
		
		JLabel lblTelefono = new JLabel("Telefono");
		panel_1.add(lblTelefono);
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
			System.out.println(((BSoDException) datos).getMensaje() );
		}
		else if ( datos instanceof Boolean ) {
			
			JOptionPane.showConfirmDialog(this, "El cliente se ha borrado correctamente", "Aviso", JOptionPane.PLAIN_MESSAGE);
		}
		else {
			JOptionPane.showConfirmDialog(this, "Error al borrar el cliente", "Error", JOptionPane.PLAIN_MESSAGE);
		}
	}
}