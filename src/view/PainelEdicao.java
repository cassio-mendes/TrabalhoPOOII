package view;

import model.Compromisso;
import model.ListarCommand;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

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
        listaCompromissos.addListSelectionListener(e -> {

            if(!listaCompromissos.isSelectionEmpty()) {
                Compromisso c = listaCompromissos.getSelectedValue();

                //Atualizando valores dos campos de entrada
                componentes.setNome(c.getNomeCompromisso());
                componentes.setDescricao(c.getDescricao());
                componentes.setData(c.getData());
                componentes.setHorario(c.getHorario());
                componentes.setContato(c.getNomeContato());
                componentes.setTelefone(c.getTelefone());

                if(c.isSituacao()) {
                    concluidoRBtn.setSelected(true);
                    pendenteRBtn.setSelected(false);
                } else {
                    pendenteRBtn.setSelected(true);
                    concluidoRBtn.setSelected(false);
                }
            }
        });
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

    public void preencherLista() {
        ArrayList<Compromisso> listaCompleta = (ArrayList<Compromisso>) new ListarCommand().execute();

        //Atualiza a lista com os novos elementos
        listModel.removeAllElements();
        listModel.addAll(listaCompleta);

        //Limpa os campos de entrada
        componentes.limpar();
        pendenteRBtn.setSelected(false);
        concluidoRBtn.setSelected(false);
    }

}
