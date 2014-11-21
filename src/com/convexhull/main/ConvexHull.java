package com.convexhull.main;

import java.util.LinkedList;

import com.convexhull.components.MathLine;
import com.convexhull.components.Point;
import com.convexhull.gui.LinesComponent;
import com.convexhull.tools.XComparator;

/**
 * Class to compute the Convex Hull of points given to the Constructor
 * 
 * @author clgdante
 *
 */
public class ConvexHull {
	private static final double ITERATION_STEP = 0.001;
	private LinkedList<Point> points = new LinkedList<Point>();
	LinkedList<Point> convexHull = new LinkedList<Point>();
	private MathLine mathLine;

	// JComponent to draw lines
	private LinesComponent linesComp;

	public ConvexHull(LinkedList<Point> points, LinesComponent linesComp) {
		this.points = points;
		this.linesComp = linesComp;
		sortPointsByX();
	}

	/**
	 * Algorithm used to determine the convex hull of the given points
	 */
	public void startAlgorithm() {
		System.out.println(points);
		boolean foundPoint;
		double a, b, c;
		Point originPoint = points.getFirst();
		Point currentPoint = originPoint;
		convexHull.add(originPoint);

		int stop = 0;

		// init
		a = 1;
		b = 0;
		c = currentPoint.getX();
		// create vertical line at first point
		mathLine = new MathLine(a, b, c);

		do {
			// add originPoint after second point is found so it can be found later to
			// conclude the algorithm
			if (convexHull.size() == 2) {
				points.add(originPoint);
			}
			// check if variables exceed limit // hard reset of variables (to allow
			// further rotation)
			if (a < -0.9 && b > -0.1) {
				a = 1;
				b = 0;
				c = currentPoint.getX();
				mathLine = new MathLine(a, b, c);
				System.out.println("CONDITION TRUE");
			}
			if (stop == 100) {
				break;
			}
			stop += 1;
			points.remove(currentPoint);

			// reset important variables
			foundPoint = false;

			// rotate - first quarter
			for (; b >= -1; b -= ITERATION_STEP) { // rotate line
				mathLine.setB(b);
				mathLine.setC(a * currentPoint.getX() + b * currentPoint.getY());

				// Check if point lies on (or near) line
				Point checkPoint = checkPoint();
				if (checkPoint.getX() == -1) {
				} else if (checkPoint.equals(originPoint)) {
					currentPoint = checkPoint;
					foundPoint = true;
					break;
				} else {
					convexHull.add(checkPoint);
					currentPoint = checkPoint;
					foundPoint = true;
					break;
				}

			}
			if (!foundPoint) {
				// rotate - second quarter
				for (; a >= 0; a -= ITERATION_STEP) { // rotate line
					mathLine.setA(a);
					mathLine.setC(a * currentPoint.getX() + b * currentPoint.getY());

					// Check if point lies on (or near) line
					Point checkPoint = checkPoint();
					if (checkPoint.getX() == -1) {
					} else if (checkPoint.equals(originPoint)) {
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					} else {
						convexHull.add(checkPoint);
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					}
				}
			}
			if (!foundPoint) {
				// rotate - third quarter
				for (; a >= -1; a -= ITERATION_STEP) { // rotate line
					mathLine.setA(a);
					mathLine.setC(a * currentPoint.getX() + b * currentPoint.getY());

					// Check if point lies on (or near) line
					Point checkPoint = checkPoint();
					if (checkPoint.getX() == -1) {
					} else if (checkPoint.equals(originPoint)) {
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					} else {
						convexHull.add(checkPoint);
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					}
				}
			}
			if (!foundPoint) {
				// rotate - fourth quarter
				for (; b <= 0; b += ITERATION_STEP) {
					// rotate line
					mathLine.setB(b);
					mathLine.setC(a * currentPoint.getX() + b * currentPoint.getY());

					// Check if point lies on (or near) line
					Point checkPoint = checkPoint();
					if (checkPoint.getX() == -1) {
					} else if (checkPoint.equals(originPoint)) {
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					} else {
						convexHull.add(checkPoint);
						currentPoint = checkPoint;
						foundPoint = true;
						break;
					}
				}
			}
		} while (currentPoint != originPoint);
		System.out.println("\nDONE");
		System.out.println(convexHull);
	}

	/**
	 * Checks whether one of the points lies on (or near) the line and returns it
	 * 
	 * @return point that lies on (or near) line
	 */
	private Point checkPoint() {
		for (Point p : points) {
			if (isPointOnLine(p)) {
				System.out.println(p + "===");
				return p;
			}
			if (isPointOnLineWithThreshold(p, 5)) {
				System.out.println(p + "~~~");
				return p;
			}
		}
		// if no point is found, return (-1, -1) as "not found"
		return new Point(-1, -1);
	}

	/**
	 * Checks if given point lies near (inside a certain positive threshold) the line
	 * 
	 * @param p
	 *            Point
	 * @param t
	 *            Threashold
	 * @return true is point lies near line
	 */
	private boolean isPointOnLineWithThreshold(Point p, double t) {
		return (mathLine.isPointOnLineWithThreshold(p, t));
	}

	/**
	 * Checks if given point lies on the line
	 * 
	 * @param p
	 *            Point
	 * 
	 * @return true if point lies on line
	 */

	private boolean isPointOnLine(Point p) {
		return (mathLine.isPointOnLineWithThreshold(p, 0));
	}

	/**
	 * Draws lines - used to show a graphical representation of the CH
	 */
	public void drawLines() {
		int size = convexHull.size();
		for (int i = 0; i < size - 1; i++) {
			linesComp.addLine(convexHull.get(i), convexHull.get(i + 1));
		}
		linesComp.addLine(convexHull.getFirst(), convexHull.getLast());
	}

	/**
	 * Sorts the Points by x-coord (highest x-coord first)
	 */
	private void sortPointsByX() {
		points.sort(new XComparator());
	}
}
