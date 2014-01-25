package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import presentacion.clientes.GUICliente;
import presentacion.departamentos.GUIDepartamentos;
import presentacion.empleados.GUIEmpleados;
import presentacion.habitaciones.GUIHabitaciones;
import presentacion.reservas.GUIReservas;
import presentacion.tareas.GUITareas;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnClientes;
	private JButton btnHabitaciones;
	private JButton btnReservas;
	private JButton btnDepartamentos;
	private JButton btnEmpleados;
	private JButton btnTareas;
	
	private FramePrincipal mySelf;

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		setPreferredSize(new Dimension(900, 500));
		setMinimumSize(new Dimension(100, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
		    
		    @Override
		    public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		    }
		});
		mntmSalir.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Salir16.png")));
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		mySelf = this;
		
		JMenuItem mntmDesarrolladores = new JMenuItem("BSoD Software");
		mntmDesarrolladores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Muestro el panel de bsodsoftware.
				new PanelAbout(mySelf).setVisible(true);
			}
		});
		mnAbout.add(mntmDesarrolladores);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setBackground(new Color(245, 245, 245));
		toolBar.setMinimumSize(new Dimension(13, 23));
		toolBar.setMaximumSize(new Dimension(150, 23));
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		Component cajaFlecibleIz = Box.createGlue();
		toolBar.add(cajaFlecibleIz);
		
		btnClientes = new JButton("Clientes");
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

				// Desactivo el botón ya pulsado
				btnClientes.setEnabled(false);
				
				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta clientes", GUICliente.getInstance().getPanelAltaClientes());
				tabbedPane.add("Baja clientes", GUICliente.getInstance().getPanelBajaClientes());
				tabbedPane.add("Modificación clientes", GUICliente.getInstance().getPanelModificacionClientes());
				tabbedPane.add("Consulta clientes", GUICliente.getInstance().getPanelConsultaClientes());
				tabbedPane.add("Consulta multiple clientes", GUICliente.getInstance().getPanelConsultaMultipleClientes());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();
				
				// Activo los botonos de las otras secciones
				btnHabitaciones.setEnabled(true);
				btnReservas.setEnabled(true);
				btnDepartamentos.setEnabled(true);
				btnEmpleados.setEnabled(true);
				btnTareas.setEnabled(true);
			}
		});
		toolBar.add(btnClientes);
		
		btnHabitaciones = new JButton("Habitaciones");
		btnHabitaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnHabitaciones.setForeground(Color.BLACK);
		btnHabitaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHabitaciones.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHabitaciones.setMnemonic(KeyEvent.VK_H);
		btnHabitaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHabitaciones.setToolTipText("Abre la sección de administración de clientes");

		btnHabitaciones.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Habitaciones64Over.png")));
		btnHabitaciones.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Habitaciones64.png")));
		
		btnHabitaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Desactivo el botón de habitaciones
				btnHabitaciones.setEnabled(false);
				
				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
				
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta habitaciones", GUIHabitaciones.getInstance().getPanelAltaHabitaciones());
				tabbedPane.add("Baja habitaciones", GUIHabitaciones.getInstance().getPanelBajaHabitaciones());
				tabbedPane.add("Modificación habitaciones", GUIHabitaciones.getInstance().getPanelModificacionHabitaciones());
				tabbedPane.add("Consulta habitaciones", GUIHabitaciones.getInstance().getPanelConsultaHabitaciones());
				tabbedPane.add("Consulta multiple habitaciones", GUIHabitaciones.getInstance().getPanelConsultaMultiplesHabitaciones());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();

				// Activo el resto de botones
				btnClientes.setEnabled(true);
				btnReservas.setEnabled(true);
				btnDepartamentos.setEnabled(true);
				btnEmpleados.setEnabled(true);
				btnTareas.setEnabled(true);
			}
		});
		
		toolBar.add(btnHabitaciones);
		
		btnReservas = new JButton("Reservas");
		btnReservas.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReservas.setForeground(Color.BLACK);
		btnReservas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReservas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReservas.setMnemonic(KeyEvent.VK_R);
		btnReservas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReservas.setToolTipText("Abre la sección de administración de clientes");

		btnReservas.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Reservas64Over.png")));
		btnReservas.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Reservas64.png")));
		
		btnReservas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnReservas.setEnabled(false);

				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
				
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta reservas", GUIReservas.getInstance().getPanelAltaReservas());
				tabbedPane.add("Baja reservas", GUIReservas.getInstance().getPanelBajaReservas());
				tabbedPane.add("Modificación reservas", GUIReservas.getInstance().getPanelModificacionReservas());
				tabbedPane.add("Consulta reservas", GUIReservas.getInstance().getPanelConsultaReservas());
				tabbedPane.add("Consulta multiple reservas", GUIReservas.getInstance().getPanelConsultaMultipleReservas());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();
				
				btnClientes.setEnabled(true);
				btnHabitaciones.setEnabled(true);
				btnDepartamentos.setEnabled(true);
				btnEmpleados.setEnabled(true);
				btnTareas.setEnabled(true);
			}
		});
		
		toolBar.add(btnReservas);
		
		btnDepartamentos = new JButton("Departamentos");
		btnDepartamentos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDepartamentos.setToolTipText("Abre la sección de administración de departamentos");
		btnDepartamentos.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Departamentos64Over.png")));
		btnDepartamentos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDepartamentos.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Departamentos64.png")));
		
		btnDepartamentos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnDepartamentos.setEnabled(false);

				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
				
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta departamento", GUIDepartamentos.getInstance().getPanelAltaDepartamentos());
				tabbedPane.add("Baja departamento", GUIDepartamentos.getInstance().getPanelBajaDepartamentos());
				tabbedPane.add("Modificación departamentos", GUIDepartamentos.getInstance().getPanelModificacionDepartamentos());
				tabbedPane.add("Consulta departamentos", GUIDepartamentos.getInstance().getPanelConsultaDepartamentos());
				tabbedPane.add("Consulta multiple departamentos", GUIDepartamentos.getInstance().getPanelConsultaMultiplesDepartamentos());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();
				
				btnClientes.setEnabled(true);
				btnHabitaciones.setEnabled(true);
				btnReservas.setEnabled(true);
				btnEmpleados.setEnabled(true);
				btnTareas.setEnabled(true);
			}
		});
		
		toolBar.add(btnDepartamentos);
		
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpleados.setMnemonic(KeyEvent.VK_E);
		btnEmpleados.setToolTipText("Abre la sección de administración de empleados");
		btnEmpleados.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpleados.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Empleados64.png")));
		btnEmpleados.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Empleados64Over.png")));
		
		btnEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnEmpleados.setEnabled(false);

				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
			
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta empleados", GUIEmpleados.getInstance().getPanelAltaEmpleados());
				tabbedPane.add("Baja empleados", GUIEmpleados.getInstance().getPanelBajaEmpleados());
				tabbedPane.add("Modificación empleados", GUIEmpleados.getInstance().getPanelModificacionEmpleados());
				tabbedPane.add("Consulta empleados", GUIEmpleados.getInstance().getPanelConsultaEmpleados());
				tabbedPane.add("Consulta multiple empleados", GUIEmpleados.getInstance().getPanelConsultaMultipleEmpleados());
				tabbedPane.add("Consulta empleados por tarea", GUIEmpleados.getInstance().getPanelConsutlaEmpleadosPorTarea());
				tabbedPane.add("Asignar tareas", GUIEmpleados.getInstance().getPanelAltaTareaEmpleados());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();
				
				btnClientes.setEnabled(true);
				btnHabitaciones.setEnabled(true);
				btnReservas.setEnabled(true);
				btnDepartamentos.setEnabled(true);
				btnTareas.setEnabled(true);
			}
		});
		
		toolBar.add(btnEmpleados);
		
		btnTareas = new JButton("Tareas");
		btnTareas.setRolloverIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Tareas64Over.png")));
		btnTareas.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Tareas64.png")));
		btnTareas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTareas.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnTareas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnTareas.setEnabled(false);

				Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
				
				if ( c != null ) {
					
					contentPane.remove(c);
					contentPane.repaint();
				}
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
				tabbedPane.add("Alta tareas", GUITareas.getInstance().getPanelAltaTareas());
				tabbedPane.add("Baja tareas", GUITareas.getInstance().getPanelBajaTareas());
				tabbedPane.add("Modificación tareas", GUITareas.getInstance().getPanelModificacionTareas());
				tabbedPane.add("Consulta tareas", GUITareas.getInstance().getPanelConsultaTarea());
				tabbedPane.add("Consulta multiple tareas", GUITareas.getInstance().getPanelConsultaMultipleTareas());
				
				contentPane.add(tabbedPane, BorderLayout.CENTER);
				contentPane.validate();
				
				btnClientes.setEnabled(true);
				btnHabitaciones.setEnabled(true);
				btnReservas.setEnabled(true);
				btnDepartamentos.setEnabled(true);
				btnEmpleados.setEnabled(true);
			}
		});
		
		toolBar.add(btnTareas);
		
		Component cajaFlecibleDr = Box.createGlue();
		toolBar.add(cajaFlecibleDr);
		
		setVisible(true);
	}
}
