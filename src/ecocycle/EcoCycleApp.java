/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ecocycle;

import javax.swing.SwingUtilities;

public class EcoCycleApp {

    public static void main(String[] args) {

        // Launch the EcoCycle application
        SwingUtilities.invokeLater(() -> {
            new MainMenuFrame().setVisible(true);
        });

    }
}
     
