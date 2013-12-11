package presentacion.comandos;

public enum IDEventos {
	/* CLIENTES */
	EVENTO_ALTA_CLIENTE, ERROR_ALTA_CLIENTE,
	EVENTO_BAJA_CLIENTE, ERROR_BAJA_CLIENTE,
	EVENTO_MODIFICAR_CLIENTE, ERROR_MODIFICAR_CLIENTE,
	EVENTO_CONSULTAR_CLIENTE, ERROR_CONSULTAR_CLIENTE,
	EVENTO_CONSULTAR_TODOS_CLIENTE, ERROR_CONSULTAR_TODOS_CLIENTE,
	EVENTO_CONSULTAR_CLIENTE_V_BORRAR, ERROR_CONSULTAR_CLIENTE_V_BORRAR,
	EVENTO_CONSULTAR_CLIENTE_V_MODIFICAR, ERROR_CONSULTAR_CLIENTE_V_MODIFICAR,
	/* RESERVAS */
	EVENTO_ALTA_RESERVA, ERROR_ALTA_RESERVA,
	EVENTO_BAJA_RESERVA, ERROR_BAJA_RESERVA,
	EVENTO_MODIFICAR_RESERVA, ERROR_MODIFICAR_RESERVA,
	EVENTO_CONSULTAR_RESERVA, ERROR_CONSULTAR_RESERVA,
	EVENTO_CONSULTAR_TODAS_RESERVAS, ERROR_CONSULTAR_TODAS_RESERVAS,
	EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS, ERROR_CONSULTAR_CLIENTE_V_ALTA_RESERVAS,
	EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS, ERROR_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS,
	EVENTO_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE, ERROR_CONSULTAR_TODAS_RESERVAS_POR_CLIENTE,
	/* HABITACIONES */
	EVENTO_ALTA_HABITACION, ERROR_ALTA_HABITACION,
	EVENTO_BAJA_HABITACION, ERROR_BAJA_HABITACION,
	EVENTO_MODIFICAR_HABITACION, ERROR_MODIFICAR_HABITACION,
	EVENTO_CONSULTAR_HABITACION, ERROR_CONSULTAR_HABITACION,
	EVENTO_CONSULTAR_TODAS_HABITACION, ERROR_CONSULTAR_TODAS_HABITACION,
	EVENTO_CONSULTAR_HABITACION_V_ALTA, ERROR_CONSULTAR_HABITACION_V_ALTA,
	EVENTO_CONSULTAR_HABITACION_V_BAJA, ERROR_CONSULTAR_HABITACION_V_BAJA,
	EVENTO_CONSULTAR_HABITACION_V_MODIFICAR, ERROR_CONSULTAR_HABITACION_V_MODIFICAR,
}
