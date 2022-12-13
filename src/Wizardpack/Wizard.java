package Wizardpack;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Wizard extends GameObject{

	Handler handler;
	Game game;
	private BufferedImage[] image=new  BufferedImage[3];
	Animation anim;
	public Wizard(int x, int y, ID id, Handler handler, Game game, Sprite ss) {
		super(x, y, id, ss);
		// TODO Auto-generated constructor stub
		this.handler=handler;
		this.game=game;
		this.image[0]=ss.grabimage(1, 1, 32, 48);
		this.image[1]=ss.grabimage(2, 1, 32, 48);
		this.image[2]=ss.grabimage(3, 1, 32, 48);
		
		anim=new Animation(3, image[0],image[1],image[2]);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=velx;
		y+=vely;
		
		collision();
		if(handler.isUp()) vely=-5;
		else if(!handler.isDown()) vely=0;
		
		if(handler.isDown()) vely=5;
		else if(!handler.isUp()) vely=0;
		
		if(handler.isLeft()) velx=-5;
		else if(!handler.isRight()) velx=0;
		
		if(handler.isRight()) velx=5;
		else if(!handler.isLeft()) velx=0 ;
		
		anim.runAnimation();
//		System.out.println(game.ammo);
	}
	private void collision()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Block)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					x+=velx*-1;
					y+=vely*-1;
				}
			}
			if(temp.getId()==ID.Crate)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.removeobject(temp);
					game.ammo+=10;
				}
			}
			if(temp.getId()==ID.Enemy || temp.getId()==ID.Boss || temp.getId()==ID.Bossbullet )
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					game.health--;
				}
			}
			if(temp.getId()==ID.Door)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					x+=velx*-1;
					y+=vely*-1;
				}
			}
				 
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		if(velx==0 &&vely==0)
			g.drawImage(image[0], x, y, null);
		else
			anim.drawAnimation(g, x, y, 0);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y,32,48);
	}
	

}
