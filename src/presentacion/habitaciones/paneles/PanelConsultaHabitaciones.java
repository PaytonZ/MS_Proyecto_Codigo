/**
 * 
 */
package presentacion.habitaciones.paneles;

import javax.swing.JPanel;

import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;
import negocio.habitaciones.transfer.TransferHabitacion;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class PanelConsultaHabitaciones extends JPanel implements GUIPanelesInterfaz {
	public PanelConsultaHabitaciones() {
		contentPane=this;
		
		setLayout(new MigLayout("", "[][][][][][21.00][192.00,grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblConsultaHabitacin = new JLabel("Consulta Habitación");
		add(lblConsultaHabitacin, "cell 5 1");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 2 7 1,growx,aligny center");
		
		JLabel lblNmeroDeHabitacion = new JLabel("Número de Habitacion");
		add(lblNmeroDeHabitacion, "cell 3 6");
		
		numhabconsultatext = new JTextField();
		add(numhabconsultatext, "cell 6 6,growx");
		numhabconsultatext.setColumns(10);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Integer numhab =Integer.valueOf(numhabconsultatext.getText());
					if ( numhab > 0 ) {
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_HABITACION, numhab);
					}
				}
				
					catch(NumberFormatException nu) {
						JOptionPane.showMessageDialog(contentPane, "El numero de habitacion contiene caracteres no numericos", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		add(btnConsulta, "cell 6 7");
		
		JLabel lblNumeroDeHabitacion = new JLabel("Numero de Habitacion");
		add(lblNumeroDeHabitacion, "cell 3 8");
		
		numHabtext = new JTextField();
		add(numHabtext, "cell 6 8,growx");
		numHabtext.setColumns(10);
		
		JLabel lblPrecioPorNoche = new JLabel("Precio por noche");
		add(lblPrecioPorNoche, "cell 3 9");
		
		precioText = new JTextField();
		add(precioText, "cell 6 9,growx");
		precioText.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		add(lblTipo, "cell 3 10");
		
		tipohabText = new JTextField();
		add(tipohabText, "cell 6 10,growx");
		tipohabText.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 12 7 1,growx,aligny center");
	}

	private static final long serialVersionUID = 1L;
	private JTextField numhabconsultatext;
	private JTextField numHabtext;
	private JTextField precioText;
	private JTextField tipohabText;
	private JPanel contentPane;

	@Override
	public void actualizarVentana(IDEventos idEvneto, Object datos) {
		
		if(idEvneto==IDEventos.ERROR_CONSULTAR_HABITACION)
			JOptionPane.showMessageDialog(contentPane, "Error al consultar habitacion!", "Error", JOptionPane.ERROR_MESSAGE);
		else if(datos==null)
			JOptionPane.showMessageDialog(contentPane, "No existe habitacion!", "Error", JOptionPane.ERROR_MESSAGE);
		else
		{
			TransferHabitacion t = (TransferHabitacion) datos;
			numHabtext.setText(String.valueOf(t.getNumHabitacion()));
			precioText.setText(String.valueOf(t.getPrecio()));
			tipohabText.setText((t.getTipohabitacion().toString()));
		}
		}
		
	}
