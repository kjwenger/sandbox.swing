package com.u14n.sandbox.swing;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.u14n.sandbox.CoverageIgnore;

/**
 *
 */
public final class HelloWorldFrameMain {
    /**
     * Initial preferred width of content pane.
     * {@value}
     */
    private static final int CONTENT_WIDTH = 320;
    /**
     * Initial preferred height of content pane.
     * {@value}
     */
    private static final int CONTENT_HEIGHT = 320;

    /**
     * Hidden from instantiation.
     */
    @CoverageIgnore
    private HelloWorldFrameMain() {
        // Empty
    }

    /**
     * @param args
     *            Command line arguments provided at launch.
     */
    public static void main(final String[] args) {
        JFrame jFrame = new JFrame("Hello, World!");
        jFrame.getContentPane().setPreferredSize(
                new Dimension(CONTENT_WIDTH, CONTENT_HEIGHT));
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
