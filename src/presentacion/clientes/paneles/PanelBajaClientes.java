/**
 * 
 */
package presentacion.clientes.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

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
public class PanelBajaClientes extends JPanel implements GUIInterfazClientes {
	private static final long serialVersionUID = 1L;
	public PanelBajaClientes() {
		
		setLayout(new BorderLayout(0, 0));
		
		ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
		controladorAplicacion.handleRequest(IDEventos.EVENTO_OBTENER_TODOS_CLIENTE, null);
		
		ListModel<TransferCliente> model = new DefaultListModel<>();
		
		final JList<TransferCliente> list = new JList<>();
		
		add(list, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		panel.setMinimumSize(new Dimension(15, 14));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new MigLayout("", "[][][][][][][][][]", "[][]"));
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.getSelectedIndices();
				
			}
		});
		panel.add(btnNewButton, "cell 8 1");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}