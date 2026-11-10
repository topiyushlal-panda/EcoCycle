package ecocycle;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Shared colours and styling so every EcoCycle screen matches the main menu.
 */
public class EcoStyle {

    // The colours used across the app
    public static final Color DARK_GREEN = new Color(29, 75, 55);
    public static final Color GREEN = new Color(55, 125, 85);
    public static final Color BACKGROUND = new Color(245, 249, 245);

    // The green heading shown at the top of each screen
    public static JPanel header(String title, String subtitle) {

        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.Y_AXIS));
        headingPanel.setBackground(DARK_GREEN);
        headingPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headingPanel.add(titleLabel);
        headingPanel.add(Box.createVerticalStrut(8));
        headingPanel.add(subtitleLabel);
        return headingPanel;
    }

    // Green button, same style as the main menu buttons
    public static void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(GREEN);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // White button with a green outline, used for the back buttons
    public static void styleBackButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBackground(Color.WHITE);
        button.setForeground(DARK_GREEN);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(GREEN, 2),
            BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // Table with a dark green header row
    public static void styleTable(JTable table) {

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(DARK_GREEN);
        header.setForeground(Color.WHITE);
    }

    // Label text used on the forms
    public static void styleLabel(JLabel label) {

        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(DARK_GREEN);
    }
}
