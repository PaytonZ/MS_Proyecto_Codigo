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
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelBajaDepartamentos extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textNombreBusqueda;
	private JTextField textNombre;
	private Integer idDepartamento;
	private JButton btnBorrarCliente;
	
	private JPanel contentPane;
	
	public PanelBajaDepartamentos() {
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][][][][]"));
		
		contentPane = this;
		
		JLabel lblConsultaClientes = new JLabel("Baja departamentos");
		add(lblConsultaClientes, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("Nombre: ");
		add(lblDni, "cell 2 4,alignx trailing");
		
		textNombreBusqueda = new JTextField();
		add(textNombreBusqueda, "cell 3 4,growx");
		textNombreBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreDepartamento = textNombreBusqueda.getText();
				
				if ( !"".equals(nombreDepartamento) ) {
					
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_DEPARTAMENTO_V_BORRAR, nombreDepartamento);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo nombre no puede ser vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
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
		
		btnBorrarCliente = new JButton("Borrar departamento");
		btnBorrarCliente.setEnabled(false);
		btnBorrarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idDepartamento != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_CLIENTE, idDepartamento);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al cargar el departamento, búsquelo otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btnBorrarCliente, "cell 6 13");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_BAJA_CLIENTE == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textNombreBusqueda.setText("");
					idDepartamento = null;
					textNombre.setText("");
					btnBorrarCliente.setEnabled(false);
					
					JOptionPane.showMessageDialog(contentPane, "El departamento se ha borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "El departamento no se ha borrado correctamente, compruebe que no tiene empleados", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_CLIENTE_V_BORRAR == idEvento ) {
			
			if ( datos instanceof Departamento) {
				
				Departamento departamento = (Departamento) datos;
				
				idDepartamento = departamento.getID();
				textNombre.setText(departamento.getNombre());
				btnBorrarCliente.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_BAJA_CLIENTE == idEvento || IDEventos.ERROR_CONSULTAR_CLIENTE_V_BORRAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}