package presentacion.clientes.paneles;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import presentacion.clientes.GUIInterfazClientes;

public class PanelAltaClientes extends JPanel implements GUIInterfazClientes {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;

	/**
	 * Create the panel.
	 */
	public PanelAltaClientes() {
		
		setPreferredSize(new Dimension(600, 400));
		setMinimumSize(new Dimension(100, 100));
		setLayout(new MigLayout("", "[120px][34px][161.00px][12.00px][67px][69.00px][96px][98.00px][53.00px]", "[16px][12px][28px][28px][12px][29px][][][]"));
		
		JLabel lblAltaClientes = new JLabel("Alta clientes");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "cell 2 0 6 1,alignx center,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 0 1 9 1,growx,aligny top");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "cell 0 3,alignx right,aligny center");
		
		textNombre = new JTextField();
		add(textNombre, "cell 2 3,growx,aligny top");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "cell 5 3,alignx left,aligny center");
		
		textApellidos = new JTextField();
		add(textApellidos, "cell 6 3 3 1,growx,aligny top");
		textApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección: ");
		add(lblDireccin, "cell 0 5,alignx right,aligny center");
		
		textDireccion = new JTextField();
		add(textDireccion, "cell 2 5,growx,aligny top");
		textDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		add(lblTelefono, "cell 5 5,growx,aligny center");
		
		textTelefono = new JTextField();
		add(textTelefono, "cell 6 5 2 1,growx,aligny top");
		textTelefono.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "cell 0 7 9 1,growx,aligny top");
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "cell 6 8,growx,aligny top");
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar, "cell 7 8,alignx left,aligny top");
	}

	@Override
	public void actualizarVentana(Object datos) {
		
	}
}
