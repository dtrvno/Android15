package com.example.order15;

import android.graphics.Bitmap;

public class ImageElement {
	Bitmap image = null;
	int orderx= 0;   
	int ordery=0;
	int elemx=0;   //left
	int elemy=0;   //top
	int id =0;
	int height =0;
	int weight=0;
	boolean isEmpty= false;
	ImageElement(Bitmap img,int x, int y)
	{
	   image=img;
	   orderx=x;
	   ordery=y;
	}
	ImageElement(Bitmap img,int x, int y, int height,int weight)
	{
	   image=img;
	   orderx=x;
	   ordery=y;
	   this.height=height;
	   this.weight=weight;
	}
	
	public int getOrderX()
	{
		return orderx;
	}
	public int getOrderY()
	{
		return ordery;
	}
	public void setId(int idd)
	{
		id=idd;
	}
	public int getId()
	{
		return id;
	}
	public Bitmap getBitmap()
	{
		return image;
	}
	
	public void setBitmap(Bitmap img)
	{
		image= img;
	}
	
	public void setCoordinate(int x, int y)
	{
		elemx=x;
		elemy=y;
	}
	public boolean isBelong(int x,int y)
	{   
		if(x>=elemx&&x<=elemx+weight&&y>=elemy&&y<=elemy+height)
		 return true;
		else
		 return false;	
	}
	
	public boolean isEmpty()
	{
		return isEmpty;
	}
	
	public void setEmpty(boolean status)
	{
		isEmpty=status;
	}
	
	public int getElemXLeft()
	{
		return elemx;
	}
	public int getElemYTop()
	{
		return elemy;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return weight;
	}
	

}
