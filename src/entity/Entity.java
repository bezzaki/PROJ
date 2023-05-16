package entity;

import java.awt.image.BufferedImage;

/**
 * Entit� de base du jeu
 *
 */
public abstract class Entity {
	public int worldX, worldY;				//position sur la map
	public int m_speed;					//D�placement de l'entite
	public BufferedImage m_idleImage,up,down,left,right;	//Une image de l'entite
	public String direction;
}
