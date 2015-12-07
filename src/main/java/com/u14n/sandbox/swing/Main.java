package com.u14n.sandbox.swing;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 */
public class Main {
	/**
	 * Hidden from instantiation.
	 */
	@CoverageIgnore
	private Main() {
		// Empty
	}
	/**
	 * @param args Command line arguments provided at launch.
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Hello World");
		jFrame.getContentPane().setPreferredSize(new Dimension(320, 240));
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
