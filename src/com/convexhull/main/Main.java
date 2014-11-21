package com.convexhull.main;

import java.awt.Dimension;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.SwingUtilities;

import com.convexhull.components.Point;
import com.convexhull.gui.MainFrame;

/**
 * Program to compute the convex hull of some points and draw it
 * 
 * @author clgdante
 *
 */
public class Main {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;

	public static LinkedList<Point> POINTS = new LinkedList<Point>();

	public static void main(String[] args) {

		someTestPoints2();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final MainFrame mainFrame = new MainFrame();
				mainFrame.setTitle("Convex Hull");
				mainFrame.setResizable(false);
				mainFrame.setSize(new Dimension(WIDTH, HEIGHT));
				mainFrame.setLocationRelativeTo(null);
			}
		});
	}

	/**
	 * Creates some test points - TODO: Random points / let the user input points
	 */
	private static void someTestPoints() {
		POINTS.add(new Point(1, 1));
		POINTS.add(new Point(111, 17));
		POINTS.add(new Point(451, 21));
		POINTS.add(new Point(271, 157));
		POINTS.add(new Point(15, 401));
		POINTS.add(new Point(541, 351));
		POINTS.add(new Point(301, 511));

		// RESULT CH:
		// {(541,351), (451,21), (1,1), (15, 401), (301,511)}
	}

	/**
	 * Creates some test points - TODO: Random points / let the user input points
	 */
	private static void someTestPoints2() {
		POINTS.add(new Point(11, 199));
		POINTS.add(new Point(11, 198));
		POINTS.add(new Point(102, 21));
		POINTS.add(new Point(13, 5));
		POINTS.add(new Point(67, 511));
		POINTS.add(new Point(441, 31));
		POINTS.add(new Point(399, 488));

		// RESULT CH:
		// {(541,351), (451,21), (1,1), (15, 401), (301,511)}
	}

	/**
	 * Creates some test points - TODO: Random points / let the user input points
	 */
	private static void someTestPoints3() {
		POINTS.add(new Point(1, 1));
		POINTS.add(new Point(111, 17));
		POINTS.add(new Point(451, 21));
		POINTS.add(new Point(271, 157));
		POINTS.add(new Point(15, 401));
		POINTS.add(new Point(541, 351));
		POINTS.add(new Point(301, 511));

		// RESULT CH:
		// {(541,351), (451,21), (1,1), (15, 401), (301,511)}
	}

	/**
	 * Creates some test points - TODO: Random points / let the user input points
	 */
	private static void someTestPointsRandom() {
		for (int i = 0; i < 10; i++) {
			Random rng1 = new Random();
			Random rng2 = new Random();
			POINTS.add(new Point(rng1.nextInt(580), rng2.nextInt(520)));
		}
	}
}
