/**
 * 
 */
package presentacion.habitaciones.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.excepciones.BSoDException;
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
public class PanelBajaHabitaciones extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	
	private JTextField textNumHabBusqueda;
	private JTextField textPrecioNoche;
	private JTextField textTipoHab;
	private Integer idHabitacion;
	private JButton btnBorrarHab;
	
	private JPanel contentPane;
	
	public PanelBajaHabitaciones() {
		
		setLayout(new MigLayout("", "[][][][grow][][][grow][]", "[][][17.00][][][20.00][15.00][][13.00][][][][]"));
		
		contentPane = this;
		
		JLabel lblBajaHab = new JLabel("Baja habitaciones");
		add(lblBajaHab, "cell 0 1 8 1,alignx center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblNumHab = new JLabel("Número de habitación: ");
		add(lblNumHab, "cell 2 4,alignx trailing");
		
		textNumHabBusqueda = new JTextField();
		add(textNumHabBusqueda, "cell 3 4 3 1,growx");
		textNumHabBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( !"".equals(textNumHabBusqueda.getText()) ) {
					
					try {
						
						Integer numHabitacion = Integer.valueOf(textNumHabBusqueda.getText().trim());
						
						if ( numHabitacion > 0 ) {
							
							ControladorAplicacion controladorAplicacion = ControladorAplicacion.getInstance();
							controladorAplicacion.handleRequest(IDEventos.EVENTO_CONSULTAR_HABITACION_V_BAJA, numHabitacion);
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "El número de habitación no puede ser negativo", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (NullPointerException nu) {
						JOptionPane.showMessageDialog(contentPane, "El campo número de habitación solo puede contener caractéres numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede ser vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 6 4");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 5 8 1,growx,aligny center");
		
		btnBorrarHab = new JButton("Borrar habitación");
		btnBorrarHab.setEnabled(false);
		btnBorrarHab.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( idHabitacion != null )
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_BAJA_HABITACION, idHabitacion);
				else
					JOptionPane.showMessageDialog(contentPane, "Error al cargar el cliente, búsquelo otra vez", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JLabel lblPrecioNoche = new JLabel("Precio por noche: ");
		add(lblPrecioNoche, "cell 2 7,alignx right");
		
		textPrecioNoche = new JTextField();
		textPrecioNoche.setEditable(false);
		add(textPrecioNoche, "cell 3 7,growx");
		textPrecioNoche.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		add(lblTipo, "cell 5 7,alignx trailing");
		
		textTipoHab = new JTextField();
		textTipoHab.setEditable(false);
		add(textTipoHab, "cell 6 7,growx");
		textTipoHab.setColumns(10);
		add(btnBorrarHab, "cell 5 12 2 1");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_BAJA_HABITACION == idEvento ) {
			
			if ( datos != null ) {
				if ( datos instanceof Boolean ) {
					
					Boolean correcto = (Boolean) datos;
					
					if ( correcto ) {
						textNumHabBusqueda.setText("");
						textNumHabBusqueda.setEditable(true);
						idHabitacion = null;
						textPrecioNoche.setText("");
						textTipoHab.setText("");
						btnBorrarHab.setEnabled(false);
						
						JOptionPane.showMessageDialog(this, "La habitación se ha borrado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					} 
					else {
						
						JOptionPane.showMessageDialog(this, "La habitación no se ha borrado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_HABITACION_V_BAJA == idEvento ) {

			if ( datos != null ) {
				if ( datos instanceof TransferHabitacion ) {
					
					TransferHabitacion hab = (TransferHabitacion) datos;
					
					textTipoHab.setText( hab.getTipohabitacion().toString() );
					textPrecioNoche.setText( String.valueOf(hab.getPrecio()) );
					idHabitacion = hab.getNumHabitacion();
					
					textNumHabBusqueda.setEditable(false);
					btnBorrarHab.setEnabled(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se ha podido obtener la habitación", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (IDEventos.ERROR_BAJA_HABITACION == idEvento || IDEventos.ERROR_CONSULTAR_HABITACION_V_BAJA == idEvento ) {
			
			if ( datos != null ) {
				
				if ( datos instanceof BSoDException ) {
					
					JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}