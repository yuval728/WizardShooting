package Wizardpack;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouseinput extends MouseAdapter{

	private Handler handler;
	private Camera camera;
	private Game game;
	private Sprite ss;
	public Mouseinput(Handler handler, Camera camera,Game game, Sprite ss)
	{
		this.handler=handler;
		this.camera=camera;
		this.game=game;
		this.ss=ss;
	}
	public void mousePressed(MouseEvent e)
	{
		int mx=(int)(e.getX()+camera.getX());
		int my=(int)(e.getY()+camera.getY());
		
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject temp=handler.object.get(i);
			if(temp.getId()==ID.Player &&game.ammo>0)
			{
				handler.addobject(new Bullet(temp.getX()+16,temp.getY()+24,ID.Bullet,handler,mx,my, ss));
				game.ammo--;
			}
				 
		}
	}
}
