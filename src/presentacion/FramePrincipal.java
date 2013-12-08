package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		btnClientes.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClientes.setForeground(Color.BLACK);
		btnClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClientes.setOpaque(false);
		toolBar.add(btnClientes);
		btnClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClientes.setMnemonic(KeyEvent.VK_C);
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Abre la sección de administración de clientes");
		
		btnClientes.setIcon(new ImageIcon(FramePrincipal.class.getResource("/images/icons/Clientes64.png")));
		
		Component glue_1 = Box.createGlue();
		toolBar.add(glue_1);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
