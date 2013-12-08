package presentacion.comandos;

public enum  IDEventos {
	

	EVENTO_ALTA_CLIENTE(1001), ERROR_ALTA_CLIENTE(1002),
			EVENTO_BAJA_CLIENTE(1003), ERROR_BAJA_CLIENTE(1004),
			EVENTO_ACTUALIZAR_CLIENTE(1005), ERROR_ACTUALIZAR_CLIENTE(1006),
			EVENTO_BORRAR_CLIENTE(1007), ERROR_BORRAR_CLIENTE(1008),
			EVENTO_OBTENER_CLIENTE(1009), ERROR_OBTENER_CLIENTE(1010),
			EVENTO_OBTENER_TODOS_CLIENT(1011), ERROR_OBTENER_TODOS_CLIENTE(1012);

	private final int evento;
	
	private IDEventos(int evento)
	{
		this.evento=evento;
	}
	
	final int evento()
	{
		return evento;
	}

	
	
}
