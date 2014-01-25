/**
 * 
 */
package presentacion.tareas.paneles;

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

import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;
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
public class PanelAltaTareas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	
	private JPanel contentPane;
	private JTextField textDescripcion;

	/**
	 * Create the panel.
	 */
	public PanelAltaTareas() {
		
		contentPane = this;
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px,grow][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][19.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta tareas");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 8 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 8 1,growx,aligny center");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 3,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 2 3,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción: ");
		add(lblDescripcin, "cell 4 3,alignx trailing");
		
		textDescripcion = new JTextField();
		add(textDescripcion, "cell 5 3 2 1,growx");
		textDescripcion.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 7 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarea tarea = new Tarea();
				
				if ( !textNombre.getText().equals("")
						&& !textDescripcion.getText().equals("")) {
					
					tarea.setNombre(textNombre.getText());
					tarea.setDescripcion(textDescripcion.getText());
					
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_TAREA, tarea);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnAceptar, "cell 6 6,alignx left,aligny top");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_TAREA == idEvento ) {
		
			if ( datos instanceof Tarea ) {
				
				JOptionPane.showMessageDialog(contentPane, "Tarea creada correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	
				textNombre.setText("");
				textDescripcion.setText("");
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al dar de alta una tarea", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_ALTA_TAREA == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}