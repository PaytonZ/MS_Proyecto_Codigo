/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

import com.toedter.calendar.JCalendar;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelAltaReservas extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textNHabitacion;
	private JTextField textDNI;
	private JCalendar calendarioEntrada;
	private JCalendar calendarioSalida;

	private JPanel contentPane;
	// version de prueba
	private int idCliente;

	public PanelAltaReservas() {
		idCliente = -1;
		contentPane = this;
		setLayout(new MigLayout(
				"",
				"[46px][:130.00:147.00,grow][24.00:n][52.00:n][:57.00:74.00][grow][grow]",
				"[14px][][24.00:30.00][][][][59.00:63.00:41.00][15.00:21.00][197.00:246.00][-41.00:-73.00:-17.00][28.00:152.00,grow][57.00:40.00,grow]"));

		JLabel AltaReserva = new JLabel("Alta Reserva");
		add(AltaReserva, "cell 3 0,alignx right,aligny top");

		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1, growx");

		JLabel lblDNI = new JLabel("DNI");
		add(lblDNI, "cell 0 3,alignx trailing");

		textDNI = new JTextField();
		textDNI.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				idCliente = -1;
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {}
		});
		add(textDNI, "cell 1 3,growx");
		textDNI.setColumns(10);

		// Panel incluido por si se introduce el image icon
		Panel panelImageIcon = new Panel();
		add(panelImageIcon, "cell 2 3");

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!textDNI.getText().equals("")) {

					String dniCliente = textDNI.getText();

					ControladorAplicacion.getInstance().handleRequest(
							IDEventos.EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS,
							dniCliente);
				}

			}
		});
		add(btnBuscar, "cell 3 3");

		JLabel lblNHabitacion = new JLabel("Nº habitación");
		add(lblNHabitacion, "cell 4 3,alignx trailing");

		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 5 3 2 1");
		textNHabitacion.setColumns(10);

		JLabel lblFechaEntrada = new JLabel("Fecha de entrada");
		add(lblFechaEntrada, "cell 0 6,alignx center");

		JLabel lblFechaSalida = new JLabel("Fecha salida");
		add(lblFechaSalida, "cell 4 6");

		JPanel panelFechaEntrada = new JPanel();
		add(panelFechaEntrada, "cell 0 7 4 2,grow");

		JPanel panelFechaSalida = new JPanel();
		add(panelFechaSalida, "cell 4 7 3 2,grow");

		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 9 7 1");

		JPanel panelBotonAceptar = new JPanel();
		add(panelBotonAceptar, "cell 6 6,grow");

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TransferReserva reserva = new TransferReserva();

				if (!textDNI.getText().equals("")
						&& !textNHabitacion.getText().equals("")
						&& idCliente > -1
						&& calendarioEntrada.getDate().compareTo(new Date()) >= 0
						&& calendarioSalida.getDate().compareTo(calendarioEntrada.getDate()) >= 0) {

					reserva.setidusuario(idCliente);
					reserva.setFechaEntrada(calendarioEntrada.getDate());
					reserva.setFechaSalida(calendarioSalida.getDate());
					reserva.setFechaReserva(new Date());

					try {
						reserva.setNumeroHabitacion(Integer.parseInt(textNHabitacion.getText()));
						
					} catch (NumberFormatException nu) {
						
						JOptionPane.showMessageDialog( null, "El número de habitación contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_RESERVA, reserva);

				} else if (idCliente <= -1) {
					
					JOptionPane.showMessageDialog( null, "No se encontró el cliente solicitado", "Error", JOptionPane.ERROR_MESSAGE);
					
				} else if (calendarioEntrada.getDate().compareTo(new Date()) < 0) {
					
					JOptionPane.showConfirmDialog( null, "La fecha de entrada no puede ser inferior a la fecha actual", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else if (calendarioSalida.getDate().compareTo(calendarioEntrada.getDate()) < 0) {
					
					JOptionPane.showConfirmDialog( null, "La fecha de salida no puede ser inferior a la fecha de entrada", "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showConfirmDialog(null, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panelBotonAceptar.add(btnAceptar);

		// CALENDARIOS
		calendarioEntrada = new JCalendar();
		panelFechaEntrada.add(calendarioEntrada);
		
		calendarioSalida = new JCalendar();
		panelFechaSalida.add(calendarioSalida);
	}

	public void actualizarVentana(IDEventos idEventos, Object datos) {

		if (idEventos == IDEventos.ERROR_CONSULTAR_CLIENTE_V_ALTA_RESERVAS
				|| idEventos == IDEventos.ERROR_ALTA_RESERVA) {

			if (datos instanceof BSoDException) {

				JOptionPane.showMessageDialog(contentPane,
						"Error al dar de alta un cliente", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (idEventos == IDEventos.EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS) {

			if (datos instanceof TransferCliente) {

				TransferCliente cliente = (TransferCliente) datos;

				int respuesta = JOptionPane.showConfirmDialog(
						contentPane,
						"DNI: " + cliente.getDNI() + "\nNombre: "
								+ cliente.getNombre() + "\nApellidos: "
								+ cliente.getPrimerApellido() + " "
								+ cliente.getSegundoApellido() + "\nTelefono: "
								+ cliente.getNumTelefono(),
						"Resumen de datos del cliente",
						JOptionPane.YES_NO_OPTION);

				if (respuesta == JOptionPane.YES_OPTION) {

					idCliente = cliente.getID();
				} else {
					textDNI.setText("");
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se encontró el cliente solicitado", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (idEventos == IDEventos.EVENTO_ALTA_RESERVA) {

			if ( datos instanceof Integer) {
			
				JOptionPane.showMessageDialog(contentPane, "La reserva se realizó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Ocurrión un error al reservar la habitación", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
