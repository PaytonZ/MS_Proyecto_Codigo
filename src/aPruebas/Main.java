package aPruebas;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import negocio.clientes.transfer.TransferCliente;
import integracion.clientes.dao.imp.DAOClienteImp;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer id, id2;
		DAOClienteImp dao = new DAOClienteImp();
		TransferCliente tc = new TransferCliente();
		java.util.List<TransferCliente> clientes = dao.getAllClientes();
		
	}

}
