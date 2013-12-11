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
public class PanelBajaReservas extends JPanel implements GUIPanelesInterfaz {

	private JTextField textFechaSalida ;
	private JTextField textDNI;
	private JTextField textFechaEntrada; 
	private JTextField textNHabitacion;
	private JTextField textFechaReserva;
	private JTextField textNReserva; 
	
	public PanelBajaReservas(){
		setLayout(new MigLayout("", "[][][::164.00,grow][70.00][236.00]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblBajaDeReserva = new JLabel("Baja de reserva");
		add(lblBajaDeReserva, "cell 3 0");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 4 1, growx");
		
		JLabel lblNumeroDeReserva = new JLabel("Numero de reserva");
		add(lblNumeroDeReserva, "cell 1 5,alignx right");
		
		textNReserva = new JTextField();
		add(textNReserva, "cell 2 5,growx");
		textNReserva.setColumns(10);
		
		JLabel lblFechaDeReserva = new JLabel("Fecha de reserva");
		add(lblFechaDeReserva, "cell 3 5,alignx trailing");
		
		textFechaReserva = new JTextField();
		add(textFechaReserva, "cell 4 5,growx");
		textFechaReserva.setColumns(10);
		
		JLabel lblNumeroDeHabitacion = new JLabel("Numero de habitacion");
		add(lblNumeroDeHabitacion, "cell 1 6,alignx right");
		
		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 2 6,growx");
		textNHabitacion.setColumns(10);
		
		JLabel lblFechaEntrada = new JLabel("Fecha Entrada");
		add(lblFechaEntrada, "cell 3 6,alignx trailing");
		
		textFechaEntrada = new JTextField();
		add(textFechaEntrada, "cell 4 6,growx");
		textFechaEntrada.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		add(lblDni, "cell 1 7,alignx trailing");
		
		textDNI = new JTextField();
		add(textDNI, "cell 2 7,growx");
		textDNI.setColumns(10);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
		add(lblFechaDeSalida, "cell 3 7,alignx trailing");
		
		textFechaSalida = new JTextField();
		add(textFechaSalida, "cell 4 7,growx");
		textFechaSalida.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 1 9");
		
		JButton btnBorrar = new JButton("Borrar");
		add(btnBorrar, "cell 4 9,alignx right");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 11 5 1,growx");

	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}