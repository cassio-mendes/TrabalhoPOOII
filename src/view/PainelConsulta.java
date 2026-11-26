package view;

import model.Compromisso;
import model.ConsultarCommand;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PainelConsulta extends JPanel {

    private JRadioButton antigosRBtn, recentesRBtn, concluidosRBtn, pendentesRBtn;
    private ButtonGroup grupoOrdenacao, grupoSituacao;

    private JTextField barraPesquisa;

    private JTextArea areaConsulta;
    private JScrollPane scrollPane;

    //Parâmetros para a consulta
    private static String ORDEM = "ANTIGOS";
    private static String FILTRO = "";
    private static String PESQUISA = "";

    private ConsultarCommand command = new ConsultarCommand();

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
        antigosRBtn.addActionListener(e -> {
            if(antigosRBtn.isSelected()) {
                ORDEM = "ANTIGOS";
                consultar();
            }
        });
        botoes1.add(antigosRBtn);

        recentesRBtn = new JRadioButton("Mais recentes", false);
        recentesRBtn.setFont(fonte);
        recentesRBtn.setFocusPainted(false);
        recentesRBtn.addActionListener(e -> {
            if(recentesRBtn.isSelected()) {
                ORDEM = "RECENTES";
                consultar();
            }
        });
        botoes1.add(recentesRBtn);

        grupoOrdenacao = new ButtonGroup();
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
        pendentesRBtn.addActionListener(e -> {
            FILTRO = pendentesRBtn.isSelected() ? "PENDENTES" : "";
            consultar();
        });
        botoes2.add(pendentesRBtn);

        concluidosRBtn = new JRadioButton("Concluídos", false);
        concluidosRBtn.setFont(fonte);
        concluidosRBtn.setFocusPainted(false);
        concluidosRBtn.addActionListener(e -> {
            FILTRO = concluidosRBtn.isSelected() ? "CONCLUIDOS" : "";
            consultar();
        });
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
        barraPesquisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER) { //Se o usuário apertar ENTER
                    PESQUISA = barraPesquisa.getText();
                    consultar();
                }
            }
        });
        this.add(barraPesquisa);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setFocusPainted(false);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setBounds(430, 180, 100, 30);
        limparBtn.addActionListener(e -> {
            barraPesquisa.setText("");
            PESQUISA = "";
            consultar();
        });
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

    public void consultar() {
        command.setOrdem(ORDEM);
        command.setFiltro(FILTRO);
        command.setPesquisa(PESQUISA);
        ArrayList<Compromisso> lista = (ArrayList<Compromisso>) command.execute();

        if(lista == null) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar compromissos", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else definirTexto(lista);
    }

    private void definirTexto(ArrayList<Compromisso> lista) {
        String texto = "";

        for(int i = 0; i < lista.size(); i++) {
            String situacao = lista.get(i).isSituacao() ? "Concluído" : "Pendente";

            texto += lista.get(i).getNomeCompromisso() + "\n" +
                    "Descrição: " + lista.get(i).getDescricao() + "\n" +
                    "Data: " + lista.get(i).getData() + "\n" +
                    "Horário: " + lista.get(i).getHorario() + "\n" +
                    "Contato: " + lista.get(i).getNomeContato() + "\n" +
                    "Telefone: " + lista.get(i).getTelefone() + "\n" +
                    "Situação: " + situacao + "\n\n";
        }

        areaConsulta.setText(texto);
    }

}
