package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PainelConsulta extends JPanel {

    private JRadioButton antigosRBtn, recentesRBtn, concluidosRBtn, pendentesRBtn;
    private ButtonGroup grupoOrdenacao, grupoSituacao;

    private JTextField barraPesquisa;

    private JTextArea areaConsulta;
    private JScrollPane scrollPane;

    public PainelConsulta() {
        this.setLayout(null);

        Font fonte = new Font("Arial", Font.PLAIN, 16);
        LineBorder borda = new LineBorder(Color.BLACK, 1);

        //Opções de ordenação:
        JLabel ordenacaoLabel = new JLabel("Ordenar por:");
        ordenacaoLabel.setFont(fonte);
        ordenacaoLabel.setBounds(50, 30, 100, 20);
        this.add(ordenacaoLabel);

        JPanel botoes1 = new JPanel();
        botoes1.setBounds(50, 55, 180, 80);
        botoes1.setBorder(borda);
        this.add(botoes1);

        antigosRBtn = new JRadioButton("Mais antigos", true);
        antigosRBtn.setFont(fonte);
        antigosRBtn.setFocusPainted(false);
        botoes1.add(antigosRBtn);

        recentesRBtn = new JRadioButton("Mais recentes", false);
        recentesRBtn.setFont(fonte);
        recentesRBtn.setFocusPainted(false);
        botoes1.add(recentesRBtn);

        grupoOrdenacao = new ButtonGroupDesmarcavel();
        grupoOrdenacao.add(antigosRBtn);
        grupoOrdenacao.add(recentesRBtn);

        //Opções de filtragem por situação:
        JLabel situacaoLabel = new JLabel("Filtrar por:");
        situacaoLabel.setFont(fonte);
        situacaoLabel.setBounds(350, 30, 100, 20);
        this.add(situacaoLabel);

        JPanel botoes2 = new JPanel();
        botoes2.setBorder(borda);
        botoes2.setBounds(350, 55, 180, 80);
        this.add(botoes2);

        pendentesRBtn = new JRadioButton("Pendentes", false);
        pendentesRBtn.setFont(fonte);
        pendentesRBtn.setFocusPainted(false);
        botoes2.add(pendentesRBtn);

        concluidosRBtn = new JRadioButton("Concluídos", false);
        concluidosRBtn.setFont(fonte);
        concluidosRBtn.setFocusPainted(false);
        botoes2.add(concluidosRBtn);

        grupoSituacao = new ButtonGroupDesmarcavel();
        grupoSituacao.add(pendentesRBtn);
        grupoSituacao.add(concluidosRBtn);

        //Barra de pesquisa por nome:
        JLabel pesquisaLabel = new JLabel("Pesquisar por:");
        pesquisaLabel.setFont(fonte);
        pesquisaLabel.setBounds(50, 160, 130, 20);
        this.add(pesquisaLabel);

        barraPesquisa = new JTextField();
        barraPesquisa.setFont(fonte);
        barraPesquisa.setBorder(borda);
        barraPesquisa.setBounds(50, 185, 350, 25);
        this.add(barraPesquisa);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setFocusPainted(false);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setBounds(430, 180, 100, 30);
        this.add(limparBtn);

        //Área de consulta:
        areaConsulta = new JTextArea();
        areaConsulta.setFont(fonte);
        areaConsulta.setLineWrap(true);
        areaConsulta.setWrapStyleWord(true);
        areaConsulta.setEditable(false);

        scrollPane = new JScrollPane(areaConsulta);
        scrollPane.setBounds(50, 230, 500, 360);
        this.add(scrollPane);

    }

}
