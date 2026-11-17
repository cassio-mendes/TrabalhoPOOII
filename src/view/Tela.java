package view;

import javax.swing.*;

public class Tela extends JFrame {

    public Tela(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    static void main() {
        SwingUtilities.invokeLater(() -> new Tela("Gerenciador de Compromissos"));
    }

}
