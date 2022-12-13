package Wizardpack;

import java.awt.Canvas;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	private boolean isrunning=false;
	private Thread thread;
	private Handler handler;
	private Camera camera;
	
	private BufferedImage level=null,sprite=null,floor=null;
	private Sprite spriteSheet;
	
	private int FPS;
	public int ammo=100,health=100;
	static int ene=0;
	public Game()
	{
		new Window(1000,563,"Wizard",this); 
		start();
		handler=new Handler();
		camera=new Camera(0,0);
		this.addKeyListener(new KeyInput(handler));
		
		
		
		BufferedImageloader loader=new BufferedImageloader();
		level=loader.loadImage("Map2.png");
		sprite=loader.loadImage("sprite-sheet.png");
		
		spriteSheet=new Sprite(sprite);
		floor=spriteSheet.grabimage(4, 2, 32, 32);
		
		this.addMouseListener(new Mouseinput(handler, camera,this, spriteSheet));
		
		loadlevel(level);
		
	}
	
	private void start()
	{
		isrunning=true;
		thread=new Thread(this);
		thread.start();
		
	}
	private void stop()
	{
		isrunning=false;
		try {
			thread.join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();
		long lasttime=System.nanoTime();
		double amountofticks=60.0,ns=1000000000/amountofticks,delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		while(isrunning)
		{
			long now=System.nanoTime();
			delta+=(now-lasttime)/ns;
			lasttime=now;
			while(delta>=1)
			{
				tick();
				delta--;
				//updates++;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000)
			{
				timer+=1000;
				FPS=frames;
//				System.out.println(frames);
				frames=0;
//				updates=0;
			}
		}
		stop(); 
	}
	public void tick()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId()==ID.Player)
				camera.tick(handler.object.get(i));
		}
		handler.tick();
		
	}
	public void render()
	{
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g=bs.getDrawGraphics();
		Graphics2D g2d=(Graphics2D)g;
		
		
//		g.setColor(Color.black);
//		g.fillRect(0, 0, 1000, 568); 
		
		g2d.translate(-camera.getX(), -camera.getY());
		
		for(int xx=0;xx<30*72;xx+=32)
		{
			for(int yy=0;yy<30*72;yy+=32)
			{
				g.drawImage(floor, xx, yy, null);
			}
		}
		
		handler.render(g);
		
		g2d.translate(camera.getX(), camera.getY());
		
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 32);
		g.setColor(Color.green);
		g.fillRect(5, 5, health*2, 32);
		g.setColor(Color.black);
		g.drawRect(5, 5, 200, 32);
		
		g.setColor(Color.white);
		g.drawString("Ammo:"+ammo, 5, 50);
		g.drawString("FPS:"+FPS,5,80);
		
		g.dispose();
		bs.show();
	}
	
	private void loadlevel(BufferedImage image)
	{
		int w=image.getWidth();
		int h=image.getHeight();
		
		for(int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel=image.getRGB(xx, yy);
				int red=(pixel >> 16) & 0xff;
				int green=(pixel >> 8) & 0xff;
				int blue=(pixel ) & 0xff;
				
				if(red==255 &&blue==0 &&(green==0 ||green==12))
					handler.addobject(new Block(xx*32,yy*32,ID.Block, spriteSheet));
				if(blue==255 &&green==0 &&red==0)
					handler.addobject(new Wizard(xx*32,yy*32,ID.Player,handler, this, spriteSheet));
				if(green==255 &&blue==0 &&red==0)
				{
					handler.addobject(new Enemy(xx*32,yy*32,ID.Enemy,handler, spriteSheet));
					ene++;
				}
					
				if(blue==255 &&green==255 &&red==0)
					handler.addobject(new Crates(xx*32,yy*32,ID.Crate,handler, spriteSheet));
				if(green==100 &&red==100 &&blue==100)
				{
					handler.addobject(new Door(xx*32,yy*32,ID.Door,spriteSheet, handler));
				}
				if(red==255 &&green==255 &&blue==0)
				{
					handler.addobject(new Boss(xx*32,yy*32,ID.Boss,spriteSheet, handler));
				}
			}
		}
	}
	public static void main(String args[])
	{
		new Game();
	}

	
	
}
