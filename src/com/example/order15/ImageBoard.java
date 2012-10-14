package com.example.order15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;

public class ImageBoard {
	int row=6;
	int column=5; 
	 private static final String DEBUG_TAG="TestDebug";
	 private ParisImage paris = null;
	int height,width,elemheight,elemwight=0;
	 Canvas canvas=null;
	 ImageElement [][]elem = new ImageElement[column][row];
	 ImageElement lastElem= null;
	 ImageElement emptyImage= null;
	 ImageBoard(Context context)
	 {
		 paris = new ParisImage(context,R.drawable.background,new Point(0,0));
		 init();
	 }
	 
	 private void init()
	 {
		height=paris.getBitmap().getHeight();
	    width=paris.getBitmap().getWidth();
	    elemheight= height/row;
	    elemwight=width/column; 
	    int k =1;
    	for(int i = 0; i < column; i ++)
        {
        	for (int j = 0; j < row; j++)
        	{
        		Bitmap img= Bitmap.createBitmap(paris.getBitmap(),elemwight*i,elemheight*j,
        				elemwight,elemheight);
        		elem[i][j] = new ImageElement(img,i,j,elemheight,elemwight);	        	
        	    elem[i][j].setId(k++);
        	}
        }	
    	
	    	
    	Bitmap emptyimg= Bitmap.createBitmap(elemwight,elemheight,elem[0][0].getBitmap().getConfig());	
    	emptyimg.eraseColor(Color.GRAY);
		ImageElement emptyimage = new ImageElement(emptyimg,column-1,row-1,elemheight,elemwight);
		emptyimage.setEmpty(true);
		emptyimage.setCoordinate((elemwight+1)*(column-1),(elemheight+1)*(row-1));
		lastElem = elem[column-1][row-1];
		elem[column-1][row-1]= emptyimage;
		emptyImage=emptyimage;
    		
	 }
	 void onDraw(Canvas canvas)
	 {
		 
	     this.canvas=canvas;
	     Log.i(DEBUG_TAG, "My Debug Message:"+ height +":" + width + ":" + elemheight +":" +elemwight  );
	    	
	     drawBorder(canvas);
 		 for(int i = 0; i < column; i ++)
          {
        	for (int j = 0; j < row; j++)
        	{
        		canvas.drawBitmap(elem[i][j].getBitmap(),(elemwight+1)*i,(elemheight+1)*j,null);
        		elem[i][j].setCoordinate((elemwight+1)*i, (elemheight+1)*j);
        	}
          }	
          
	    	
	 }
	 private void drawBorder(Canvas canvas)
	 {
		 canvas.drawLine(0, height+8, width+6, height+8, new Paint());
		 canvas.drawLine(width +6, 0, width+6, height+8, new Paint());
	 }
	 
	 public ImageElement getElement(int x,int y)
	 {
	    for(int i =0; i < column; i ++)
	    	
	    {
	    	for(int j = 0; j < row; j ++)
	    	{
	    		if(elem[i][j]==null) continue;
	    		if(elem[i][j].isBelong(x, y)) return elem[i][j];
	    	}
	    }
		return null; 
	 }
	 public ImageElement getEmptyImage()
	 {
		 return emptyImage;
	 }
	 public void change(ImageElement elem1,ImageElement elem2)
	 {
		 Bitmap bit1 = elem1.getBitmap();
		 Bitmap bit2 = elem2.getBitmap();
		 elem1.setBitmap(bit2);
		 elem2.setBitmap(bit1);
		 if(elem1.isEmpty) {
			 elem1.setEmpty(false);
			 elem2.setEmpty(true);
			 emptyImage=elem2;
		 }
		 else if(elem2.isEmpty)
		 {
			 elem2.setEmpty(false);
			 elem1.setEmpty(true);
			 emptyImage=elem1;
		 }
		 canvas.drawBitmap(elem1.getBitmap(),elem1.getElemXLeft(),elem1.getElemYTop(),null);
		 canvas.drawBitmap(elem2.getBitmap(),elem2.getElemXLeft(),elem2.getElemYTop(),null);
		 
	 }
	 
	 
}
