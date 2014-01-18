/**
 * 
 */
package presentacion.empleados.paneles;

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

import negocio.departamentos.objetonegocio.Departamento;
import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.objetonegocio.Empleado.TipoEmpleado;
import negocio.excepciones.BSoDException;
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
public class PanelAltaEmpleados extends JPanel implements GUIPanelesInterfaz {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textSegundoApellido;
	private JTextField textDNI;
	private JTextField textPrimerApellido;
	
	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public PanelAltaEmpleados() {
		
		contentPane = this;
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px,grow][12.00px][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta empleados");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 9 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 9 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 0 3,alignx right,aligny center");
		
		textDNI = new JTextField();
		add(textDNI, "cell 2 3,growx");
		textDNI.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 5 3,alignx trailing");
		
		textPrimerApellido = new JTextField();
		add(textPrimerApellido, "cell 6 3 2 1,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 5,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 2 5,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo apellido: ");
		add(lblApellido2, "cell 5 5,alignx left,aligny center");
		
		textSegundoApellido = new JTextField();
		add(textSegundoApellido, "cell 6 5 2 1,growx,aligny top");
		textSegundoApellido.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Tipo: ");
		add(lblDireccin, "cell 0 7,alignx right,aligny center");
		
		JComboBox<TipoEmpleado> comboBox = new JComboBox<TipoEmpleado>();
		comboBox.setModel(new DefaultComboBoxModel<TipoEmpleado>(TipoEmpleado.values()));
		add(comboBox, "cell 2 7,growx");
		
		JLabel lblDepartamento = new JLabel("Departamento: ");
		add(lblDepartamento, "cell 5 7,alignx trailing");
		
		JComboBox<Departamento> comboBox_1 = new JComboBox<Departamento>();
		add(comboBox_1, "cell 6 7 2 1,growx");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 10 8 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Empleado empleado = new Empleado();
				
				if ( !textDNI.getText().equals("") 
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")) {
					
					empleado.setDNI(textDNI.getText());
					empleado.setNombre(textNombre.getText());
					
					if ( textPrimerApellido.getText().equals("") ) {
						JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						empleado.setPrimerApellido(textPrimerApellido.getText().trim());
						if ( !textSegundoApellido.getText().equals("") )
							empleado.setSegundoApellido(textSegundoApellido.getText().trim());
						
						ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_EMPLEADOS, empleado);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnAceptar, "cell 7 11,alignx left,aligny top");
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_CLIENTE == idEvento ) {
		
			if ( datos instanceof Integer ) {
				
				JOptionPane.showMessageDialog(contentPane, "Empleado creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	
				textDNI.setText("");
				textPrimerApellido.setText("");
				textSegundoApellido.setText("");
				textNombre.setText("");
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al dar de alta un empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_ALTA_CLIENTE == idEvento ) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}