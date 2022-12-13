package Wizardpack;

public class Camera {
	
	private float x,y;
	
	public Camera(float x, float y)
	{
		this.x=x;
		this.y=y;
	}
	public void tick(GameObject temp)
	{
		x+=((temp.getX()-x)-1000/2)*0.05f;
		y+=((temp.getY()-y)-563/2)*0.05f;
		
		if(x<=0) x=0;
		if(x>=1064-2) x=1056+6;
		if(y<=0) y=0;
		if(y>=1100+56+6-30) y=1070+56+6;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

}
