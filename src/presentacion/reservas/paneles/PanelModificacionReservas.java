/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
public class PanelModificacionReservas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textNReserva;
	private JTextField textDNI;
	private JTextField textFechaSalida;
	private JTextField textNHabitacion;
	private JTextField textFechaEntrada;
	private Integer idReserva;
	private JPanel contentPane;
	
	public PanelModificacionReservas() {
		contentPane = this;
		setLayout(new MigLayout("", "[53.00][123.00,grow][47.00][51.00][48.00][56.00][189.00]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblModificacionDeReserva = new JLabel("Modificacion de reserva");
		add(lblModificacionDeReserva, "cell 3 0 3 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1,growx");
		
		JLabel lblNumero = new JLabel("Nº de reserva");
		add(lblNumero, "cell 0 3,alignx trailing");
		
		textNReserva = new JTextField();
		add(textNReserva, "cell 1 3,growx");
		textNReserva.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textNReserva.setEditable(false);
				try{
					Integer idReserva = Integer.parseInt(textNReserva.getText().trim());
					ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
					controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS, idReserva);
				}catch(NumberFormatException nu){
					JOptionPane.showMessageDialog(contentPane, "El campo de número de reserva solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		add(btnBuscar, "cell 3 3");
		
		JButton btnNBuscar = new JButton("Nueva busqueda");
		btnNBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idReserva = null;
				textNReserva.setText("");
				textNReserva.setEditable(true);
				textDNI.setText("");
				textFechaSalida.setText("");
				textFechaSalida.setEditable(false);
				textFechaEntrada.setText("");
				textFechaEntrada.setEditable(false);
				textNHabitacion.setText("");
				textNHabitacion.setEditable(false);
				
			}
		});
		add(btnNBuscar, "cell 5 3");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 7 1, growx");
		
		JLabel lblDni = new JLabel("DNI");
		add(lblDni, "cell 0 7,alignx trailing");
		
		textDNI = new JTextField();
		textDNI.setEditable(false);
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
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textNReserva.setEditable(false);
				
				TransferReserva reserva = new TransferReserva();
				
				if ( idReserva != null 
						&& !textNReserva.getText().equals("")
						&& !textFechaEntrada.getText().equals("")
						&& !textFechaSalida.getText().equals("") 
						&& !textNHabitacion.getText().equals("")) {
					try{
						reserva.setNumeroReserva(Integer.parseInt(textNReserva.getText().trim()));
						reserva.setFechaEntrada(new Date(textFechaEntrada.getText().trim()));
						reserva.setFechaSalida(fechaSalida);
						try{
							reserva.setNumeroHabitacion(Integer.parseInt(textNHabitacion.getText().trim()));
						}catch(NumberFormatException nu){
							JOptionPane.showMessageDialog(contentPane, "El campo de número de habitacion solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						}
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_CLIENTE, reserva);
					}catch(NumberFormatException nu){
						JOptionPane.showMessageDialog(contentPane, "El campo de número de reserva solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}		
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}	
			
		});
		add(btnModificar, "cell 6 11,alignx right");
	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		
		if( IDEventos.EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS == idEventos){
			if( datos instanceof TransferReserva){
				TransferReserva reserva = (TransferReserva) datos;
				textNReserva.setEditable(false);
				textFechaEntrada.setText(reserva.getFechaEntrada().toString());
				textFechaEntrada.setEditable(true);
				textFechaSalida.setText(reserva.getFechaSalida().toString());
				textFechaSalida.setEditable(true);
				textNHabitacion.setText(reserva.getNumeroHabitacion().toString());
				textNHabitacion.setEditable(true);
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR_RESERVAS, reserva.getidusuario());
			}
		}
		else if( IDEventos.EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR_RESERVAS == idEventos){
			if ( datos instanceof TransferCliente){
				TransferCliente cliente = (TransferCliente) datos;
				
				textDNI.setText(cliente.getDNI()); 
				
			}
		}
		else if( idEventos == IDEventos.EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR_RESERVAS || idEventos == IDEventos.ERROR_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS){
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

	