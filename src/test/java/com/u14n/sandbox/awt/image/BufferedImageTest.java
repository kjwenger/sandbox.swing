package com.u14n.sandbox.awt.image;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BufferedImageTest {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testDrawString() throws Exception {
        final File file = drawImage();

        final ShowPNG showPNG = new ShowPNG(file.getCanonicalPath());
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                showPNG.setVisible(true);
            }
        });
    }

    static File drawImage() throws IOException {
        final BufferedImage bufferedImage = new BufferedImage(
                WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2 = bufferedImage.createGraphics();
        g2.setColor(Color.WHITE);
        final Rectangle2D rectangle =
                new Rectangle2D.Double(0, 0, WIDTH, HEIGHT);
        g2.fill(rectangle);

        g2.setBackground(Color.WHITE);
        g2.setPaint(Color.BLACK);
        g2.setColor(Color.BLACK);
        g2.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
        g2.drawString("This is a test", 0, HEIGHT / 2);

        final File file = temporaryFolder.newFile(
                "BufferedImageTest#testDrawString.png");
        ImageIO.write(bufferedImage, "png", file);
        return file;
    }

}

class ShowPNG extends JFrame {

    public static void main(final String[] args) throws Exception {
        BufferedImageTest.temporaryFolder = new TemporaryFolder();
        BufferedImageTest.temporaryFolder.create();
        final File file = BufferedImageTest.drawImage();

        final ShowPNG showPNG = new ShowPNG(file.getCanonicalPath());
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                showPNG.pack();
                showPNG.setVisible(true);
            }
        });
        BufferedImageTest.temporaryFolder.delete();
    }

    public ShowPNG(final String arg) throws HeadlessException {
        if (arg == null )
            return;
        final JPanel panel = new JPanel();
        panel.setSize(WIDTH,HEIGHT);
        final ImageIcon icon = new ImageIcon(arg);
        final JLabel label = new JLabel();
        label.setIcon(icon);
        panel.add(label);
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}