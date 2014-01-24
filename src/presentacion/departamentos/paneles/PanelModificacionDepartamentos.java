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
public class PanelModificacionDepartamentos extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	private JTextField textNombreBusqueda;
	private JTextField textNombre;
	private Integer idDepartamento;
	
	private JPanel contentPane;
	
	public PanelModificacionDepartamentos() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][][60.00,grow][][36.00][][grow][]", "[][][][][18.00][17.00][][10.00][13.00][]"));
		
		JLabel lblModificacinDeClientes = new JLabel("Modificación de departamentos");
		add(lblModificacinDeClientes, "cell 0 0 7 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 6 1, growx, aligny center");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 1 3,alignx trailing");
		
		textNombreBusqueda = new JTextField();
		textNombreBusqueda.setColumns(10);
		add(textNombreBusqueda, "cell 2 3 2 1,growx");
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textNombreBusqueda.setEditable(false);
				
				String nombreDepartamento = textNombreBusqueda.getText().trim();
				
				if ( !nombreDepartamento.equals("")) {
				
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_DEPARTAMENTO_V_MODIFICAR, nombreDepartamento);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se puede dejar el campo nombre vacío", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(buttonBuscar, "cell 5 3");
		
		JButton btnNuevaBsqueda = new JButton("Nueva búsqueda");
		btnNuevaBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				idDepartamento = null;
				textNombreBusqueda.setText("");
				textNombreBusqueda.setEditable(true);
				textNombre.setText("");
				textNombre.setEditable(false);
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
		
		JButton btnModificarCliente = new JButton("Modificar departamento");
		btnModificarCliente.setEnabled(false);
		btnModificarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textNombreBusqueda.setEditable(false);
				
				Departamento departamento = new Departamento();
				
				if ( idDepartamento != null 
						&& !textNombreBusqueda.getText().equals("")
						&& !textNombre.getText().equals("")) {
					
					departamento.setNombre(textNombre.getText());
						
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_DEPARTAMENTO, departamento);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 8 7 1,growx,aligny center");
		add(btnModificarCliente, "cell 6 9");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_MODIFICAR_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textNombreBusqueda.setText("");
					textNombreBusqueda.setEditable(true);
					textNombre.setText("");
					textNombre.setEditable(true);
					
					JOptionPane.showMessageDialog(contentPane, "El departamento se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "El departamento no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				idDepartamento = null;
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_DEPARTAMENTO_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof Departamento) {
				
				Departamento departamento = (Departamento) datos;
					
				idDepartamento = departamento.getID();
				textNombre.setText(departamento.getNombre());
				textNombre.setEditable(true);
				
			}
		}
		else if ( IDEventos.ERROR_MODIFICAR_DEPARTAMENTO == idEvento || IDEventos.ERROR_CONSULTAR_DEPARTAMENTO_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}