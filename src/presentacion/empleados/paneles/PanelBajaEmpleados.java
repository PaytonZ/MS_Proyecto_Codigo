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
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;
import javax.swing.JCheckBox;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelBajaEmpleados extends JPanel implements GUIPanelesInterfaz {

    private static final long serialVersionUID = 1L;

    private JTextField textDNIBusqueda;
    private JTextField txtDni;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textTipo;
    private Empleado empleado;
    private JButton btnBorrarCliente;

    private JPanel contentPane;

    public PanelBajaEmpleados() {
	setLayout(new MigLayout("", "[][][][grow][][][grow][]",
		"[][][17.00][][][20.00][][13.00][][13.00][][]"));

	contentPane = this;

	JLabel lblConsultaClientes = new JLabel("Baja empleados");
	add(lblConsultaClientes, "cell 0 1 8 1,alignx center");

	JSeparator separator = new JSeparator();
	add(separator, "cell 0 2 7 1,growx,aligny center");

	JLabel lblDni = new JLabel("DNI: ");
	add(lblDni, "cell 2 4,alignx trailing");

	textDNIBusqueda = new JTextField();
	add(textDNIBusqueda, "cell 3 4,growx");
	textDNIBusqueda.setColumns(10);

	JButton btnBuscar = new JButton("Buscar");
	btnBuscar.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {

		String dniEmpleado = textDNIBusqueda.getText();

		if (!"".equals(dniEmpleado)) {

		    ControladorAplicacion controladorAplicacion = ControladorAplicacion
			    .getInstance();
		    controladorAplicacion.handleRequest(
			    IDEventos.EVENTO_CONSULTAR_EMPLEADOS_V_BORRAR,
			    dniEmpleado);
		} else {
		    JOptionPane.showMessageDialog(contentPane,
			    "El campo DNI no puede ser vacío", "Aviso",
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
	add(lblNombre, "cell 5 6,alignx trailing");

	textNombre = new JTextField();
	textNombre.setEditable(false);
	add(textNombre, "cell 6 6,growx");
	textNombre.setColumns(10);

	JLabel lblApellidos = new JLabel("Apellidos: ");
	add(lblApellidos, "cell 2 8,alignx right");

	textApellidos = new JTextField();
	textApellidos.setEditable(false);
	add(textApellidos, "cell 3 8,growx");
	textApellidos.setColumns(10);

	JLabel lblTipo = new JLabel("Tipo: ");
	add(lblTipo, "cell 5 8,alignx trailing");

	textTipo = new JTextField();
	textTipo.setEditable(false);
	add(textTipo, "cell 6 8,growx");
	textTipo.setColumns(10);

	btnBorrarCliente = new JButton("Borrar empleado");
	btnBorrarCliente.setEnabled(false);
	btnBorrarCliente.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {

		if (empleado != null)
		    ControladorAplicacion.getInstance().handleRequest(
			    IDEventos.EVENTO_BAJA_EMPLEADO, empleado.getDNI());
		else
		    JOptionPane.showMessageDialog(contentPane,
			    "Error al cargar el empleado, búsquelo otra vez",
			    "Error", JOptionPane.ERROR_MESSAGE);
	    }
	});
	add(btnBorrarCliente, "cell 6 11");
    }

    @Override
    public void actualizarVentana(IDEventos idEvento, Object datos) {

	if (IDEventos.EVENTO_BAJA_EMPLEADO == idEvento) {

	    if (datos instanceof Boolean) {

		Boolean correcto = (Boolean) datos;

		if (correcto) {
		    textDNIBusqueda.setText("");
		    empleado = null;
		    txtDni.setText("");
		    textNombre.setText("");
		    textApellidos.setText("");
		    textTipo.setText("");
		    btnBorrarCliente.setEnabled(false);

		    JOptionPane.showMessageDialog(contentPane,
			    "El empleado se ha borrado correctamente", "Aviso",
			    JOptionPane.INFORMATION_MESSAGE);
		} else {

		    JOptionPane.showMessageDialog(contentPane,
			    "El empleado no se ha borrado correctamente",
			    "Error", JOptionPane.ERROR_MESSAGE);
		}
	    }
	} else if (IDEventos.EVENTO_CONSULTAR_EMPLEADOS_V_BORRAR == idEvento) {

	    if (datos instanceof Empleado) {

		Empleado empleado = (Empleado) datos;

		this.empleado = empleado;
		txtDni.setText(empleado.getDNI());
		textNombre.setText(empleado.getNombre());
		textApellidos.setText(empleado.getPrimerApellido() + " "
			+ empleado.getSegundoApellido());
		textTipo.setText(empleado.getTipo().name());
		btnBorrarCliente.setEnabled(true);
	    }
	} else if (IDEventos.ERROR_BAJA_EMPLEADO == idEvento
		|| IDEventos.ERROR_CONSULTAR_EMPLEADOS_V_BORRAR == idEvento) {

	    if (datos instanceof BSoDException) {

		JOptionPane.showMessageDialog(contentPane,
			((BSoDException) datos).getMensaje(), "Error",
			JOptionPane.ERROR_MESSAGE);
	    } else {

		JOptionPane.showMessageDialog(contentPane, "Error genérico",
			"Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
    }
}