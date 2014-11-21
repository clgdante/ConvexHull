package com.convexhull.tools;

import java.util.Comparator;

import com.convexhull.components.Point;

/**
 * Compares two points by x-coordinate TODO: sort by y when x1==x2
 * 
 * @author clgdante
 *
 */
public class XComparator implements Comparator<Point> {
	@Override
	public int compare(Point a, Point b) {
		return a.getX() > b.getX() ? -1 : a.getX() == b.getX() ? 0 : 1;
	}

}
