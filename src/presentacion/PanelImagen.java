package presentacion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {

	private static final long serialVersionUID = 1L;

	private ImageIcon imagen;

	public PanelImagen(Image imagenaMostrar) {

		imagen = new ImageIcon(imagenaMostrar);

		init();
	}

	public PanelImagen(ImageIcon imagenaMostrar) {

		imagen = imagenaMostrar;

		init();
	}

	private void init() {
		setMinimumSize(new Dimension(imagen.getIconWidth(),
				imagen.getIconHeight()));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, null);
	}
}
