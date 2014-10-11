package com.omicronns.mandelbrot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MandelbrotView extends View {
	
	private Bitmap btp;
	private boolean generated = false;
	
	private int convergence(double re, double im) {
		double sre = re;
		double sim = im;
		double sqre = re*re;
		double sqim = im*im;
		int iters = 0;
		for(int k = 0; k < 128; k += 5)
		{
			if(sqre + sqim > 4)
			{
				iters = k;
				break;
			}
			im = re*im;
			im += im;
			im += sim;
			re = sqre - sqim + sre;
			sqre = re*re;
			sqim = im*im;
		}
		return (iters) | (iters << 8) | (iters << 16) | 0xff000000;
	}
	
	private void generate(	int resX, int resY, double leftX, double rightX,
							double bottomY, double topY) {
		double width = rightX - leftX;
		double height = topY - bottomY;
		for(int i = 0; i < resX; ++i)
		{
			for(int j = 0; j < resY; ++j)
			{
				btp.setPixel(i, j, convergence(leftX + (width*i)/resX, bottomY + (height*j)/resY));
			}
		}
	}
	
	private void init() {
	}
	
	public MandelbrotView(Context context) {
		super(context);
		init();
	}

	public MandelbrotView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(!generated)
		{
			btp = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
			generate(getWidth(), getHeight(), -2, 2, -(2*getHeight())/getWidth(), (2*getHeight())/getWidth());
			generated = true;
		}
		canvas.drawBitmap(btp, getMatrix(), null);
	}
}
