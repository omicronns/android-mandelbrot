package com.omicronns.mandelbrot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MandelbrotView extends View {

	private Paint setPainter;
	byte[][] conv;
	
	private void init() {
		setPainter = new Paint();
		conv = MandelbrotThread.getConvergenceArray();
	}
	
	public MandelbrotView(Context context) {
		super(context);
		init();
	}

	public MandelbrotView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MandelbrotView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public void onDraw(Canvas canvas) {

		setPainter.setARGB(255, 255, 0, 0);
		setPainter.setStyle(Paint.Style.FILL_AND_STROKE);
		setPainter.setStrokeWidth(1);
	
		for(int i = 0; i < 500; ++i)
		{
			for(int j = 0; j < 500; ++j)
			{
				canvas.drawPoint(i, j, setPainter);
			}
		}
	}
}
