package com.omicronns.mandelbrot;

public class MandelbrotThread extends Thread {

	private double leftX = -2;
	private double topY = -2;
	private double areaWidth = 4;
	private double areaHeight = 4;
	private static byte[][] convergenceArray = new byte[500][500];;

	private void init() {
	}
	
	public void setArea(double startX, double startY, double endX, double endY)
	{
	    leftX = startX;
	    topY = startY;
	    areaWidth = endX - startX;
	    areaHeight = endY - startY;
	}
	
	public static byte[][] getConvergenceArray() {
		return convergenceArray;
	}
	
	public MandelbrotThread(String name) {
		super(name);
		init();
		setPriority(NORM_PRIORITY);
	}

	public void run()
	{
	    for(int i = 0; i < 500; ++i)
	    {
	        for(int j = 0; j < 500; ++j) 
	        {
	            Complex point = new Complex(leftX + (i*areaWidth)/500, topY + (j*areaHeight)/500);
	    	    Complex startPoint = new Complex(point.re(), point.im());
	    	    convergenceArray[i][j] = 0;
	    	    for(int k = 1; k < 8; ++k)
	    	    {
	    	        if(point.abs2() > 4)
	    	        	convergenceArray[i][j] = (byte)k;
	    	        point.times(point);
	    	        point.plus(startPoint);
	    	    }
	        }
	    }
	    if(true)
	    	;
	}
}
