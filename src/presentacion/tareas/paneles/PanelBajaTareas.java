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
public class PanelBajaTareas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textNombreBusqueda;
	private JTextField textNombre;
	private JTextField textDescripcion;
	private Integer idTarea;
	private JButton btnBorrarTarea;
	
	private JPanel contentPane;
	
	public PanelBajaTareas() {
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][]"));
		
		contentPane = this;
		
		JLabel lblConsultaClientes = new JLabel("Baja tareas");
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
				
				String nombreTarea = textNombreBusqueda.getText();
				
				if ( !"".equals(nombreTarea) ) {
					
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TAREAS_V_BORRAR, nombreTarea);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo nombre no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		
		JLabel lblDesc = new JLabel("Descripción: ");
		add(lblDesc, "cell 5 6,alignx trailing");
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		add(textDescripcion, "cell 6 6,growx");
		textDescripcion.setColumns(10);
		
		btnBorrarTarea = new JButton("Borrar tarea");
		btnBorrarTarea.setEnabled(false);
		btnBorrarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idTarea != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_TAREA, idTarea);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al borrar la tarea, búsquela otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btnBorrarTarea, "cell 6 9");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_BAJA_TAREA == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textNombreBusqueda.setText("");
					idTarea = null;
					textNombre.setText("");
					textDescripcion.setText("");
					btnBorrarTarea.setEnabled(false);
					
					JOptionPane.showMessageDialog(contentPane, "La tarea se ha borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "La tarea no se ha borrado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_TAREAS_V_BORRAR == idEvento ) {
			
			if ( datos instanceof Tarea) {
				
				Tarea tarea = (Tarea) datos;
				
				idTarea = tarea.getId();
				textNombre.setText(tarea.getNombre());
				textDescripcion.setText(tarea.getDescripcion());
				btnBorrarTarea.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_BAJA_TAREA == idEvento || IDEventos.ERROR_CONSULTAR_TAREAS_V_BORRAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}