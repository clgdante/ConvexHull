package com.convexhull.components;

import java.awt.Color;

/**
 * Line class for drawing
 * 
 * @author clgdante
 *
 */
public class Line {
	public final int x1, y1, x2, y2;
	public final Color color;

	public Line(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}
}
