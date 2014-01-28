/**
 * 
 */
package presentacion.empleados.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import negocio.empleados.objetonegocio.EmpleadoParcial;
import negocio.empleados.objetonegocio.EmpleadoTotal;
import negocio.empleados.objetonegocio.EmpleadoTotal.TipoPlazaParking;
import negocio.excepciones.BSoDException;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
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
	
	private JComboBox<TipoEmpleado> cbTipo;
	private JComboBox<Departamento> cbDepartamento;
	
	private JLabel lblHoras;
	private JTextField textHoras;
	private JLabel lblPlazaParking;
	private JComboBox<TipoPlazaParking> cbPlaza;

	/**
	 * Create the panel.
	 */
	public PanelAltaEmpleados() {
		
		contentPane = this;
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][161.00px,grow][67px][69.00px][96px,grow][98.00px][53.00px]", "[16px][12px][28px][28px][8.00][30.00px][7.00px][][][17.00][19.00][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta empleados");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 0 0 7 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 7 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 0 3,alignx right,aligny center");
		
		textDNI = new JTextField();
		add(textDNI, "cell 1 3,growx");
		textDNI.setColumns(10);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido: ");
		add(lblPrimerApellido, "cell 3 3,alignx trailing");
		
		textPrimerApellido = new JTextField();
		add(textPrimerApellido, "cell 4 3 2 1,growx");
		textPrimerApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 5,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 1 5,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("Segundo apellido: ");
		add(lblApellido2, "cell 3 5,alignx left,aligny center");
		
		textSegundoApellido = new JTextField();
		add(textSegundoApellido, "cell 4 5 2 1,growx,aligny top");
		textSegundoApellido.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Tipo: ");
		add(lblDireccin, "cell 0 7,alignx right,aligny center");
		
		cbTipo = new JComboBox<TipoEmpleado>();
		cbTipo.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent e) {

			if (cbTipo.getSelectedIndex() > -1) {
			    
			    if( cbTipo.getSelectedItem().equals(TipoEmpleado.COMPLETO)) {
				
				lblHoras.setVisible(false);
				textHoras.setVisible(false);
				lblPlazaParking.setVisible(true);
				cbPlaza.setVisible(true);
			    }
			    else if (cbTipo.getSelectedItem().equals(TipoEmpleado.HORAS)) {

				lblHoras.setVisible(true);
				textHoras.setVisible(true);
				lblPlazaParking.setVisible(false);
				cbPlaza.setVisible(false);
			    }
			}
		    }
		});
		cbTipo.setModel(new DefaultComboBoxModel<TipoEmpleado>(TipoEmpleado.values()));
		cbTipo.setSelectedIndex(-1);
		add(cbTipo, "cell 1 7,growx");
		
		JLabel lblDepartamento = new JLabel("Departamento: ");
		add(lblDepartamento, "cell 3 7,alignx trailing");
		
		cbDepartamento = new JComboBox<Departamento>();
		add(cbDepartamento, "cell 4 7 2 1,growx");
		
		JButton btnCargaDep = new JButton("");
		btnCargaDep.setToolTipText("Carga los departamentos disponibles");
		btnCargaDep.setPreferredSize(new Dimension(35, 35));
		btnCargaDep.setMaximumSize(new Dimension(30, 30));
		btnCargaDep.setMinimumSize(new Dimension(18, 18));
		btnCargaDep.setSize(new Dimension(35, 35));
		btnCargaDep.setIcon(new ImageIcon(PanelAltaEmpleados.class.getResource("/images/icons/RecargaDepartamentos.png")));
		
		btnCargaDep.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent arg0) {

			ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO, null);
		    }
		});
		
		add(btnCargaDep, "cell 6 7");
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setVisible(false);
		add(lblHoras, "cell 0 8,alignx trailing");
		
		textHoras = new JTextField();
		textHoras.setVisible(false);
		add(textHoras, "cell 1 8,growx");
		textHoras.setColumns(10);
		
		lblPlazaParking = new JLabel("Plaza parking:");
		lblPlazaParking.setVisible(false);
		add(lblPlazaParking, "cell 3 8,alignx trailing");
		
		cbPlaza = new JComboBox<>();
		cbPlaza.setVisible(false);
		cbPlaza.setModel(new DefaultComboBoxModel<TipoPlazaParking>(TipoPlazaParking.values()));
		add(cbPlaza, "cell 4 8 2 1,growx");
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 10 6 1,growx,aligny center");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Empleado empleado = null;
				
				if ( !textDNI.getText().equals("") 
						&& !textPrimerApellido.getText().equals("")
						&& !textSegundoApellido.getText().equals("") 
						&& !textNombre.getText().equals("")
						&& cbTipo.getSelectedIndex() > -1
						&& cbDepartamento.getSelectedIndex() > -1) {

					if ( textHoras.isVisible() ) {

					    if ( !textHoras.getText().trim().equals("")) {
						empleado = new EmpleadoParcial();
						
						try {
						    
						    if (Integer.valueOf(textHoras.getText().trim()) <= 7) {
							
							((EmpleadoParcial)empleado).setHoras( Integer.valueOf(textHoras.getText().trim()));
							   
							empleado.setDNI(textDNI.getText());
							empleado.setNombre(textNombre.getText());
							empleado.setTipo( (TipoEmpleado)cbTipo.getSelectedItem());
							empleado.setDepartamento( (Departamento)cbDepartamento.getSelectedItem());
							
							if ( textPrimerApellido.getText().equals("") ) {
								JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else {
								empleado.setPrimerApellido(textPrimerApellido.getText().trim());
								
								if ( !textSegundoApellido.getText().equals("") )
									empleado.setSegundoApellido(textSegundoApellido.getText().trim());
								
								ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_EMPLEADO, empleado);
							}
						    }
						    else {
							JOptionPane.showMessageDialog(contentPane, "Las horas no pueden superar 7", "Aviso", JOptionPane.WARNING_MESSAGE);
						    }
						}
						catch ( NumberFormatException nu) {
						    JOptionPane.showMessageDialog(contentPane, "Solo puede insertar números en las horas", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
					    }
					    else {
						JOptionPane.showMessageDialog(contentPane, "El campo horas no puede estar vacío", "Aviso", JOptionPane.WARNING_MESSAGE);
					    }
					}
					else if ( cbPlaza.isVisible() ) {
					    
					    if ( cbPlaza.getSelectedIndex() > -1) {
						
						empleado = new EmpleadoTotal();
						
						((EmpleadoTotal)empleado).setPlazaAparcamiento( (TipoPlazaParking)cbPlaza.getSelectedItem());

						empleado.setDNI(textDNI.getText());
						empleado.setNombre(textNombre.getText());
						empleado.setTipo( (TipoEmpleado)cbTipo.getSelectedItem());
						empleado.setDepartamento( (Departamento)cbDepartamento.getSelectedItem());
						
						if ( textPrimerApellido.getText().equals("") ) {
							JOptionPane.showMessageDialog(contentPane, "No ha introducido el primer apellido", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							empleado.setPrimerApellido(textPrimerApellido.getText().trim());
							
							if ( !textSegundoApellido.getText().equals("") )
								empleado.setSegundoApellido(textSegundoApellido.getText().trim());
							
							ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_EMPLEADO, empleado);
						}
					    }
					    else {
						JOptionPane.showMessageDialog(contentPane, "Debe seleccionar el tipo de plaza de parking", "Aviso", JOptionPane.WARNING_MESSAGE);
					    }
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No se pueden dejar campos sin rellenar", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(btnAceptar, "cell 5 11,alignx left,aligny top");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_EMPLEADO == idEvento ) {
		
			if ( datos instanceof Empleado ) {
				
				JOptionPane.showMessageDialog(contentPane, "Empleado creado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	
				textDNI.setText("");
				textPrimerApellido.setText("");
				textSegundoApellido.setText("");
				textNombre.setText("");
				
				cbTipo.setSelectedIndex(-1);
				cbDepartamento.setSelectedIndex(-1);
				
				lblHoras.setVisible(false);
				textHoras.setVisible(false);
				lblPlazaParking.setVisible(false);
				cbPlaza.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error al dar de alta un empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO == idEvento ) {
			
			if ( datos instanceof List) {
				
				List<Departamento> listaDepartamentos = (List<Departamento>) datos;
				
				DefaultComboBoxModel<Departamento> model = new DefaultComboBoxModel<Departamento>();
				
				for ( Departamento dep : listaDepartamentos ) {
					
					model.addElement(dep);
				}
				
				cbDepartamento.setModel(model);
			}
		}
		else if ( IDEventos.ERROR_ALTA_EMPLEADO == idEvento || IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO == idEvento) {
			
			if ( datos instanceof BSoDException ) {
				
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}