package com.example.order15;

import com.example.order15.ColorBall;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class DrawImageView extends ImageView
{
	 private static final String DEBUG_TAG="TestDebug";	 
	 ImageBoard brd=null;
	 int height,width,elemheight,elemwight=0;
	 int oldX,oldY=0;
	 ImageElement elem= null;
	 public DrawImageView(Context context) {
	        super(context);
	        setFocusable(true); //necessary for getting the touch events
	        brd=new ImageBoard(context);
	        this.setBackgroundColor(Color.GRAY);
	        this.setScaleType(ScaleType.FIT_XY);
	        
	 }
	 
	  
	    @Override protected void onDraw(Canvas canvas) {
	        //canvas.drawColor(0xFFCCCCCC);     //if you want another background color       
	        
	    	//draw the balls on the canvas
	    		    	
	    	brd.onDraw(canvas);
	    }
	    
	 public boolean onTouchEvent(MotionEvent event) 
	 {
	        int eventaction = event.getAction(); 
	        
	        int X = (int)event.getX(); 
	        int Y = (int)event.getY();
	        switch (eventaction ) { 

	           case MotionEvent.ACTION_DOWN: // touch down so check if the finger is on a ball
	        	   elem=brd.getElement(X,Y);
	        	   Log.i(DEBUG_TAG, "elem=" + elem);
	        	   if(elem==null) return false;
	        	   oldX=X;
	        	   oldY=Y;
	        	   break;    
	           case MotionEvent.ACTION_MOVE:
	        	   Log.i(DEBUG_TAG, "x=" + X + ",Y=" + Y + ",oldx=" + oldX +",oldY" + oldY);
//	        	   if(oldY-Y>10||Y-oldY>10) return false;    // we can move only horizontal or vertical
/*	        	   
	        	   if((oldY-Y<10||Y-oldY<10)&&X-oldX>0)
	        	      moveRight(elem);
	        	   else if((oldY-Y<10||Y-oldY<10)&&X-oldX<0)
	        		  moveLeft(elem);
	        	   else if((oldX-X<10||X-oldX<10)&&Y-oldY>0)
	        		  moveDown(elem); 
	        	   else if((oldX-X<10||X-oldX<10)&&Y-oldY<0)
		        	  moveUp(elem);
		        	  */
	           	   break;
	           case MotionEvent.ACTION_UP:
	        	   ImageElement elemdrop= brd.getElement(X,Y);	        	    
	        	   if(elemdrop.isEmpty)
	        	   {
	        		 if(!moveUp(elemdrop))
	        			 if(!moveDown(elemdrop))
	        				 if(!moveLeft(elemdrop))
	        					moveRight(elemdrop); 
	        	   }
	        	   oldX=oldY=0;
	        	   elem=null;
	        	   break;
	        }
	        
	        invalidate();
	        return true;
	 }
	 private boolean moveUp(ImageElement empty)
	 { 
		 if((elem.getOrderY()-1) !=empty.getOrderY()) return false;
		 if(elem.getOrderX()!=empty.getOrderX()) return false;
		 change(elem,empty);
		 return true;
	 }
	 private boolean moveDown(ImageElement empty)
	 {
		 if((elem.getOrderY()+1) !=empty.getOrderY()) return false;
		 if(elem.getOrderX()!=empty.getOrderX()) return false;
		 change(elem,empty);
		 return true;
	 }
	 private boolean moveLeft(ImageElement empty)
	 {
		 if((elem.getOrderX()-1) !=empty.getOrderX()) return false;
		 if(elem.getOrderY()!=empty.getOrderY()) return false;
		 change(elem,empty);
		 return true;
	 }
	 
	 
	 private boolean moveRight(ImageElement empty)
	 {
		 Log.i(DEBUG_TAG,"emptyImage=" + empty + ",elem=" + elem);
		 Log.i(DEBUG_TAG, "orderx=" + elem.getOrderX() + ",orderempx=" +empty.getOrderX() );
		 Log.i(DEBUG_TAG, "ordery=" + elem.getOrderY() + ",orderempy=" +empty.getOrderY() );
		 if((elem.getOrderX()+1) !=empty.getOrderX()) return false;
		 if(elem.getOrderY()!=empty.getOrderY()) return false;
		 change(elem,empty);
		 return true;
	 }
	 private void change(ImageElement elem1,ImageElement elem2)
	 {
	   Log.i(DEBUG_TAG,"Change element");	 
	   brd.change(elem1,elem2);
	   
	 }
}
