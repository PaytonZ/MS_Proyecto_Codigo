/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelBajaReservas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFechaSalida ;
	private JTextField textDNI;
	private JTextField textFechaEntrada; 
	private JTextField textNHabitacion;
	private JTextField textFechaReserva;
	private JTextField textNReserva;
	
	private JPanel contentPane;
	
	public PanelBajaReservas(){
		
		contentPane = this;
		
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
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if ( !textNReserva.getText().equals("") ) {
					try {
						Integer numReserva = Integer.valueOf(textNReserva.getText().trim());
						
						if ( numReserva >= 0) {
							
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_RESERVA_V_BORRAR_RESERVAS, numReserva);
						}
					}
					catch(NumberFormatException nu) {
						JOptionPane.showMessageDialog(contentPane, "El campo de número de habitacón solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo de número de habitacón no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 1 9");
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if ( !textNReserva.getText().equals("") ) {
					
					try {
						Integer idReserva = Integer.valueOf(textNReserva.getText().trim());
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_RESERVA, idReserva);
					}
					catch ( NumberFormatException nu) {
						JOptionPane.showMessageDialog(contentPane, "El número de la reserva no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El número de la reserva no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(btnBorrar, "cell 4 9,alignx right");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 11 5 1,growx");

	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {

		if ( IDEventos.EVENTO_CONSULTAR_RESERVA_V_BORRAR_RESERVAS == idEventos) {
			
			if ( datos instanceof TransferReserva ) {
				
				TransferReserva reserva = (TransferReserva) datos;
				
				textNHabitacion.setText( String.valueOf(reserva.getNumeroHabitacion()) );
				textFechaReserva.setText(reserva.getFechaReserva().toString());
				textFechaEntrada.setText(reserva.getFechaEntrada().toString());
				textFechaSalida.setText(reserva.getFechaSalida().toString());
				
				textDNI.setText("buscando...");
				
				ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_BORRAR_RESERVAS, reserva.getidusuario());
				
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al consultar la reserva, revise los datos", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if ( IDEventos.EVENTO_CONSULTAR_CLIENTE_V_BORRAR_RESERVAS == idEventos ) {
			
			if ( datos instanceof TransferCliente ) {
				
				TransferCliente cliente = (TransferCliente) datos;
				
				textDNI.setText( String.valueOf(cliente.getID()));
			}
		}
		else if ( IDEventos.EVENTO_BAJA_RESERVA == idEventos ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					JOptionPane.showMessageDialog(contentPane, "La reserva se borró correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "La reserva no se borró correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else if ( IDEventos.ERROR_CONSULTAR_RESERVA_V_BORRAR_RESERVAS == idEventos || IDEventos.ERROR_BAJA_RESERVA == idEventos || IDEventos.ERROR_CONSULTAR_CLIENTE_V_BORRAR_RESERVAS == idEventos) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}