package presentacion.principal;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import negocio.jpa.EntityManagerFactoryS;
import presentacion.FramePrincipal;

public class HotelManager {

    public final static String UNIDAD_PERSISTENCIA_ECLIPSELINK = "BSoD_PERSISTENCE_UNIT";

    private static Logger logger = Logger.getLogger(HotelManager.class
	    .getName());

    public static void main(String[] args) {

	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    try {
			UIManager
				.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		    } catch (Exception e) {
			logger.log(Level.WARNING,
				"No se ha podido cargar el look and feel personalizado.");
		    }

		    FramePrincipal frame = new FramePrincipal();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
	
	EntityManagerFactoryS.closeEntityManagerFactory();
	
    }
}
