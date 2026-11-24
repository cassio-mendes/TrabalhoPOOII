package view;

import model.Compromisso;
import model.EditarCommand;
import model.ExcluirCommand;
import model.ListarCommand;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class PainelEdicao extends JPanel {

    private PainelComponentes componentes;

    private JRadioButton pendenteRBtn, concluidoRBtn;
    private ButtonGroup btnGroup;

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

        btnGroup = new ButtonGroup();
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

                //Habilita a edição
                componentes.permitirEdicao(true);
                pendenteRBtn.setEnabled(true);
                concluidoRBtn.setEnabled(true);
            }
        });
        this.add(listaCompromissos);

        InvokerButton salvarBtn = new InvokerButton("SALVAR");
        salvarBtn.setFont(fonte);
        salvarBtn.setBackground(Color.WHITE);
        salvarBtn.setBounds(100, 575, 100, 30);
        salvarBtn.addActionListener(e -> {

            if(listaCompromissos.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um compromisso na lista",
                        "Compromisso faltando", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nome = componentes.getNome();
            String data = componentes.getData();
            String horario = componentes.getHorario();
            String contato = componentes.getContato();
            String telefone = componentes.getTelefone();

            //Informações faltando (a descrição é opcional)
            if(nome.isEmpty() || data.isEmpty() || horario.isEmpty() || contato.isEmpty() || telefone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os dados do " +
                        "compromisso (a descrição é opcional)", "Dados faltando", JOptionPane.WARNING_MESSAGE);
                return;
            }

            long id = listaCompromissos.getSelectedValue().getId();
            String descricao = componentes.getDescricao();
            boolean status = concluidoRBtn.isSelected();

            Compromisso c = new Compromisso(id, nome, descricao, data, horario, contato, telefone, status);

            salvarBtn.setCommand(new EditarCommand(c));
            boolean resultado = (Boolean) salvarBtn.invokeCommand();

            if(resultado) {
                JOptionPane.showMessageDialog(null, "Compromisso " + nome +
                        " atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                preencherLista(); //Atualizar lista
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o compromisso " + nome,
                        "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(salvarBtn);

        InvokerButton excluirBTn = new InvokerButton("EXCLUIR");
        excluirBTn.setFont(fonte);
        excluirBTn.setBackground(Color.WHITE);
        excluirBTn.setBounds(250, 575, 100, 30);
        excluirBTn.addActionListener(e -> {

            if(listaCompromissos.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um compromisso na lista",
                        "Compromisso faltando", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Compromisso c = listaCompromissos.getSelectedValue();
            excluirBTn.setCommand(new ExcluirCommand(c));

            boolean resultado = (Boolean) excluirBTn.invokeCommand();
            if(resultado) {
                JOptionPane.showMessageDialog(null, "Compromisso " + c.getNomeCompromisso() +
                        " excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                preencherLista(); //Atualiza a lista
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o compromisso " +
                        c.getNomeCompromisso(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });
        this.add(excluirBTn);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setBounds(400, 575, 100, 30);
        limparBtn.addActionListener(e -> {
            listaCompromissos.clearSelection();

            componentes.setNome("");
            componentes.setDescricao("");
            componentes.setData("");
            componentes.setHorario("");
            componentes.setContato("");
            componentes.setTelefone("");
            componentes.permitirEdicao(false);

            btnGroup.clearSelection();
            pendenteRBtn.setEnabled(false);
            concluidoRBtn.setEnabled(false);
        });
        this.add(limparBtn);

        componentes.permitirEdicao(false); //Os campos começam "trancados"
    }

    public void preencherLista() {
        ArrayList<Compromisso> listaCompleta = (ArrayList<Compromisso>) new ListarCommand().execute();

        //Atualiza a lista com os novos elementos
        listModel.removeAllElements();
        listModel.addAll(listaCompleta);

        //Limpa os campos de entrada
        componentes.limpar();
        componentes.permitirEdicao(false);
        btnGroup.clearSelection();
        pendenteRBtn.setEnabled(false);
        concluidoRBtn.setEnabled(false);
    }

}
