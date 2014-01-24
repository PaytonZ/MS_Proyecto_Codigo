/**
 * 
 */
package presentacion.empleados.paneles;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.empleados.objetonegocio.Empleado;
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
public class PanelAltaTareaEmpleados extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textDNIBusqueda;
	private JTextField txtDni;
	private JTextField textNombre;
	private JTextField textApellidos;
	
	private Empleado emp;
	
	private List<Tarea> tareasEmpleado;
	private JList<Tarea> listaTareasAsignadas;
	private JList<Tarea> listaTareasDisponibles;
	
	public PanelAltaTareaEmpleados() {
		
		setLayout(new MigLayout("", "[24.00][][grow][39.00][36.00][][grow][]", "[23.00][17.00][][20.00][][13.00][][24.00][][][][][grow]"));
		
		JLabel lblConsultaClientes = new JLabel("Asignar tareas empleados");
		add(lblConsultaClientes, "cell 0 0 8 1,alignx center,aligny bottom");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 8 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 1 2,alignx trailing");
		
		textDNIBusqueda = new JTextField();
		add(textDNIBusqueda, "cell 2 2,growx");
		textDNIBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dniEmpleado = textDNIBusqueda.getText().trim();
				
				if ( !dniEmpleado.equals("")) {
				
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_EMPLEADO_V_ASIGARTAREA, dniEmpleado);
				}
				else {
					JOptionPane.showMessageDialog(null, "El campo DNI no puede quedar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 5 2");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 3 8 1,growx,aligny center");
		
		JLabel lblDni_1 = new JLabel("DNI: ");
		add(lblDni_1, "cell 1 4,alignx right");
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		add(txtDni, "cell 2 4,growx");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 4 4,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		add(textNombre, "cell 5 4 2 1,growx");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 1 6,alignx right");
		
		textApellidos = new JTextField();
		textApellidos.setEditable(false);
		add(textApellidos, "cell 2 6,growx");
		textApellidos.setColumns(10);
		
		JButton btnAsignarTareas = new JButton("Asignar tareas");
		btnAsignarTareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				tareasEmpleado = new ArrayList<Tarea>();
				if ( listaTareasAsignadas.getModel().getSize() > 0) {
					
					for (int i = 0; i < listaTareasAsignadas.getModel().getSize(); i++) {
						tareasEmpleado.add(listaTareasAsignadas.getModel().getElementAt(i));
					}
				}
				
				//emp.addTareas(tareasEmpleado);
				
				ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ASIGNARTAREA_EMPLEADO, emp);
			}
		});
		btnAsignarTareas.setEnabled(false);
		add(btnAsignarTareas, "cell 6 6,alignx right");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 0 7 8 1,growx,aligny center");
		
		JLabel lblTareasDisponibles = new JLabel("Tareas disponibles");
		add(lblTareasDisponibles, "cell 1 8 2 1,alignx center");
		
		JLabel lblTareasAsignadas = new JLabel("Tareas asignadas");
		add(lblTareasAsignadas, "cell 5 8 2 1,alignx center");
		
		ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
		//controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TAREAS_V_ASIGARTAREA, null);

		/*
		Tarea c = new Tarea();
		c.setNombre("c");
		
		Tarea d = new Tarea();
		d.setNombre("d");
		
		Tarea e = new Tarea();
		e.setNombre("e");
		
		DefaultListModel<Tarea> tt = new DefaultListModel<>();
		tt.addElement(c);
		tt.addElement(d);
		tt.addElement(e);*/
		
		ScrollPane scroll = new ScrollPane();
		scroll.setPreferredSize(new Dimension(20, 20));
		scroll.setMinimumSize(new Dimension(20, 20));
		
		listaTareasDisponibles = new JList<Tarea>();
		listaTareasDisponibles.setModel(new DefaultListModel<Tarea>());
		listaTareasDisponibles.setEnabled(false);
		
		scroll.add(listaTareasDisponibles);
		
		add(scroll, "cell 1 9 3 4,grow");
		
		/*Tarea a = new Tarea();
		a.setNombre("a");
		
		Tarea b = new Tarea();
		b.setNombre("b");
		
		DefaultListModel<Tarea> t = new DefaultListModel<>();
		t.addElement(a);
		t.addElement(b);*/

		ScrollPane scroll2 = new ScrollPane();
		scroll2.setMinimumSize(new Dimension(20, 20));
		scroll2.setPreferredSize(new Dimension(20, 20));
		
		listaTareasAsignadas = new JList<Tarea>();
		listaTareasAsignadas.setModel(new DefaultListModel<Tarea>());
		listaTareasAsignadas.setEnabled(false);
		
		scroll2.add(listaTareasAsignadas);
		
		add(scroll2, "cell 5 9 2 4,grow");
		
		JButton btnAnadir = new JButton(">>");
		btnAnadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				List<Tarea> listaTar = listaTareasDisponibles.getSelectedValuesList();
				
				for ( Tarea tarea : listaTar ) {
					
					((DefaultListModel<Tarea>) listaTareasAsignadas.getModel()).addElement(tarea);;
					((DefaultListModel<Tarea>) listaTareasDisponibles.getModel()).removeElement(tarea);
				}
				
			}
		});
		add(btnAnadir, "cell 4 10");
		
		JButton btnQuitar = new JButton("<<");
		btnQuitar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				List<Tarea> listaAsig = listaTareasAsignadas.getSelectedValuesList();
				
				for ( Tarea tarea : listaAsig ) {
					
					((DefaultListModel<Tarea>) listaTareasDisponibles.getModel()).addElement(tarea);
					((DefaultListModel<Tarea>) listaTareasAsignadas.getModel()).removeElement(tarea);
				}
				
			}
		});
		add(btnQuitar, "cell 4 11");
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unchecked")
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ASIGNARTAREA_EMPLEADO == idEvento) {
			
			if ( datos instanceof Boolean && (Boolean) datos) {
			
				((DefaultListModel<Tarea>)listaTareasDisponibles.getModel()).removeAllElements();
				((DefaultListModel<Tarea>)listaTareasAsignadas.getModel()).removeAllElements();
				
				listaTareasDisponibles.setEnabled(false);
				listaTareasAsignadas.setEnabled(false);
				
				JOptionPane.showMessageDialog(this, "Las tareas se asignaron al empleado", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo asignar las tareas", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (IDEventos.EVENTO_CONSULTAR_TAREAS_V_ASIGARTAREA == idEvento) {
			
			if ( datos instanceof List) {
				
				List<Tarea> lista = (List<Tarea>) datos;
				
				DefaultListModel<Tarea> model = (DefaultListModel<Tarea>)listaTareasDisponibles.getModel();
				
				model.removeAllElements();
				
				for ( Tarea tarea : lista ) {
					
					model.addElement(tarea);
				}
				
				listaTareasDisponibles.setModel(model);
				
				listaTareasDisponibles.setEnabled(true);
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_EMPLEADO_V_ASIGARTAREA == idEvento) {
			
			if ( datos instanceof Empleado) {
				
				emp = (Empleado) datos;
				
				txtDni.setText(emp.getDNI());
				textNombre.setText(emp.getNombre());
				textApellidos.setText(emp.getPrimerApellido() + " " + emp.getSegundoApellido());
				
				//tareasEmpleado = emp.getTareas();
				
				DefaultListModel<Tarea> model = (DefaultListModel<Tarea>)listaTareasAsignadas.getModel();
				
				model.removeAllElements();
				
				for ( Tarea tarea : tareasEmpleado ) {
					model.addElement(tarea);
				}
				
				listaTareasAsignadas.setModel(model);
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener el empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		/*else if ( IDEventos.EVENTO_CONSULTAR_TAREAEMPLEADO_V_EMPLEADO_ASIGARTAREA == idEvento ) {
		
			if ( datos instanceof List) {
				
				tareasEmpleado = (List<Tarea>) datos;
				
				DefaultListModel<Tarea> model = (DefaultListModel<Tarea>)listaTareasAsignadas.getModel();
				
				model.removeAllElements();
				
				for ( Tarea tarea : tareasEmpleado ) {
					model.addElement(tarea);
				}
				
				listaTareasAsignadas.setModel(model);
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener las tareas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}*/
		else if ( IDEventos.ERROR_CONSULTAR_EMPLEADO_V_ASIGARTAREA == idEvento
				//|| IDEventos.ERROR_CONSULTAR_TAREAEMPLEADO_V_EMPLEADO_ASIGARTAREA == idEvento
				|| IDEventos.ERROR_ASIGNARTAREA_EMPLEADO == idEvento
				|| IDEventos.ERROR_CONSULTAR_TAREAS_V_ASIGARTAREA == idEvento) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(this, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}