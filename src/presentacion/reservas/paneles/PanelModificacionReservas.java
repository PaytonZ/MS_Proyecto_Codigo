/**
 * 
 */
package presentacion.reservas.paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelModificacionReservas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textID;
	private JTextField textDNI;
	private JTextField textFechaSalida;
	private JTextField textNHabitacion;
	private JTextField textFechaEntrada;
	
	public PanelModificacionReservas() {
		setLayout(new MigLayout("", "[53.00][123.00,grow][47.00][51.00][48.00][56.00][189.00]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblModificacionDeReserva = new JLabel("Modificacion de reserva");
		add(lblModificacionDeReserva, "cell 3 0 3 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1,growx");
		
		JLabel lblId = new JLabel("ID");
		add(lblId, "cell 0 3,alignx trailing");
		
		textID = new JTextField();
		add(textID, "cell 1 3,growx");
		textID.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 3 3");
		
		JButton btnNBuscar = new JButton("Nueva busqueda");
		add(btnNBuscar, "cell 5 3");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 7 1, growx");
		
		JLabel lblDni = new JLabel("DNI");
		add(lblDni, "cell 0 7,alignx trailing");
		
		textDNI = new JTextField();
		add(textDNI, "cell 1 7,growx");
		textDNI.setColumns(10);
		
		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		add(lblFechaSalida, "cell 5 7,alignx trailing");
		
		textFechaSalida = new JTextField();
		add(textFechaSalida, "cell 6 7,growx");
		textFechaSalida.setColumns(10);
		
		JLabel lblFechaReserva = new JLabel("Fecha Reserva");
		add(lblFechaReserva, "cell 0 8,alignx trailing");
		
		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 1 8,growx");
		textNHabitacion.setColumns(10);
		
		JLabel lblFechaEntrada = new JLabel("Fecha Entrada");
		add(lblFechaEntrada, "cell 5 8,alignx trailing");
		
		textFechaEntrada = new JTextField();
		add(textFechaEntrada, "cell 6 8,growx");
		textFechaEntrada.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 0 10 7 1, growx");
		
		JButton btnModificar = new JButton("Modificar");
		add(btnModificar, "cell 6 11,alignx right");
	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}