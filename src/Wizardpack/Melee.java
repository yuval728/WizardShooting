package Wizardpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Melee extends GameObject{

	private Handler handler;
	GameObject wiz;
//	int vx,vy;
	public Melee(int x, int y, ID id, Sprite ss, Handler handler,GameObject wiz,int vx,int vy) {
		super(x, y, id, ss);
		this.handler=handler;
		this.wiz=wiz;
		this.velx=vx;
		this.vely=vy;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
//		if(wiz.getX()<)
		x+=velx;
		y+=vely;
		
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 5, 20);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,5,20);
	}

}
