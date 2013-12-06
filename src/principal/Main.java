package principal;

import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import negocio.clientes.transfer.TransferCliente;

public class Main {

	public static void main(String[] args) {

		System.out.println("freakingDaniBOT.");
		TransferCliente c = new TransferCliente();
		c.setDNI("123456");
		c.setDireccion("asdasd");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);

		DAOCliente dao = new DAOClienteImp();
		Integer i = dao.addCliente(c);
		System.out.println(i);

		dao.deleteCliente(i);

	}

}
