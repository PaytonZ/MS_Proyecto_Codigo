/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

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
	private JTextField textFechaSalida;
	private JTextField textFechaReserva;
	private JTextField textFechaEntrada;
	private JPanel contentPane;
	
	private TransferReserva reserva;
	
	public PanelModificacionReservas() {
		contentPane = this;
		setLayout(new MigLayout("", "[53.00][123.00,grow][47.00][51.00][48.00][56.00][115.00][189.00]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblModificacionDeReserva = new JLabel("Modificacion de reserva");
		add(lblModificacionDeReserva, "cell 3 0 3 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 8 1,growx");
		
		JLabel lblNumero = new JLabel("Nº de reserva");
		add(lblNumero, "cell 0 3,alignx trailing");
		
		textNReserva = new JTextField();
		add(textNReserva, "cell 1 3,growx");
		textNReserva.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
				reserva = null;
				textNReserva.setText("");
				textFechaSalida.setText("");
				textFechaSalida.setEditable(false);
				textFechaEntrada.setText("");
				textFechaEntrada.setEditable(false);
				textFechaReserva.setText("");
				textFechaReserva.setEditable(false);
				
			}
		});
		add(btnNBuscar, "cell 5 3");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx");
		
		JLabel lblFechaReserva = new JLabel("Fecha Reserva");
		add(lblFechaReserva, "cell 0 7,alignx trailing");
		
		textFechaReserva = new JTextField();
		textFechaReserva.setEditable(false);
		add(textFechaReserva, "cell 1 7,growx");
		textFechaReserva.setColumns(10);
		
		JLabel lblFechaEntrada = new JLabel("Fecha Entrada");
		add(lblFechaEntrada, "cell 3 7,alignx trailing");
		
		textFechaEntrada = new JTextField();
		add(textFechaEntrada, "cell 5 7 2 1,growx");
		textFechaEntrada.setColumns(10);
		
		JLabel lblFechaSalida = new JLabel("Fecha Salida");
		add(lblFechaSalida, "cell 0 8,alignx trailing");
		
		textFechaSalida = new JTextField();
		add(textFechaSalida, "cell 1 8,growx");
		textFechaSalida.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 0 10 8 1,growx");
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textNReserva.setEditable(false);
				
				if ( reserva.getNumeroReserva() != null 
						&& !textFechaEntrada.getText().equals("")
						&& !textFechaSalida.getText().equals("") 
						&& !textFechaReserva.getText().equals("")) {
					try{
						reserva.setNumeroReserva(Integer.parseInt(textNReserva.getText().trim()));
						
						try {
							SimpleDateFormat sDateF = new SimpleDateFormat("yyyy-MM-dd");
							Date fechaEntrada = sDateF.parse(textFechaEntrada.getText().trim());
							Date fechaSalida = sDateF.parse(textFechaSalida.getText().trim());
							
							reserva.setFechaEntrada(fechaEntrada);
							reserva.setFechaSalida(fechaSalida);
							
							try{
								reserva.setNumeroHabitacion(Integer.parseInt(textFechaReserva.getText().trim()));
							}catch(NumberFormatException nu){
								JOptionPane.showMessageDialog(contentPane, "El campo de número de habitacion solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
							}
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_RESERVA, reserva);
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(contentPane, "Formato incorrecto en las fechas: yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}catch(NumberFormatException nu){
						JOptionPane.showMessageDialog(contentPane, "El campo de número de reserva solo puede contener caracteres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}		
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}	
			
		});
		add(btnModificar, "cell 5 11,alignx right");
	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		
		if( IDEventos.EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS == idEventos){
			if( datos instanceof TransferReserva){
				reserva = (TransferReserva) datos;
				
				textNReserva.setEditable(false);
				textFechaEntrada.setText(reserva.getFechaEntrada().toString());
				textFechaEntrada.setEditable(true);
				textFechaSalida.setText(reserva.getFechaSalida().toString());
				textFechaSalida.setEditable(true);
				textFechaReserva.setText(reserva.getFechaReserva().toString());
				
				ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
				controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR_RESERVAS, reserva.getidusuario());
			}
		}
		else if( IDEventos.EVENTO_MODIFICAR_RESERVA == idEventos){
			
			if ( datos instanceof Boolean) {
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					JOptionPane.showMessageDialog(contentPane, "La reserva se modificó correctamente", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Error al actualizar la reserva", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if( idEventos == IDEventos.ERROR_CONSULTAR_CLIENTE_V_MODIFICAR_RESERVAS || idEventos == IDEventos.ERROR_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS){
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

	