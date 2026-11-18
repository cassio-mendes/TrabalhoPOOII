package view;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

    public Tela(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JTabbedPane menu = new JTabbedPane();
        Icon noteIcone = new ImageIcon("images/note_icon.png");
        Icon newIcone = new ImageIcon("images/new_icon.png");
        Icon lupaIcone = new ImageIcon("images/lupa_icon.png");
        Icon lixoIcone = new ImageIcon("images/trash_icon.png");
        Icon whatsappIcone = new ImageIcon("images/whatsapp_icon.png");
        Icon logIcone = new ImageIcon("images/log_icon.png");

        JPanel cadastrarTab = new JPanel();
        JPanel editarTab = new JPanel();
        JPanel consultarTab = new JPanel();
        JPanel excluirTab = new JPanel();
        JPanel compromissosTab = new JPanel();
        JPanel logTab = new JPanel();

        menu.addTab("Cadastrar", newIcone, cadastrarTab);
        menu.addTab("Editar", noteIcone, editarTab);
        menu.addTab("Consultar", lupaIcone, consultarTab);
        menu.addTab("Excluir", lixoIcone, excluirTab);
        menu.addTab("Compromissos", whatsappIcone, compromissosTab);
        menu.addTab("Log", logIcone, logTab);
        this.add(menu);

        preencherTelaAgendamento(cadastrarTab);
        preencherTelaCompromissos(compromissosTab);

        this.setVisible(true);
    }

    private void preencherTelaAgendamento(JPanel cadastrarTab) {
        cadastrarTab.setLayout(null);
        Font fonte = new Font("Arial", Font.PLAIN, 18);

        JLabel titulo = new JLabel("Cadastro de Compromissos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(145, 30, 400, 25);
        cadastrarTab.add(titulo);


    }

    private void preencherTelaCompromissos(JPanel compromissosTab) {

    }

    static void main() {
        SwingUtilities.invokeLater(() -> new Tela("Gerenciador de Compromissos"));
    }

}
