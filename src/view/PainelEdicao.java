package view;

import model.Compromisso;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PainelEdicao extends JPanel {

    private PainelComponentes componentes;

    private JRadioButton pendenteRBtn, concluidoRBtn;

    private JList<Compromisso> listaCompromissos;
    private DefaultListModel<Compromisso> listModel;

    public PainelEdicao() {
        this.setLayout(null);

        componentes = new PainelComponentes("Editar Compromissos");
        componentes.setBounds(30, 17, PainelComponentes.LARGURA, PainelComponentes.ALTURA);
        this.add(componentes);

        Font fonte = new Font("Arial", Font.PLAIN, 16);

        pendenteRBtn = new JRadioButton("Pendente...");
        pendenteRBtn.setFont(fonte);
        pendenteRBtn.setBounds(150, 350, 130, 20);
        this.add(pendenteRBtn);

        concluidoRBtn = new JRadioButton("Concluído!!");
        concluidoRBtn.setFont(fonte);
        concluidoRBtn.setBounds(300, 350, 120, 20);
        this.add(concluidoRBtn);

        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(concluidoRBtn);
        btnGroup.add(pendenteRBtn);

        listModel = new DefaultListModel<>();
        listaCompromissos = new JList<>(listModel);
        listaCompromissos.setFont(fonte);
        listaCompromissos.setBounds(50, 400, 500, 150);
        listaCompromissos.setBorder(new LineBorder(Color.BLACK, 1));
        this.add(listaCompromissos);

        JButton salvarBtn = new JButton("SALVAR");
        salvarBtn.setFont(fonte);
        salvarBtn.setBackground(Color.WHITE);
        salvarBtn.setBounds(100, 575, 100, 30);
        this.add(salvarBtn);

        JButton excluirBTn = new JButton("EXCLUIR");
        excluirBTn.setFont(fonte);
        excluirBTn.setBackground(Color.WHITE);
        excluirBTn.setBounds(250, 575, 100, 30);
        this.add(excluirBTn);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setBounds(400, 575, 100, 30);
        this.add(limparBtn);

    }

}
