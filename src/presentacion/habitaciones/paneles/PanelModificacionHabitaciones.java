/**
 * 
 */
package presentacion.habitaciones.paneles;

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
public class PanelModificacionHabitaciones extends JPanel implements GUIPanelesInterfaz {
	
	private static final long serialVersionUID = 1L;
	private JTextField textNumHabBusqueda;
	private JTextField textNumHab;
	private JTextField textPrecio;
	private JComboBox<TipoHabitacion> comboBox;
	private JButton btnModificarHab;
	
	private JPanel contentPane;
	
	public PanelModificacionHabitaciones() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][][60.00,grow][][36.00][][grow][]", "[][][][][18.00][17.00][][10.00][][16.00][13.00][]"));
		
		JLabel lblModificacinDeClientes = new JLabel("Modificación de clientes");
		add(lblModificacinDeClientes, "cell 0 0 7 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 6 1, growx, aligny center");
		
		JLabel lblNmeroDeHabitacin = new JLabel("Número de habitación: ");
		add(lblNmeroDeHabitacin, "cell 1 3,alignx trailing");
		
		textNumHabBusqueda = new JTextField();
		textNumHabBusqueda.setColumns(10);
		add(textNumHabBusqueda, "cell 2 3 2 1,growx");
		
		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textNumHabBusqueda.setEditable(false);
				
				try {
					Integer numHabitacion = Integer.valueOf(textNumHabBusqueda.getText());
					
					if ( numHabitacion >= 0 ) {
						
						ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
						controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_HABITACION_V_MODIFICAR, numHabitacion);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "El número de habitación no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(NumberFormatException nu) {
					JOptionPane.showMessageDialog(contentPane, "El campo número de habitación solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(buttonBuscar, "cell 5 3");
		
		JButton btnNuevaBsqueda = new JButton("Nueva búsqueda");
		btnNuevaBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				numHabitacion = null;
				textNumHabBusqueda.setText("");
				textNumHabBusqueda.setEditable(true);
				textNumHab.setText("");
				textNumHab.setEditable(false);
				textPrecio.setText("");
				textPrecio.setEditable(false);
				comboBox.setEditable(false);
				btnModificarHab.setEnabled(false);
			}
		});
		add(btnNuevaBsqueda, "cell 6 3");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 6 1, growx, aligny center");
		
		JLabel lblNmeroDeHabitacin_1 = new JLabel("Número de habitación: ");
		add(lblNmeroDeHabitacin_1, "cell 1 6,alignx trailing");
		
		textNumHab = new JTextField();
		textNumHab.setColumns(10);
		add(textNumHab, "cell 2 6 2 1,growx");
		
		JLabel lblPrecio = new JLabel("Precio por noche: ");
		add(lblPrecio, "cell 5 6,alignx trailing");
		
		textPrecio = new JTextField();
		add(textPrecio, "cell 6 6,growx");
		textPrecio.setColumns(10);
		
		JLabel lblTipoDeHabitacin = new JLabel("Tipo de habitación: ");
		add(lblTipoDeHabitacin, "cell 1 8,alignx trailing");
		
		btnModificarHab = new JButton("Modificar habitación");
		btnModificarHab.setEnabled(false);
		btnModificarHab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				TransferHabitacion habitacion = new TransferHabitacion();
				
				if ( !textNumHab.getText().equals("") 
						&& !textPrecio.getText().equals("")
						&& comboBox.getSelectedIndex() >= 0) {
					
					try {
						habitacion.setNumHabitacion(Integer.valueOf(textNumHab.getText().trim()) );
						habitacion.setPrecio( Double.valueOf(textPrecio.getText().trim()) );
						
						if ( Double.valueOf(textPrecio.getText().trim()) >= 0 ) {
							habitacion.setTipohabitacion( (TipoHabitacion) comboBox.getSelectedItem() );
							
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_HABITACION, habitacion);
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "No se puede introducir un precio negativo", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(NumberFormatException nu) {
						JOptionPane.showMessageDialog(contentPane, "Los campos número de habitación y precio contiene caracteres no numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar o sin seleccionar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		comboBox = new JComboBox<>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<TipoHabitacion>(TipoHabitacion.values()));
		add(comboBox, "cell 2 8 2 1,growx");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 1 10 7 1,growx,aligny center");
		add(btnModificarHab, "cell 6 11");
	}
	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIInterfazClientes#actualizarVentana(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_MODIFICAR_CLIENTE == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if ( correcto ) {
					textNumHabBusqueda.setText("");
					textNumHabBusqueda.setEditable(true);
					textNumHab.setText("");
					textNumHab.setEditable(false);
					textPrecio.setText("");
					textPrecio.setEditable(false);
					comboBox.setEnabled(false);
					btnModificarHab.setEnabled(false);
					
					JOptionPane.showMessageDialog(contentPane, "El cliente se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JOptionPane.showMessageDialog(contentPane, "El cliente no se ha modificado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_HABITACION_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof TransferHabitacion) {
				
				TransferHabitacion habitacion = (TransferHabitacion) datos;
				
				textNumHab.setText( String.valueOf(habitacion.getNumHabitacion()) );
				textNumHab.setEditable(true);
				textPrecio.setText( String.valueOf(habitacion.getPrecio()) );
				textPrecio.setEditable(true);
				comboBox.setEnabled(true);
				btnModificarHab.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_MODIFICAR_CLIENTE == idEvento || IDEventos.ERROR_CONSULTAR_CLIENTE_V_MODIFICAR == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}