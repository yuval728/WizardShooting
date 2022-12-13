package Wizardpack;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends GameObject{

	private BufferedImage image;
	public Block(int x, int y, ID id, Sprite ss) {
		super(x, y, id, ss);
		image=ss.grabimage(5, 2, 32, 32);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		g.drawImage(image, x, y, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,32);
	}

	
}
