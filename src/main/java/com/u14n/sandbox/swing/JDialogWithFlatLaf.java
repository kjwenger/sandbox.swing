package com.u14n.sandbox.swing;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class JDialogWithFlatLaf {

    public static void main(final String[] args) throws Exception {
        UIManager.installLookAndFeel(
                FlatDarculaLaf.NAME, FlatDarculaLaf.class.getName());
        UIManager.setLookAndFeel(FlatDarculaLaf.class.getName());

        JFrame frame = new JFrame("KJW Frame");
        frame.setLocation(0, 0);
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JDialog dialog = new JDialog(frame, "KJW Dialog", true);
        dialog.setPreferredSize(new Dimension(800, 600));
        dialog.setResizable(true);
        dialog.setLayout(new BorderLayout());
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

}
