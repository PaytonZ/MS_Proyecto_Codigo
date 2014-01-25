package presentacion.empleados.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import negocio.empleados.objetonegocio.Empleado;
import negocio.excepciones.BSoDException;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class PanelConsultaEmpleadosPorTarea extends JPanel implements GUIPanelesInterfaz {


	private static final long serialVersionUID = 1L;
	
	private JList<Empleado> list;
	
	private JPanel contentPane;
	private JTextField textNombreTarea;
	
	public PanelConsultaEmpleadosPorTarea() {
		
		contentPane = this;
		
		setLayout(new BorderLayout(0, 0));

		list = new JList<Empleado>();
		
		JPanel panelTarea = new JPanel();
		
		add(panelTarea, BorderLayout.NORTH);
		panelTarea.setLayout(new MigLayout("", "[225.00px,grow][264.00,grow][264.00,grow]", "[14px][7.00][13.00][]"));
		
		JLabel lblConsultaEmpleadosPor = new JLabel("Consulta empleados por tarea");
		panelTarea.add(lblConsultaEmpleadosPor, "cell 0 0 3 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		panelTarea.add(separator, "cell 0 2 3 1,growx,aligny center");
		
		JLabel lblNombreTarea = new JLabel("Nombre tarea: ");
		panelTarea.add(lblNombreTarea, "cell 0 3,alignx trailing");
		
		textNombreTarea = new JTextField();
		panelTarea.add(textNombreTarea, "cell 1 3,growx");
		textNombreTarea.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		panelTarea.add(btnBuscar, "cell 2 3,alignx center");
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
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
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_EMPLEADOS, null);
			}
		});
		panel.add(btnNewButton, "cell 0 1,alignx center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblDni = new JLabel("DNI");
		panel_1.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		panel_1.add(lblApellidos);
		
		JLabel lblTipo = new JLabel("Tipo");
		panel_1.add(lblTipo);
		
		JPanel panelLista = new JPanel();
		panelLista.setLayout(new BorderLayout());
		
		panelLista.add(panel_1, BorderLayout.NORTH);
		panelLista.add(scrollPane, BorderLayout.CENTER);
		add(panelLista, BorderLayout.CENTER);
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_TODOS_EMPLEADOS == idEvento ) {
			
			if ( datos instanceof List) {
				
				@SuppressWarnings("unchecked")
				List<Empleado> listaEmpleados = (List<Empleado>) datos;
				
				Empleado[] empleados = new Empleado[listaEmpleados.size()];
				listaEmpleados.toArray(empleados);
				
				list.setListData(empleados);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se pudieron recuperar los empleados", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_TODOS_EMPLEADOS == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
