/**
 * 
 */
package presentacion.empleados.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.objetonegocio.EmpleadoParcial;
import negocio.empleados.objetonegocio.EmpleadoTotal;
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
public class PanelConsultaEmpleados extends JPanel implements
	GUIPanelesInterfaz {

    private static final long serialVersionUID = 1L;

    private JTextField textDNIBusqueda;
    private JTextField txtDni;
    private JTextField textNombre;
    private JTextField textApellidos;

    private Empleado empleado;
    private JTextField textTipo;
    private JTextField textDepartamento;
    private JTextField textPlaza;
    private JTextField textHoras;
    

    private JLabel lblHoras;
    private JLabel lblPlaza;

    public PanelConsultaEmpleados() {

	setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][][13.00][][13.00][][7.00][][]"));

	JLabel lblConsultaClientes = new JLabel("Consulta empleados");
	add(lblConsultaClientes, "cell 0 1 8 1,alignx center");

	JSeparator separator = new JSeparator();
	add(separator, "cell 0 2 8 1,growx,aligny center");

	JLabel lblDni = new JLabel("DNI: ");
	add(lblDni, "cell 2 4,alignx trailing");

	textDNIBusqueda = new JTextField();
	add(textDNIBusqueda, "cell 3 4,growx");
	textDNIBusqueda.setColumns(10);

	JButton btnBuscar = new JButton("Buscar");
	btnBuscar.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		String dniEmpleado = textDNIBusqueda.getText().trim();

		if (!dniEmpleado.equals("")) {

		    ControladorAplicacion controladorAplicacion = ControladorAplicacion
			    .getInstance();
		    controladorAplicacion.handleRequest(
			    IDEventos.EVENTO_CONSULTAR_EMPLEADO, dniEmpleado);
		} else {
		    JOptionPane.showMessageDialog(null,
			    "El campo DNI no puede quedar vacío", "Aviso",
			    JOptionPane.INFORMATION_MESSAGE);
		}
	    }
	});
	add(btnBuscar, "cell 5 4");

	JSeparator separator_1 = new JSeparator();
	add(separator_1, "cell 0 5 8 1,growx,aligny center");

	JLabel lblDni_1 = new JLabel("DNI: ");
	add(lblDni_1, "cell 2 6,alignx right");

	txtDni = new JTextField();
	txtDni.setEditable(false);
	add(txtDni, "cell 3 6,growx");
	txtDni.setColumns(10);

	JLabel lblNombre = new JLabel("Nombre: ");
	add(lblNombre, "cell 2 8,alignx trailing");

	textNombre = new JTextField();
	textNombre.setEditable(false);
	add(textNombre, "cell 3 8,growx");
	textNombre.setColumns(10);

	JLabel lblApellidos = new JLabel("Apellidos: ");
	add(lblApellidos, "cell 5 8,alignx right");

	textApellidos = new JTextField();
	textApellidos.setEditable(false);
	add(textApellidos, "cell 6 8,growx");
	textApellidos.setColumns(10);

	JLabel lblTipo = new JLabel("Tipo: ");
	add(lblTipo, "cell 2 10,alignx trailing");

	textTipo = new JTextField();
	textTipo.setEditable(false);
	add(textTipo, "cell 3 10,growx");
	textTipo.setColumns(10);

	JLabel lblDepartamento = new JLabel("Departamento: ");
	add(lblDepartamento, "cell 5 10,alignx trailing");

	textDepartamento = new JTextField();
	textDepartamento.setEditable(false);
	add(textDepartamento, "cell 6 10,growx");
	textDepartamento.setColumns(10);
	
	lblPlaza = new JLabel("Plaza:");
	lblPlaza.setVisible(false);
	add(lblPlaza, "cell 2 12,alignx trailing");
	
	textPlaza = new JTextField();
	textPlaza.setEnabled(false);
	textPlaza.setEditable(false);
	textPlaza.setVisible(false);
	add(textPlaza, "cell 3 12,growx");
	textPlaza.setColumns(10);
	
	lblHoras = new JLabel("Horas:");
	lblHoras.setVisible(false);
	add(lblHoras, "cell 5 12,alignx trailing");
	
	textHoras = new JTextField();
	textHoras = new JTextField();
	textHoras.setEnabled(false);
	textHoras.setEditable(false);
	textHoras.setVisible(false);
	add(textHoras, "cell 6 12,growx");
	textHoras.setColumns(10);
    }

    /**
     * (sin Javadoc)
     * 
     * @see GUIInterfazClientes#actualizarVentana(Object datos)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void actualizarVentana(IDEventos idEvento, Object datos) {

	if (IDEventos.EVENTO_CONSULTAR_EMPLEADO == idEvento) {

	    if (datos instanceof Empleado) {

		empleado = (Empleado) datos;
		
		 textHoras.setVisible(false);
		 lblHoras.setVisible(false);
		 lblPlaza.setVisible(false);
		  textPlaza.setVisible(false);
		 
		txtDni.setText(empleado.getDNI());
		textNombre.setText(empleado.getNombre());
		textApellidos.setText(empleado.getPrimerApellido() + " "
			+ empleado.getSegundoApellido());
		textTipo.setText(empleado.getTipo().name());
		textDepartamento
			.setText(empleado.getDepartamento().getNombre());
		
		if (empleado instanceof EmpleadoParcial) {

		    textHoras.setVisible(true);
		    textHoras.setEnabled(true);
		    lblHoras.setVisible(true);
		    textHoras
			    .setText((String
				    .valueOf((((EmpleadoParcial) empleado)
					    .getHoras()))));

		}
		if (empleado instanceof EmpleadoTotal) {
		    textPlaza.setVisible(true);
		    textPlaza.setEnabled(true);
		    lblPlaza.setVisible(true);
		    textPlaza.setText(((EmpleadoTotal) empleado)
			    .getPlazaAparcamiento().name());

		}

	    } else {
		JOptionPane.showMessageDialog(this,
			"No se pudo obtener el empleado", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }
	} else if (IDEventos.ERROR_CONSULTAR_EMPLEADO == idEvento) {

	    if (datos instanceof BSoDException) {

		JOptionPane.showMessageDialog(this,
			((BSoDException) datos).getMensaje(), "Error",
			JOptionPane.ERROR_MESSAGE);
	    } else {

		JOptionPane.showMessageDialog(this, "Error genérico", "Error",
			JOptionPane.ERROR_MESSAGE);
	    }
	}
    }
}