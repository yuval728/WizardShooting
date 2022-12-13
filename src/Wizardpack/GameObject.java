package Wizardpack;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x,y;	
	protected float velx=0,vely=0;
	protected ID id;
	protected Sprite ss;
	
	public GameObject(int x,int y, ID id,Sprite ss)
	{
		this.x=x;
		this.y=y;
		this.id=id;
		this.ss=ss;
	}
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelx() {
		return velx;
	}

	public void setVelx(float velx) {
		this.velx = velx;
	}

	public float getVely() {
		return vely;
	}

	public void setVely(float vely) {
		this.vely = vely;
	}
	
}
