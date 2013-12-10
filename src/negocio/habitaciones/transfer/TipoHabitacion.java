package negocio.habitaciones.transfer;

public enum TipoHabitacion {

	 HABITACION_NORMAL("normal"), 
	 HABITACION_SUITE("suite");
	
	private String nombre;
	
	TipoHabitacion(String nombre) {
		
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
