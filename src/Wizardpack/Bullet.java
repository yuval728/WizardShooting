package Wizardpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	private Handler handler;
	public Bullet(int x, int y, ID id, Handler handler, int mx,int my, Sprite ss) {
		super(x, y, id, ss);
		this.handler=handler;
		
		velx=(mx-x)/10;
		vely=(my-y)/10;
		// TODO Auto-generated constructor stub
	}

	@Override 
	public void tick() {
		x+=velx;
		y+=vely;
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Block)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.removeobject(this);
				}
			}
				 
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 8, 8);
	}

	
	
}
