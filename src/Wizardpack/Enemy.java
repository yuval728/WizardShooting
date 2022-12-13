package Wizardpack;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{

	private Handler handler;
	Random ran=new Random();
	int choose=0,hp=100;
	private BufferedImage[] image=new  BufferedImage[3];
	Animation anim;
	int lastx,lasty;
	public Enemy(int x, int y, ID id, Handler handler, Sprite ss) {
		super(x, y, id, ss);
		this.handler=handler;
		this.image[0]=ss.grabimage(4, 1, 32, 32);
		this.image[1]=ss.grabimage(5, 1, 32, 32);
		this.image[2]=ss.grabimage(6, 1, 32, 32);
		anim=new Animation(3, image[0],image[1],image[2]);
		this.lastx=x;
		this.lasty=y;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=velx;
		y+=vely;
		
		choose=ran.nextInt(10);
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Block)
			{
				if(getBoundsbig().intersects(temp.getBounds()))
				{
					x+=(velx*5)*-1;
					y+=(vely*4)*-1;
					velx*=-1;
					vely*=-1;
				}
				else if(choose==0)
				{
					velx=(ran.nextInt(4- -4)+ -4);
					vely=(ran.nextInt(4- -4)+ -4);
				}
			}
			if(temp.getId()==ID.Bullet)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					hp-=50;
					handler.removeobject(temp);
				}
					
			}
				 
		}
		
		if(x<=0 || x>=1064-2 || y<=0 || y>=563+56+6)
		{
//			handler.removeobject(this);
//			handler.addobject(new Enemy(lastx,lasty,ID.Enemy,handler, ss));
		}
		
		
		if(hp<=0) {
			handler.removeobject(this);
			Game.ene--;
			System.out.println(Game.ene);
		}
			
		
		anim.runAnimation();
		
	}
	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
//		g.drawRect(x-32,y-32,96,96);
			anim.drawAnimation(g, x, y, 0);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,32);
	}
	public Rectangle getBoundsbig() {
		// TODO Auto-generated method stub
		return new Rectangle(x-32,y-32,96,96);
	}

}
