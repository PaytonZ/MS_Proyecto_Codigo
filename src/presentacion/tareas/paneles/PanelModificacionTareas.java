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
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelModificacionTareas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textNombreBusqueda;
	private JTextField textNombre;
	private Integer idTarea;
	private JButton btnModificarTarea;
	
	private JPanel contentPane;
	private JTextField textDescripcion;
	
	public PanelModificacionTareas() {
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][]"));
		
		contentPane = this;
		
		JLabel lblConsultaClientes = new JLabel("Modificar tareas");
		add(lblConsultaClientes, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblNom = new JLabel("Nombre: ");
		add(lblNom, "cell 2 4,alignx trailing");
		
		textNombreBusqueda = new JTextField();
		add(textNombreBusqueda, "cell 3 4,growx");
		textNombreBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniEmpleado = textNombreBusqueda.getText();
				
				if ( !"".equals(dniEmpleado) ) {
					
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TAREAS_V_MODIFICAR, dniEmpleado);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede ser vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
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
		
		btnModificarTarea = new JButton("Modificar tarea");
		btnModificarTarea.setEnabled(false);
		btnModificarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idTarea != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_TAREA, idTarea);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al cargar la tarea, búsquelo otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblDescripcin = new JLabel("Descripción: ");
		add(lblDescripcin, "cell 5 6,alignx trailing");
		
		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		add(textDescripcion, "cell 6 6,growx");
		textDescripcion.setColumns(10);
		add(btnModificarTarea, "cell 6 9");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_MODIFICAR_TAREA == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textNombreBusqueda.setText("");
					idTarea = null;
					textNombre.setText("");
					textNombre.setEditable(false);
					textDescripcion.setText("");
					textDescripcion.setEditable(false);
					
					btnModificarTarea.setEnabled(false);
					
					JOptionPane.showMessageDialog(contentPane, "La tarea se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "La tarea no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_TAREAS_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof Tarea) {
				
				Tarea tarea = (Tarea) datos;
				
				idTarea = tarea.getId();
				textNombre.setText(tarea.getNombre());
				textNombre.setEditable(true);
				textDescripcion.setText(tarea.getDescripcion());
				textDescripcion.setEditable(true);
				btnModificarTarea.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_MODIFICAR_TAREA == idEvento || IDEventos.ERROR_CONSULTAR_TAREAS_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}