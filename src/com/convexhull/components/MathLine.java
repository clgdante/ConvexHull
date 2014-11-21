package com.convexhull.components;

/**
 * Line class for computing
 * 
 * ax + by = c <=> ax + by - c = 0
 * 
 * @author clgdante
 *
 */
public class MathLine {
	private double a, b, c;

	public MathLine(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Checks whether some point lies on this line
	 * 
	 * @param p
	 *            Point
	 * @return whether some point lies on line
	 */
	public boolean isPointOnLine(Point p) {
		return isPointOnLineWithThreshold(p, 0);
	}

	/**
	 * Checks whether some point lies near this line ( TODO: to the right of it bc
	 * pos.????)
	 * 
	 * @param p
	 *            Point
	 * @param t
	 *            Threshold
	 * @return whether point lies near line
	 */
	public boolean isPointOnLineWithThreshold(Point p, double t) {
		double computation = a * p.getX() + b * p.getY() - c;
		if (computation >= 0 && computation <= t) {
			return true;
		}
		return false;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public void setA(double a) {
		this.a = a;
	}

	public void setB(double b) {
		this.b = b;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return a + "x + " + b + "y = " + c;
	}
}
