/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

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
public class PanelAltaReservas extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	private JTextField textNHabitacion;
	private JTextField textDNI;
	
	public PanelAltaReservas(){
setLayout(new MigLayout("", "[46px][:130.00:147.00,grow][24.00:n][52.00:n][:57.00:74.00][grow][grow]", "[14px][][24.00:30.00][][][][59.00:63.00:41.00][15.00:69.00][197.00:246.00][][152.00,grow][grow]"));
		
		JLabel AltaReserva = new JLabel("Alta Reserva");
		add(AltaReserva, "cell 3 0,alignx right,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1, growx");
		
		JLabel lblDNI = new JLabel("DNI");
		add(lblDNI, "cell 0 3,alignx trailing");
		
		textDNI = new JTextField();
		add(textDNI, "cell 1 3,growx");
		textDNI.setColumns(10);
		
		// Panel incluido por si se introduce el image icon
		Panel panelImageIcon = new Panel();
		add(panelImageIcon, "cell 2 3");
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar, "cell 3 3");
		
		JLabel lblNHabitacion = new JLabel("Nº habitación");
		add(lblNHabitacion, "cell 4 3,alignx trailing");
		
		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 5 3 2 1,growx");
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
		add(panelBotonAceptar, "cell 5 11 2 1,grow");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferReserva reserva = new TransferReserva();
				
				if ( !textDNI.getText().equals("") 
						&& !textNHabitacion.getText().equals("") ) {
					

					reserva.setidusuario(Integer.parseInt(textDNI.getText()));

//					reserva.setDNI(textDNI.getText());

					try{
						reserva.setNumeroHabitacion(Integer.parseInt(textNHabitacion.getText()));
					}catch(NumberFormatException nu) {
						JOptionPane.showMessageDialog(null, "El número de habitación contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_RESERVA, reserva);
					}
				}
				else {
					JOptionPane.showConfirmDialog(null, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panelBotonAceptar.add(btnAceptar);
	
		//CALENDARIOS
		JCalendar calendarioEntrada = new JCalendar();
		panelFechaEntrada.add(calendarioEntrada);
		JCalendar calendarioSalida = new JCalendar();
		panelFechaSalida.add(calendarioSalida);
	
	

		
	
	}
	public void actualizarVentana(IDEventos idEventos, Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}
