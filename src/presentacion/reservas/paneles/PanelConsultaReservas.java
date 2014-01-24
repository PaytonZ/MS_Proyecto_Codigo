/**
 * 
 */
package presentacion.reservas.paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.reservas.transfer.TransferReserva;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelConsultaReservas extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textID;
	private JTextField textDNI;
	private JTextField textFechaEntrada;
	private JTextField textFechaSalida;
	private JTextField textFechaReserva;
	private JTextField textNHabitacion;

	/**
	 * Create the panel.
	 */
	public PanelConsultaReservas() {
		setLayout(new MigLayout("", "[53.00][123.00,grow][47.00][51.00][48.00][56.00][189.00]", "[][][][][][][][][][][][][][][][]"));
		
		JLabel lblConsultarReserva = new JLabel("Consultar reserva");
		add(lblConsultarReserva, "cell 2 0 3 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1,growx");
		
		JLabel lblId = new JLabel("ID");
		add(lblId, "cell 0 3,alignx trailing");
		
		textID = new JTextField();
		add(textID, "cell 1 3 2 1,growx");
		textID.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Integer idreserva = Integer.parseInt(textID.getText());
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_RESERVA, idreserva);
			}
		});
		add(btnBuscar, "cell 5 3");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 7 1,growx");
		
		JLabel lblDni = new JLabel("DNI");
		add(lblDni, "cell 0 7,alignx trailing");
		
		textDNI = new JTextField();
		add(textDNI, "cell 1 7 2 1,growx");
		textDNI.setColumns(10);
		
		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		add(lblFechaSalida, "cell 5 7,alignx trailing");
		
		textFechaSalida = new JTextField();
		add(textFechaSalida, "cell 6 7,growx");
		textFechaSalida.setColumns(10);
		
		JLabel lblNumeroDeHabitacion = new JLabel("Numero de habitacion");
		add(lblNumeroDeHabitacion, "cell 0 8,alignx trailing");
		
		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 1 8 2 1,growx");
		textNHabitacion.setColumns(10);
		
		JLabel lblFechaEntrada = new JLabel("Fecha Entrada");
		add(lblFechaEntrada, "cell 5 8,alignx trailing");
		
		textFechaEntrada = new JTextField();
		add(textFechaEntrada, "cell 6 8,growx");
		textFechaEntrada.setColumns(10);
		
		JLabel lblFechaReserva = new JLabel("Fecha Reserva");
		add(lblFechaReserva, "cell 5 9,alignx trailing");
		
		textFechaReserva = new JTextField();
		add(textFechaReserva, "cell 6 9,growx");
		textFechaReserva.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 0 11 7 1,growx");

	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		if ( IDEventos.EVENTO_CONSULTAR_RESERVA == idEventos ) {
			
			if ( datos instanceof TransferReserva) {
				
				TransferReserva reserva = (TransferReserva) datos;
				
				if ( reserva != null ) {
					textDNI.setText(reserva.getidusuario().toString());
					textNHabitacion.setText(reserva.getNumeroHabitacion().toString());
					textFechaEntrada.setText(reserva.getFechaEntrada().toString());
					textFechaReserva.setText(reserva.getFechaReserva().toString());
					textFechaSalida.setText(reserva.getFechaSalida().toString());
					
				}
					
			}
			else {
				JOptionPane.showMessageDialog(this, "No se pudo obtener la reserva", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_RESERVA == idEventos ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(this, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JOptionPane.showMessageDialog(this, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}