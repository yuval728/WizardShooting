package Wizardpack;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crates extends GameObject{

	private Handler handler;
	private BufferedImage image;
	public Crates(int x, int y, ID id, Handler handler, Sprite ss) {
		super(x, y, id, ss);
		this.handler=handler;
		this.image=ss.grabimage(6, 2, 32, 32);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
//		g.setColor(Color.cyan);
//		g.fillRect(x, y, 32, 32);
		g.drawImage(image, x, y, null);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}
	

}
