package tile;

import java.awt.image.BufferedImage;

/**
 * 
 * Element graphique de la carte
 */
public class Tile {
	public BufferedImage m_image;		//image
	public boolean m_collision;			//debut de gestion de collision entre element
	Tile(){
		m_collision = false;
		
	}
}
