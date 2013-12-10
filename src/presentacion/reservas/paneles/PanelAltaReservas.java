/**
 * 
 */
package presentacion.reservas.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
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
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta clientes");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 8 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 9 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 0 3,alignx right,aligny center");
		
		textDNI = new JTextField();
		add(textDNI, "cell 2 3,growx");
		textDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Número: ");
		add(lblNombre, "cell 0 5,alignx right,aligny center");
		
		textNHabitacion = new JTextField();
		add(textNHabitacion, "cell 2 5, growx");
		textNHabitacion.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 10 8 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferReserva reserva = new TransferReserva();
				
				if ( !textDNI.getText().equals("") 
						&& !textNHabitacion.getText().equals("") ) {
					
					reserva.setidusuario(Integer.parseInt(textDNI.getText()));
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
		add(btnAceptar, "cell 7 11,alignx left,aligny top");
	}
	public void actualizarVentana(Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}