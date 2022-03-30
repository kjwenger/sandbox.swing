package com.u14n.sandbox.swing;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JTabbedPane.*;

public class TabbedPaneMain {
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

    static void initLookAndFeel()
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.installLookAndFeel(
                FlatDarkLaf.NAME, FlatDarkLaf.class.getName());
        UIManager.installLookAndFeel(
                FlatDarculaLaf.NAME, FlatDarculaLaf.class.getName());
        UIManager.installLookAndFeel(
                FlatLightLaf.NAME, FlatLightLaf.class.getName());
        UIManager.installLookAndFeel(
                FlatIntelliJLaf.NAME, FlatIntelliJLaf.class.getName());
        UIManager.setLookAndFeel(FlatDarkLaf.class.getName());
    }

    public static void main(final String[] args) throws Exception {
        initLookAndFeel();

        JFrame jFrame = new JFrame("Tabbed Pane");
        JTabbedPane jTabbedPane = new JTabbedPane(TOP, SCROLL_TAB_LAYOUT);
        jTabbedPane.add("First", new JPanel());
        jTabbedPane.add("Second", new JPanel());
        jTabbedPane.add("Third", new JPanel());
        jTabbedPane.add("Fourth", new JPanel());
        jTabbedPane.add("Fifth", new JPanel());
        jTabbedPane.add("Sixth", new JPanel());
        jTabbedPane.add("Seventh", new JPanel());
        jTabbedPane.add("Eighth", new JPanel());
        jTabbedPane.add("Ninth", new JPanel());
        jTabbedPane.add("Tenth", new JPanel());
        jTabbedPane.add("Eleventh", new JPanel());
        jTabbedPane.add("Twelfth", new JPanel());
        jTabbedPane.add("Thirteenth", new JPanel());
        jTabbedPane.add("Fourteenth", new JPanel());
        jTabbedPane.add("Fifteenth", new JPanel());
        jTabbedPane.add("Sixteenth", new JPanel());
        jFrame.setContentPane(jTabbedPane);
        jFrame.getContentPane().setPreferredSize(
                new Dimension(CONTENT_WIDTH, CONTENT_HEIGHT));
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
