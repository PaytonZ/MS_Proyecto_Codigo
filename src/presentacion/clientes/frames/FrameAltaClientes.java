package presentacion.clientes.frames;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import presentacion.clientes.GUIInterfazClientes;

public class FrameAltaClientes extends JPanel implements GUIInterfazClientes {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textDireccion;
	private JTextField textTelefono;

	/**
	 * Create the panel.
	 */
	public FrameAltaClientes() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAltaClientes = new JLabel("Alta clientes");
		lblAltaClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblAltaClientes, "4, 4, 40, 1, center, default");
		
		JSeparator separator = new JSeparator();
		add(separator, "2, 6, 43, 1");
		
		JLabel lblNombre = new JLabel("Nombre: ");
		add(lblNombre, "6, 12");
		
		textNombre = new JTextField();
		add(textNombre, "10, 12, 11, 1, fill, default");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		add(lblApellidos, "26, 12");
		
		textApellidos = new JTextField();
		add(textApellidos, "28, 12, 17, 1, fill, default");
		textApellidos.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Dirección: ");
		add(lblDireccin, "6, 16");
		
		textDireccion = new JTextField();
		add(textDireccion, "10, 16, 11, 1, fill, default");
		textDireccion.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		add(lblTelefono, "26, 16");
		
		textTelefono = new JTextField();
		add(textTelefono, "28, 16, 17, 1, fill, default");
		textTelefono.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		add(separator_1, "2, 20, 43, 1");
		
		JButton btnCancelar = new JButton("Cancelar");
		add(btnCancelar, "28, 22, 7, 1");
		
		JButton btnAceptar = new JButton("Aceptar");
		add(btnAceptar, "36, 22, 7, 1");

	}

	@Override
	public void actualizarVentana(Object datos) {
		// TODO Auto-generated method stub
		
	}

}
