package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

/**
 * Defintition du comportement d'un joueur
 *
 */
public class Player extends Entity{

	GamePanel m_gp;
	KeyHandler m_keyH;
	public final int screenX;
	public final int screenY;
	
	/**
	 * Constructeur de Player
	 * @param a_gp GamePanel, pannel principal du jeu
	 * @param a_keyH KeyHandler, gestionnaire des touches 
	 */
	public Player(GamePanel a_gp, KeyHandler a_keyH) {
		this.m_gp = a_gp;
		this.m_keyH = a_keyH;
		this.setDefaultValues();
		this.getPlayerImage();
		screenX = m_gp.SCREEN_WIDTH/2 - (m_gp.TILE_SIZE/2);
		screenY = m_gp.SCREEN_HEIGHT/2 - (m_gp.TILE_SIZE/2);
	}
	
	/**
	 * Initialisation des donn�es membres avec des valeurs par d�faut
	 */
	protected void setDefaultValues() {
		worldX = 200;
		worldY = 200;
		m_speed = 4;
		direction = "down";
	}
	
	/**
	 * R�cup�ration de l'image du personnage
	 */
	public void getPlayerImage() {
		//gestion des expections 
		try {
			up = ImageIO.read(getClass().getResource("/Player/Character3.png"));
			down = ImageIO.read(getClass().getResource("/Player/Character4.png"));
			left = ImageIO.read(getClass().getResource("/Player/Character2.png"));
			right = ImageIO.read(getClass().getResource("/Player/Character.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Mise � jour des donn�es du joueur
	 */
	public void update() {
		
			if(m_keyH.upPressed == true ) {
				direction = "up";
				worldY-= m_speed;
			}
			if(m_keyH.downPressed == true ) {
				direction = "down";
				worldY += m_speed;
			}
			if(m_keyH.leftPressed == true ) {
				direction = "left";
				worldX -= m_speed;
			}
			if(m_keyH.rightPressed == true) {
				direction = "right";
				worldX += m_speed;
			}
		
		
	}
	
	/**
	 * Affichage du l'image du joueur dans la fen�tre du jeu
	 * @param a_g2 Graphics2D 
	 */
	public void draw(Graphics2D a_g2) {
		// r�cup�re l'image du joueur
		BufferedImage l_image = null;
		switch(direction) {
		case "up":
			l_image = up;
			break;
		case "down":
			l_image = down;
			break;
		case "left":
			l_image = left;
			break;
		case "right":
			l_image = right;
			break;
		}
		a_g2.drawImage(l_image, screenX, screenY, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
		
		// affiche le personnage avec l'image "image", avec les coordonn�es x et y, et de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		
	}
	
	
}


