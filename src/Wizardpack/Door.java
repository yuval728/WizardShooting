package Wizardpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Door extends GameObject{
	Handler handler;
	
	public Door(int x, int y, ID id, Sprite ss, Handler handler) {
		super(x, y, id, ss);
		this.handler=handler;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(Game.ene==19)
		{
			handler.removeobject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,32);
	}

}
