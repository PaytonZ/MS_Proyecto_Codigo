package presentacion;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class PanelAbout extends JDialog {

	private static final long serialVersionUID = 1L;

	private FramePrincipal ventana;

	public PanelAbout(FramePrincipal ventanaPrincipal) {

		ventana = ventanaPrincipal;

		Init();
	}

	private void Init() {

	    ImageIcon icon = new ImageIcon(PanelAbout.class.getResource("/images/icons/about.jpg"));
	    
		setBounds(ventana.getWidth() / 2 - this.getWidth() / 2, ventana.getY(), icon.getIconWidth(), icon.getIconHeight());

		add(new PanelImagen(icon));
	}
}
