package com.convexhull.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.convexhull.main.ConvexHull;
import com.convexhull.main.Main;

/**
 * Main JFrame to draw/hold all elements
 * 
 * @author clgdante
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = -7710305797957171021L;

	/**
	 * Create the frame, initialize components and make it visible
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
		pack();
		setVisible(true);
	}

	/**
	 * Initialize component
	 */
	private void initComponents() {
		final LinesComponent linesComp = new LinesComponent();
		linesComp.setPreferredSize(new Dimension(580, 520));
		// TODO: Figure out preferred HEIGHT / WIDTH and edit those values for drawing
		// lines accordingly
		getContentPane().add(linesComp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		JButton newLineButton = new JButton("New Line");
		JButton clearButton = new JButton("Clear Lines");
		buttonPanel.add(newLineButton);
		buttonPanel.add(clearButton);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		newLineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				linesComp.clearLines();
				ConvexHull ch = new ConvexHull(Main.POINTS, linesComp);
				ch.startAlgorithm();
				ch.drawLines();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				linesComp.clearLines();
			}
		});
	}
}
