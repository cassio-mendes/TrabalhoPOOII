package view;

import javax.swing.*;
import java.awt.*;

public class PainelCadastro extends JPanel {

    private PainelComponentes componentes;

    public PainelCadastro() {
        this.setLayout(null);
        Font fonte = new Font("Arial", Font.PLAIN, 16);

        componentes = new PainelComponentes("Cadastro de Compromissos");
        componentes.setBounds(30, 17, PainelComponentes.LARGURA, PainelComponentes.ALTURA);
        this.add(componentes);

        //Botões:
        JButton cadastrarBtn = new JButton("CADASTRAR");
        cadastrarBtn.setFont(fonte);
        cadastrarBtn.setBackground(Color.WHITE);
        cadastrarBtn.setFocusPainted(false);
        cadastrarBtn.setBounds(150, 340, 125, 30);
        cadastrarBtn.addActionListener(e -> {
            //Cadastro de compromisso:

        });
        this.add(cadastrarBtn);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setFocusPainted(false);
        limparBtn.setBounds(340, 340, 120, 30);
        limparBtn.addActionListener(e -> componentes.limpar());
        this.add(limparBtn);
    }

}
