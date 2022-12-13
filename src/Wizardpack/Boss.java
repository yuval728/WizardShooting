package Wizardpack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss extends GameObject{

	Handler handler;
	int hp=100;
	private GameObject wiz,door;
	Random ran=new Random();
	public Boss(int x, int y, ID id, Sprite ss, Handler handler) {
		super(x, y, id, ss);
		this.handler=handler;
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId()==ID.Player) wiz=handler.object.get(i);
			if(handler.object.get(i).getId()==ID.Door) door=handler.object.get(i);
		// TODO Auto-generated constructor stub
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		int choose=ran.nextInt(100);
		if(wiz.getY()>(door.getY()+20))
		{
			x+=velx;
			y+=vely;
			float diffx=x- wiz.getX() -3; 
			float diffy=y- wiz.getY() -3;
			float distance = (float) Math.sqrt((x-wiz.getX())*(x-wiz.getX()) + (y-wiz.getY())*(y-wiz.getY()));
			
			
			velx= (float) ((-2.0/distance)*diffx);
			vely= (float) ((-2.0/distance)*diffy);
			if(choose==0)
				handler.addobject(new BossBullet(x+24,y+24,ID.Bossbullet, ss, handler, wiz));
		}
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Bullet)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					hp-=10;
					handler.removeobject(temp);
				}
			}
//			if(temp.getId()==ID.Bossmelee)
//			{
//				if(getBoundsmelee().in)
//			}
		}
		if(hp<=0)
			handler.removeobject(this);
		
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(x, y, 64, 64);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,64,64);
	}
	public Rectangle getBoundsmelee() {
		// TODO Auto-generated method stub
		return new Rectangle(x-32,y-32,96,96);
	}

}
