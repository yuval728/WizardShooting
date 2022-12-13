package Wizardpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BossBullet extends GameObject{
	 Handler handler;
	public BossBullet(int x, int y, ID id, Sprite ss, Handler handler, GameObject wiz) {
		super(x, y, id, ss);
		this.handler=handler;
		
		float diffx=x- wiz.getX() -1; 
		float diffy=y- wiz.getY() -1;
		float distance = (float) Math.sqrt((x-wiz.getX())*(x-wiz.getX()) + (y-wiz.getY())*(y-wiz.getY()));
		
		
		velx= (float) ((-5.5/distance)*diffx);
		vely= (float) ((-5.5/distance)*diffy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,16,16);
	}
	

}
