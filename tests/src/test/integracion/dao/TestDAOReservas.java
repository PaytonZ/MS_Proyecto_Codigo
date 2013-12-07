package test.integracion.dao;

import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.reservas.dao.DAOReserva;
import integracion.reservas.dao.imp.DAOReservaImp;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import negocio.reservas.transfer.TransferReserva;
@RunWith(JUnit4.class)
@FixMethodOrder
public class TestDAOReservas {

	@Test
	public void addReserva() {
		DAOReserva d = new DAOReservaImp();
		TransferReserva t = new TransferReserva();
		
		t.setDNI("5454");
		
		
	/*	Integer id = d.addReserva(t);
		
		assertNotNull(id);
		assertTrue(id >=0);
		
		*/
		
		
	}

	@Test
	public void  deleteReserva() {
	}
	@Test
	public void  getAllReservas() {
	}

	@Test
	public void  getReserva() {
	}

	@Test
	public void  updateReserva() {
	}
}
