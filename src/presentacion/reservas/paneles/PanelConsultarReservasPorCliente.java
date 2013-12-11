package presentacion.reservas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.reservas.transfer.TransferReserva;
import net.miginfocom.swing.MigLayout;
import presentacion.GUIPanelesInterfaz;
import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

public class PanelConsultarReservasPorCliente extends JPanel implements GUIPanelesInterfaz {
	
	
	private JTextField textDNIBuscar;
	private JList<TransferReserva> list;
	
	private JPanel contentPane;
	
	public PanelConsultarReservasPorCliente() {
		
		contentPane = this;
		
		setLayout(new MigLayout("", "[][grow][][8.00,grow][][][][][61.00][][][][]", "[][15.00][6.00][][][][grow][][][][]"));
		
		JLabel lblConsultaReservasDe = new JLabel("Consulta reservas de cliente");
		add(lblConsultaReservasDe, "cell 0 0 13 1,alignx center,aligny center");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 1 12 1,growx,aligny center");
		
		JLabel lblDni = new JLabel("DNI: ");
		add(lblDni, "cell 2 3,alignx trailing");
		
		textDNIBuscar = new JTextField();
		add(textDNIBuscar, "cell 3 3 4 1,growx");
		textDNIBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if ( !textDNIBuscar.getText().equals("") ) {
					
					String dniCliente = textDNIBuscar.getText().trim();
					
					ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_RESERVAS_CLIENTE, dniCliente);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "El campo DNI no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(btnBuscar, "cell 8 3 3 1");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 4 12 1,growx,aligny center");
		
		JLabel lblNewLabel = new JLabel("Número de reserva");
		add(lblNewLabel, "cell 1 5 2 1");
		
		JLabel lblUsuario = new JLabel("Cliente");
		add(lblUsuario, "cell 4 5");
		
		JLabel lblNmeroDeHabitracin = new JLabel("Número de habitación");
		add(lblNmeroDeHabitracin, "cell 6 5");
		
		JLabel lblFechaReserva = new JLabel("Fecha reserva");
		add(lblFechaReserva, "cell 8 5");
		
		JLabel lblFechaEntrada = new JLabel("Fecha entrada");
		add(lblFechaEntrada, "cell 9 5");
		
		JLabel lblFechaSalida = new JLabel("Fecha salida");
		add(lblFechaSalida, "cell 11 5");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 6 12 5,grow");
		
		list = new JList<TransferReserva>();
		scrollPane.setViewportView(list);
	}

	@Override
	public void actualizarVentana(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE == idEvento ) {
			
			if ( datos instanceof List) {
				
				@SuppressWarnings("unchecked")
				List<TransferReserva> listaReservas = (List<TransferReserva>) datos;
				
				TransferReserva[] reservas = new TransferReserva[listaReservas.size()];
				
				list = new JList<>(reservas);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se encontraron reservas para este cliente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.EVENTO_CONSULTAR_CLIENTE_V_RESERVAS_CLIENTE == idEvento ) {

			
			if ( datos instanceof TransferCliente) {
				
				TransferCliente cliente = (TransferCliente) datos;
				
				ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE, cliente.getID());
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "No se pudo obtener el cliente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE == idEvento || IDEventos.EVENTO_CONSULTAR_CLIENTE_V_RESERVAS_CLIENTE == idEvento) {

			
			if ( datos instanceof BSoDException) {
				JOptionPane.showMessageDialog(contentPane, ((BSoDException)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
