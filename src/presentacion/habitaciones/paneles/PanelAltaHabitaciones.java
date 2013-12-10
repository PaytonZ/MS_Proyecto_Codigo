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

import negocio.excepciones.BSoDException;
import negocio.habitaciones.transfer.TipoHabitacion;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
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
		private JButton btnAceptar;
		private JButton btnLimpiar;

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
						
						Integer numHabitacion = null;
						try {
							numHabitacion = Integer.valueOf(textNumHab.getText());
							
							if ( numHabitacion > 0 ) {
							
								ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_HABITACION_V_ALTA, numHabitacion);
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "El número de habitación no puede ser negatico", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						catch(NumberFormatException nu) {
							JOptionPane.showMessageDialog(contentPane, "El número de habitación solo puede contener números", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "El campo numero de habitación no puede quedar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			add(btnVerificar, "cell 5 3");
			
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					textNumHab.setEditable(true);
					textPrecioNoche.setText("");
					textPrecioNoche.setEditable(false);
					comboBox.setEnabled(false);
					btnAceptar.setEnabled(false);
				}
			});
			add(btnLimpiar, "cell 6 3");
			
			JLabel lblPrecioNoche = new JLabel("Precio por noche: ");
			add(lblPrecioNoche, "cell 0 5,alignx right,aligny center");
			
			textPrecioNoche = new JTextField();
			textPrecioNoche.setEditable(false);
			add(textPrecioNoche, "cell 2 5,growx,aligny top");
			textPrecioNoche.setColumns(10);
			
			JLabel lblTipo = new JLabel("Tipo: ");
			add(lblTipo, "cell 5 5,alignx trailing");
			
			comboBox = new JComboBox<>();
			comboBox.setEnabled(false);
			comboBox.setModel(new DefaultComboBoxModel<TipoHabitacion>(TipoHabitacion.values()));
			add(comboBox, "cell 6 5 2 1,growx");
			
			JSeparator separator_1 = new JSeparator();
			add(separator_1, "cell 0 7 9 1,growx,aligny center");
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setEnabled(false);
			btnAceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					TransferHabitacion habitacion = new TransferHabitacion();
					
					if ( !textNumHab.getText().equals("") 
							&& !textPrecioNoche.getText().equals("")
							&& comboBox.getSelectedIndex() >= 0) {
						
						try {
							habitacion.setNumHabitacion(Integer.valueOf(textNumHab.getText().trim()) );
							habitacion.setPrecio( Double.valueOf(textPrecioNoche.getText().trim()) );
							
							if ( Double.valueOf(textPrecioNoche.getText().trim()) >= 0 ) {
								habitacion.setTipohabitacion( (TipoHabitacion) comboBox.getSelectedItem() );
								
								ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_HABITACION, habitacion);
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "No se puede introducir un precion negativo", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						catch(NumberFormatException nu) {
							JOptionPane.showMessageDialog(contentPane, "El teléfono contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar o sin seleccionar", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			add(btnAceptar, "cell 7 8,alignx left,aligny top");
		}

		@Override
		public void actualizarVentana(IDEventos idEvento, Object datos) {
			
			if ( idEvento != null) {
				if ( IDEventos.EVENTO_CONSULTAR_HABITACION_V_ALTA == idEvento ) {
					if ( datos == null) {
						
						JOptionPane.showMessageDialog(contentPane, "El número de habitación está libre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						
						textNumHab.setEditable(false);
						textPrecioNoche.setEditable(true);
						comboBox.setEnabled(true);
						btnAceptar.setEnabled(true);
					}
					else if ( datos instanceof TransferHabitacion ) {
								
						Integer numHabitacion = ((TransferHabitacionNormal) datos).getNumHabitacion();
						
						if ( numHabitacion == Integer.valueOf(textNumHab.getText()) ) {
							JOptionPane.showMessageDialog(contentPane, "El número de habitación ya existe", "Error", JOptionPane.ERROR_MESSAGE);
							
							textNumHab.setText("");
							textPrecioNoche.setText("");
							comboBox.setSelectedItem(null);
							textNumHab.setEditable(true);
							textPrecioNoche.setEditable(false);
							comboBox.setEnabled(false);
							btnAceptar.setEnabled(false);
						}
						else {
						
							textNumHab.setEditable(false);
							textPrecioNoche.setEditable(true);
							comboBox.setEnabled(true);
							btnAceptar.setEnabled(true);
						}
					}
				}
				else if ( IDEventos.EVENTO_ALTA_HABITACION == idEvento ) {
					
					if ( datos != null ) {
						
						if ( datos instanceof Integer) {
							
							JOptionPane.showMessageDialog(contentPane, "La habitación se añadió correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
							
							textNumHab.setText("");
							textPrecioNoche.setText("");
							comboBox.setSelectedItem(null);
							textNumHab.setEditable(true);
							textPrecioNoche.setEditable(false);
							comboBox.setEnabled(false);
							btnAceptar.setEnabled(false);
						}
					}
					else {

						JOptionPane.showMessageDialog(contentPane, "Ocurrió un error al añadir la habitación", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						
						textNumHab.setText("");
						textPrecioNoche.setText("");
						comboBox.setSelectedItem(null);
						textNumHab.setEditable(true);
						textPrecioNoche.setEditable(false);
						comboBox.setEnabled(false);
						btnAceptar.setEnabled(false);
					}
				}
				else if ( IDEventos.ERROR_ALTA_HABITACION == idEvento || IDEventos.ERROR_CONSULTAR_HABITACION_V_ALTA == idEvento) {
					
					if( datos instanceof BSoDException ) {
						
						BSoDException bsod = (BSoDException) datos;
						
						JOptionPane.showMessageDialog(contentPane, bsod.getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
