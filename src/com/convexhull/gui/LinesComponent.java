package com.convexhull.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;

import com.convexhull.components.Line;
import com.convexhull.components.MathLine;
import com.convexhull.components.Point;

/**
 * JComponent for drawing a line
 * 
 * @author clgdante
 *
 */
public class LinesComponent extends JComponent {
	private static final long serialVersionUID = 7314702544094886625L;

	private final LinkedList<Line> lines = new LinkedList<Line>();

	/**
	 * Draw a red vertical line from a MathLine 520 pixels downward
	 * 
	 * @param mathLine
	 */
	public void drawVerticalLineFromMathLine(MathLine mathLine) {
		drawVerticalLine((int) mathLine.getC(), 0);
	}

	/**
	 * Draw a red vertical line for a point with x and y coords 520 pixels downward
	 * 
	 * @param x
	 *            x-coord of point
	 * @param y
	 *            y-coord of point
	 */
	public void drawVerticalLine(int x, int y) {
		drawVerticalLine(x, y, 520, Color.red);
	}

	/**
	 * Draw a red vertical line for a point p 520 pixels downward
	 * 
	 * @param p
	 *            Point
	 */
	public void drawVerticalLine(Point p) {
		drawVerticalLine(p, 520, Color.red);
	}

	/**
	 * Draw a colored vertical line for a point p x pixels downward
	 * 
	 * @param p
	 *            Point
	 * @param x
	 *            no of pixels downward
	 * @param color
	 *            Color
	 */
	public void drawVerticalLine(Point p, int x, Color color) {
		drawVerticalLine(p.getX(), p.getY(), x, color);
	}

	/**
	 * Draw a colored vertical line for a point with x and y coords down pixels downward
	 * 
	 * @param x
	 *            x-coord of point
	 * @param y
	 *            y-coord of point
	 * @param down
	 *            no of pixels the vertical line will go downward
	 * @param color
	 *            Color
	 */
	public void drawVerticalLine(int x, int y, int down, Color color) {
		addLine(x, y, x, y + down, color);
	}

	/**
	 * Draw a black line given two points
	 * 
	 * @param p1
	 *            first point
	 * @param p2
	 *            second point
	 */
	public void addLine(Point p1, Point p2) {
		addLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

	/**
	 * Draw a black line given coords of two points
	 * 
	 * @param x1
	 *            x-coord of first point
	 * @param y1
	 *            y-coord of first point
	 * @param x2
	 *            x-coord of second point
	 * @param y2
	 *            y-coord of second point
	 */
	public void addLine(int x1, int y1, int x2, int y2) {
		addLine(x1, y1, x2, y2, Color.black);
	}

	/**
	 * Draw a colored line given coords of two points
	 * 
	 * @param x1
	 *            x-coord of first point
	 * @param y1
	 *            y-coord of first point
	 * @param x2
	 *            x-coord of second point
	 * @param y2
	 *            y-coord of second point
	 * @param color
	 *            color of the line
	 */
	public void addLine(int x1, int y1, int x2, int y2, Color color) {
		lines.add(new Line(x1, y1, x2, y2, color));
		repaint();
	}

	/**
	 * Clears lines
	 */
	public void clearLines() {
		lines.clear();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Line line : lines) {
			g.setColor(line.color);
			g.drawLine(line.x1, 520 - line.y1, line.x2, 520 - line.y2);
		}
	}

}
