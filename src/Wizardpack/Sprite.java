package Wizardpack;

import java.awt.image.BufferedImage;

public class Sprite {
	private BufferedImage image;
	
	public Sprite(BufferedImage image)
	{
		this.image=image;
	}
	public  BufferedImage grabimage(int col,int row,int widht,int height)
	{
		return image.getSubimage((col*32)-32, (row*32)-32, widht, height);
	}
} 
