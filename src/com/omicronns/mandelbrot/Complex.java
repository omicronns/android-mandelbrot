package com.omicronns.mandelbrot;

/*************************************************************************
 *  Compilation:  javac Complex.java
 *  Execution:    java Complex
 *
 *  Data type for complex numbers.
 *
 *  The data type is "immutable" so once you create and initialize
 *  a Complex object, you cannot change it. The "final" keyword
 *  when declaring re and im enforces this rule, making it a
 *  compile-time error to change the .re or .im fields after
 *  they've been initialized.
 *
 *  % java Complex
 *  a            = 5.0 + 6.0i
 *  b            = -3.0 + 4.0i
 *  Re(a)        = 5.0
 *  Im(a)        = 6.0
 *  b + a        = 2.0 + 10.0i
 *  a - b        = 8.0 + 2.0i
 *  a * b        = -39.0 + 2.0i
 *  b * a        = -39.0 + 2.0i
 *  a / b        = 0.36 - 1.52i
 *  (a / b) * b  = 5.0 + 6.0i
 *  conj(a)      = 5.0 - 6.0i
 *  |a|          = 7.810249675906654
 *  tan(a)       = -6.685231390246571E-6 + 1.0000103108981198i
 *
 *************************************************************************/

public class Complex {
    private double re;   // the real part
    private double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }
    // return abs/modulus/magnitude and angle/phase/argument
    public double abs2()   { return re*re + im*im; }

    // return a this object whose value is (this + b)
    public Complex plus(Complex b) {
    	re = re + b.re;
    	im = im + b.im;
    	return this;
    }

    // return a this object whose value is (this * b)
    public Complex times(Complex b) {
    	double are = re;
    	double aim = im;
    	double bre = b.re;
    	double bim = b.im;
    	re = are * bre - aim * bim;
    	im = are * bim + aim * bre;
    	return this;
    }
}
