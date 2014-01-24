/**
 * 
 */
package presentacion.tareas.paneles;

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
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelConsultaTarea extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textNombreBusqueda;
	private JTextField textNombre;
	private JTextField textDescripcion;
	
	public PanelConsultaTarea() {
		
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00]"));
		
		JLabel lblConsultaTareas = new JLabel("Consulta tareas");
		add(lblConsultaTareas, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 8 1,growx,aligny center");
		
		JLabel lblNmb = new JLabel("Nombre: ");
		add(lblNmb, "cell 2 4,alignx trailing");
		
		textNombreBusqueda = new JTextField();
		add(textNombreBusqueda, "cell 3 4,growx");
		textNombreBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombreTarea = textNombreBusqueda.getText().trim();
				
				if ( !nombreTarea.equals("")) {
				
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TAREA, nombreTarea);
				}
				else {
					JOptionPane.showMessageDialog(null, "El campo nombre no puede quedar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		add(lblDescripcin, "cell 5 6,alignx trailing");
		
		textDescripcion = new JTextField();
		add(textDescripcion, "cell 6 6,growx");
		textDescripcion.setColumns(10);
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_TAREA == idEvento ) {
		
			if ( datos instanceof Tarea) {
				
				Tarea tarea = (Tarea) datos;
				
				textNombre.setText(tarea.getNombre());
				textDescripcion.setText(tarea.getDescripcion());
					
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener la tarea", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_TAREA == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(this, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}