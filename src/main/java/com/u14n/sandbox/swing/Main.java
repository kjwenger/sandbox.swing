package com.u14n.sandbox.swing;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 */
public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Hello World");
		jFrame.getContentPane().setPreferredSize(new Dimension(320, 240));
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
