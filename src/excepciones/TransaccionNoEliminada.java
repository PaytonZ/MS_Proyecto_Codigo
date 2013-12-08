package excepciones;

public class TransaccionNoEliminada extends BSoDException {

	private static final long serialVersionUID = 1L;

	private String source;
	
	public TransaccionNoEliminada(String claseDondeOcurrioError) {
		super("La transacción no se pudo eliminar: ");
	}
	
	public String getMensajeCompleto() {
		
		return getMensaje() + source;
	}
	
	public String getOrigen() {
		
		return source;
	}
}
