package view;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

    public Tela(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JTabbedPane menu = new JTabbedPane();
        Icon noteIcone = new ImageIcon("src/images/note_icon.png");
        Icon whatsappIcone = new ImageIcon("src/images/whatsapp_icon.png");

        menu.addTab("Cadastro", noteIcone, new JPanel());
        menu.addTab("Compromissos", whatsappIcone, new JPanel());
        this.add(menu);

        this.setVisible(true);
    }

    static void main() {
        SwingUtilities.invokeLater(() -> new Tela("Gerenciador de Compromissos"));
    }

}
