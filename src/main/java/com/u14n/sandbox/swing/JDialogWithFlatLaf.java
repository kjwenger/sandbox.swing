package com.u14n.sandbox.swing;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class JDialogWithFlatLaf {
    private static final Logger logger =
            Logger.getLogger(JDialogWithFlatLaf.class.getName());

    @SuppressWarnings("unused")
    public static void placeOnScreen(
            final Window window,
            final int screen) {
        final Rectangle bounds = calculatePlacedBounds(window, screen);
        window.setBounds(bounds);
    }

    @SuppressWarnings("unused")
    public static void centerOnScreen(
            final Window window,
            final int screen) {
        final Rectangle bounds = calculateCenteredBounds(window, screen);
        window.setBounds(bounds);
    }

    private static Rectangle calculatePlacedBounds(
            final Window window, final int screen) {
        final Rectangle bounds = getScreenBounds(screen);
        final Point location = window.getLocation();
        final Dimension size = window.getSize();
        final Point placedLocation = calculatePlacedLocation(location, bounds);
        return new Rectangle(
                bounds.x + placedLocation.x, bounds.y + placedLocation.y,
                size.width, size.height);
    }

    private static Rectangle calculateCenteredBounds(
            final Window window, final int screen) {
        final Rectangle bounds = getScreenBounds(screen);
        final Dimension size = window.getSize();
        final Point location = calculateCenteredLocation(size, bounds);
        return new Rectangle(
                bounds.x + location.x, bounds.y + location.y,
                size.width, size.height);
    }

    public static Rectangle getScreenBounds(
            final int screen) {
        final GraphicsConfiguration graphicsConfiguration =
                getGraphicsConfiguration(screen);
        return graphicsConfiguration.getBounds();
    }

    public static Point calculatePlacedLocation(
            final Point location, final Rectangle bounds) {
        return new Point(bounds.x + location.x, bounds.y + location.y);
    }

    public static Point calculateCenteredLocation(
            final Dimension size, final Rectangle bounds) {
        final Dimension half =
                new Dimension(size.width / 2, size.height / 2);
        final Point center =
                new Point(bounds.width / 2, bounds.height / 2);
        return new Point(center.x - half.width, center.y - half.height);
    }

    @SuppressWarnings("unused")
    public static void placeTopLeftOnScreen(
            final Window window,
            final int screen) {
        final Rectangle placement = calculateTopLeftBounds(window, screen);
        window.setBounds(placement);
    }

    public static Rectangle calculateTopLeftBounds(
            final Window window, final int screen) {
        final Rectangle bounds = getScreenBounds(screen);
        final Point location = window.getLocation();
        final Dimension size = window.getSize();
        return new Rectangle(
                bounds.x + location.x, bounds.y + location.y,
                size.width, size.height);
    }

    @SuppressWarnings("unused")
    public static void investigateGraphics() {
        final GraphicsEnvironment graphicsEnvironment =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        logger.finest(String.format("graphicsEnvironment = %s",
                graphicsEnvironment));
        final GraphicsDevice[] graphicsDevices =
                graphicsEnvironment.getScreenDevices();
        for (final GraphicsDevice graphicsDevice : graphicsDevices) {
            logger.finest(String.format("graphicsDevice.getIDString() = %s",
                    graphicsDevice.getIDstring()));
            final Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
            if (fullScreenWindow != null)
                logger.finest(String.format("fullScreenWindow.getBounds() = %s",
                        fullScreenWindow.getBounds()));
            final GraphicsConfiguration[] graphicsConfigurations =
                    graphicsDevice.getConfigurations();
            for (final GraphicsConfiguration graphicsConfiguration
                    : graphicsConfigurations) {
                logger.finest(String.format("graphicsConfiguration = %s",
                        graphicsConfiguration));
                final Rectangle bounds = graphicsConfiguration.getBounds();
                logger.finest(String.format("bounds = %s", bounds));
            }
        }
    }

    public static GraphicsConfiguration getGraphicsConfiguration(int screen) {
        final GraphicsEnvironment graphicsEnvironment =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice[] graphicsDevices =
                graphicsEnvironment.getScreenDevices();
        GraphicsDevice graphicsDevice =
                graphicsEnvironment.getDefaultScreenDevice();
        GraphicsConfiguration graphicsConfiguration =
                graphicsDevice.getDefaultConfiguration();

        if (screen < 0)
            return graphicsConfiguration;
        if (graphicsDevices.length <= screen)
            return graphicsConfiguration;

        graphicsDevice = graphicsDevices[screen];

        if (graphicsDevice != null)
            graphicsConfiguration = graphicsDevice.getDefaultConfiguration();

        return graphicsConfiguration;
    }

    public static void main(final String[] args) throws Exception {
        UIManager.installLookAndFeel(
                FlatDarculaLaf.NAME, FlatDarculaLaf.class.getName());
        UIManager.setLookAndFeel(FlatDarculaLaf.class.getName());

        GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration(0);

        JFrame frame = new JFrame("KJW Frame", graphicsConfiguration);
//        frame.setLocation(0, 0);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JDialog dialog = new JDialog(frame, "KJW Dialog", true);
        dialog.setPreferredSize(new Dimension(800, 600));
        dialog.setResizable(true);
        dialog.setLayout(new BorderLayout());
        dialog.pack();
//        dialog.setLocationRelativeTo(frame);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

}
