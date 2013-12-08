package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import presentacion.clientes.GUICliente;
import presentacion.clientes.paneles.PanelAltaClientes;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 743);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Salir16.png")));
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setBackground(new Color(245, 245, 245));
		toolBar.setMinimumSize(new Dimension(13, 23));
		toolBar.setMaximumSize(new Dimension(150, 23));
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		Component glue = Box.createGlue();
		toolBar.add(glue);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setIconTextGap(12);
		btnClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClientes.setVerticalAlignment(SwingConstants.CENTER);
		btnClientes.setMaximumSize(new Dimension(74, 400));
		btnClientes.setForeground(Color.BLACK);
		btnClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClientes.setMnemonic(KeyEvent.VK_C);
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Abre la sección de administración de clientes");
		btnClientes.requestFocus(true);
		
		btnClientes.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Clientes64Over.png")));
		btnClientes.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Clientes64.png")));
		
		btnClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PanelAltaClientes frameAlta = GUICliente.getInstance().getPanelAltaClientes();
				frameAlta.setAlignmentX(Component.CENTER_ALIGNMENT);
				frameAlta.setAlignmentY(Component.TOP_ALIGNMENT);
				
				contentPane.add(frameAlta, BorderLayout.CENTER);
				contentPane.validate();
			}
		});
		toolBar.add(btnClientes);
		
		JButton btnHabitaciones = new JButton("Habitaciones");
		btnHabitaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnHabitaciones.setForeground(Color.BLACK);
		btnHabitaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabitaciones.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHabitaciones.setMnemonic(KeyEvent.VK_C);
		btnHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHabitaciones.setToolTipText("Abre la sección de administración de clientes");

		btnHabitaciones.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Habitaciones64Over.png")));
		btnHabitaciones.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Habitaciones64.png")));
		toolBar.add(btnHabitaciones);
		
		JButton btnReservas = new JButton("Reservas");
		btnReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReservas.setForeground(Color.BLACK);
		btnReservas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReservas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReservas.setMnemonic(KeyEvent.VK_C);
		btnReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservas.setToolTipText("Abre la sección de administración de clientes");

		btnReservas.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Reservas64Over.png")));
		btnReservas.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Reservas64.png")));
		toolBar.add(btnReservas);
		
		Component glue_1 = Box.createGlue();
		toolBar.add(glue_1);
	}
}
