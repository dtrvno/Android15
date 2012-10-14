package com.example.order15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

public class ParisImage {
	private Bitmap img; // the image of the ball
	private int coordX = 0; // the x coordinate at the canvas
	private int coordY = 0; // the y coordinate at the canvas
	public ParisImage(Context context, int drawable) {

		BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        img = BitmapFactory.decodeResource(context.getResources(), drawable); 
	}
	
	public ParisImage(Context context, int drawable, Point point) {

		BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        img = BitmapFactory.decodeResource(context.getResources(), drawable); 
		coordX= point.x;
		coordY = point.y;

	}
	public Bitmap getBitmap() {
		return img;
	}
}
