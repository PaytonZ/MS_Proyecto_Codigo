package negocio.excepciones;

public class BSoDException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	public BSoDException(String mensajeError) {
		
		mensaje = mensajeError;
	}
	
	public String getMensaje() {
		
		return mensaje;
	}
	
	public void setMensaje(String mensajeError) {
		
		mensaje = mensajeError;
	}
}
