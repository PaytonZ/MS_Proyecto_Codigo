/**
 * 
 */
package presentacion.habitaciones.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.habitaciones.transfer.TipoHabitacion;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
import negocio.habitaciones.transfer.TransferHabitacionSuite;
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
public class PanelAltaHabitaciones extends JPanel implements GUIPanelesInterfaz {

		private static final long serialVersionUID = 1L;
		private JTextField textPrecioNoche;
		private JTextField textNumHab;
		private JPanel contentPane;
		private JComboBox<TipoHabitacion> comboBox;

		/**
		 * Create the panel.
		 */
		public PanelAltaHabitaciones() {
			
			contentPane = this;
			
			setPreferredSize(new Dimension(600, 400));
			setMinimumSize(new Dimension(100, 100));
			setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
			
			JLabel lblAltaHabitacion = new JLabel("Alta habitación");
			lblAltaHabitacion.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(lblAltaHabitacion, "cell 0 0 9 1,alignx center,aligny top");
			
			JSeparator separator = new JSeparator();
			add(separator, "cell 0 1 9 1,growx,aligny center");
			
			JLabel lblnumHab = new JLabel("Número de habitación: ");
			add(lblnumHab, "cell 0 3,alignx right,aligny center");
			
			textNumHab = new JTextField();
			textNumHab.setColumns(10);
			add(textNumHab, "cell 2 3,growx");
			
			JLabel label = new JLabel("->");
			add(label, "cell 4 3");
			
			JButton btnVerificar = new JButton("Verificar");
			btnVerificar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if ( !"".equals(textNumHab.getText()) ) {
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_HABITACION_V_ALTA, textNumHab.getText());
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "El número de habitación ya existe", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			add(btnVerificar, "cell 5 3");
			
			JLabel lblPrecioNoche = new JLabel("Precio por noche: ");
			add(lblPrecioNoche, "cell 0 5,alignx right,aligny center");
			
			textPrecioNoche = new JTextField();
			add(textPrecioNoche, "cell 2 5,growx,aligny top");
			textPrecioNoche.setColumns(10);
			
			JLabel lblTipo = new JLabel("Tipo: ");
			add(lblTipo, "cell 5 5,alignx trailing");
			
			comboBox = new JComboBox<>();
			comboBox.setModel(new DefaultComboBoxModel<TipoHabitacion>(TipoHabitacion.values()));
			add(comboBox, "cell 6 5 2 1,growx");
			
			JSeparator separator_1 = new JSeparator();
			add(separator_1, "cell 0 7 9 1,growx,aligny center");
			
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					TransferCliente cliente = new TransferCliente();
					
//					if ( !textNumHab.getText().equals("") 
//							&& !textNombre.getText().equals("")
//							&& !textDireccion.getText().equals("")) {
//						
//						cliente.setDNI(textNumHab.getText());
//						cliente.setNombre(textNombre.getText());
//						cliente.setDireccion(textDireccion.getText());
//						
//						if ( textPrimerApellido.getText().equals("") ) {
//							JOptionPane.showMessageDialog(null, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//						else {
//							cliente.setPrimerApellido(textPrimerApellido.getText().trim());
//							if ( !textSegundoApellido.getText().equals("") )
//								cliente.setSegundoApellido(textSegundoApellido.getText().trim());
//							
//							try {
//								cliente.setNumTelefono( Integer.valueOf(textTelefono.getText()) );
//							}
//							catch(NumberFormatException nu) {
//								JOptionPane.showMessageDialog(null, "El teléfono contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
//							}
//							
//							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_CLIENTE, cliente);
//						}
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
//					}
				}
			});
			add(btnAceptar, "cell 7 8,alignx left,aligny top");
		}

		@Override
		public void actualizarVentana(IDEventos idEvento, Object datos) {
			
			if ( IDEventos.EVENTO_CONSULTAR_HABITACION_V_ALTA == idEvento || IDEventos.ERROR_CONSULTAR_HABITACION_V_ALTA == idEvento) {
				if ( datos == null) {
					
					JOptionPane.showMessageDialog(this, "No se pudo validar el número de habitación", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if ( datos instanceof TransferHabitacion ) {
					
					if ( datos instanceof TransferHabitacionNormal ) {
							
						Integer tipo = ((TransferHabitacionNormal) datos).getNumHabitacion();
						
						textNumHab.setText( String.valueOf(tipo) );
					}
					else if ( datos instanceof TransferHabitacionSuite ) {
						
						Integer tipo = ((TransferHabitacionSuite) datos).getNumHabitacion();
						
						textNumHab.setText( String.valueOf(tipo) );
					}
					
					textNumHab.setText("");
					textPrecioNoche.setText("");
					comboBox.setSelectedItem(null);
				}
				else if( datos instanceof Integer ) {
					
					
				}
				else if( datos instanceof BSoDException ) {
					
					BSoDException bsod = (BSoDException) datos;
					
					JOptionPane.showMessageDialog(this, bsod.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if ( IDEventos.EVENTO_ALTA_HABITACION == idEvento || IDEventos.ERROR_ALTA_HABITACION == idEvento) {
				
			}
		}
	}
