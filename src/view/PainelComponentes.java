package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class PainelComponentes extends JPanel {

    //Dimensões do painel
    public static final int LARGURA = 542;
    public static final int ALTURA = 315;

    private JTextField nomeField;
    private JTextField contatoField;

    private JScrollPane descricaoScroll;
    private JTextArea descricaoArea;

    private JFormattedTextField dataField;
    private JFormattedTextField horarioField;
    private JFormattedTextField telefoneField;

    public PainelComponentes(String tituloTexto) {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(LARGURA, ALTURA));

        Font fonte = new Font("Arial", Font.PLAIN, 16);
        LineBorder borda = new LineBorder(Color.BLACK, 1);

        JLabel titulo = new JLabel(tituloTexto);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(115, 13, 400, 25);
        this.add(titulo);

        JLabel nomeLabel = new JLabel("Nome: ");
        nomeLabel.setFont(fonte);
        nomeLabel.setBounds(49, 73, 60, 18);
        this.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setFont(fonte);
        nomeField.setBounds(110, 73, 300, 20);
        nomeField.setBorder(borda);
        this.add(nomeField);

        JLabel descricaoLabel = new JLabel("Descrição: ");
        descricaoLabel.setFont(fonte);
        descricaoLabel.setBounds(20, 103, 90, 18);
        this.add(descricaoLabel);

        //Área de texto para a descrição
        descricaoArea = new JTextArea();
        descricaoArea.setFont(fonte);
        descricaoArea.setBorder(borda);
        descricaoArea.setLineWrap(true);      //Quebra a linha quando a palavra não cabe
        descricaoArea.setWrapStyleWord(true); //Envia a palavra inteira para a próxima linha

        //Painel com barra de rolagem para visualizar múltiplas linhas
        descricaoScroll = new JScrollPane(descricaoArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descricaoScroll.setBounds(110, 103, 400, 75);
        this.add(descricaoScroll);

        JLabel dataLabel = new JLabel("Data: ");
        dataLabel.setFont(fonte);
        dataLabel.setBounds(60, 188, 80, 20);
        this.add(dataLabel);

        //Configurando campo de texto formatado para datas
        try {
            MaskFormatter dataFormatter = new MaskFormatter("##/##/####");
            dataFormatter.setPlaceholderCharacter('_');

            dataField = new JFormattedTextField(dataFormatter);
            dataField.setFont(fonte);
            dataField.setBounds(110, 188, 90, 20);
            this.add(dataField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo de data", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        JLabel horarioLabel = new JLabel("Horário: ");
        horarioLabel.setFont(fonte);
        horarioLabel.setBounds(38, 218, 90, 20);
        this.add(horarioLabel);

        //Configurando campo de texto formatado para horários
        try {
            MaskFormatter horarioFormatter = new MaskFormatter("## : ##");
            horarioFormatter.setPlaceholderCharacter('_');

            horarioField = new JFormattedTextField(horarioFormatter);
            horarioField.setFont(fonte);
            horarioField.setBounds(110, 218, 55, 20);
            this.add(horarioField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo do horário", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        JLabel contatoLabel = new JLabel("Contato: ");
        contatoLabel.setFont(fonte);
        contatoLabel.setBounds(36, 248, 90, 20);
        this.add(contatoLabel);

        contatoField = new JTextField();
        contatoField.setFont(fonte);
        contatoField.setBounds(110, 248, 300, 20);
        contatoField.setBorder(borda);
        this.add(contatoField);

        JLabel telefoneLabel = new JLabel("Whatsapp: ");
        telefoneLabel.setFont(fonte);
        telefoneLabel.setBounds(20, 278, 90, 20);
        this.add(telefoneLabel);

        //Configurando campo de texto formatado para números de telefone (whatsapp)
        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("+## (##) ##### - ####");
            telefoneFormatter.setPlaceholderCharacter('_');

            telefoneField = new JFormattedTextField(telefoneFormatter);
            telefoneField.setFont(fonte);
            telefoneField.setBounds(110, 278, 170, 20);
            this.add(telefoneField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo de telefone", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
    }

    //Limpa todos os campos
    public void limpar() {
        nomeField.setText("");
        descricaoArea.setText("");
        dataField.setValue(null);
        horarioField.setValue(null);
        contatoField.setText("");
        telefoneField.setValue(null);
    }

    //Getters para os valores digitados
    public String getNome() {
        return nomeField.getText();
    }

    public String getDescricao() {
        return descricaoArea.getText();
    }

    public String getData() {
        return dataField.getText();
    }

    public String getHorario() {
        return horarioField.getText();
    }

    public String getContato() {
        return contatoField.getText();
    }

    public String getTelefone() {
        return telefoneField.getText();
    }

    //Setters para os valores buscados do banco
    public void setNome(String text) {
        nomeField.setText(text);
    }

    public void setDescricao(String text) {
        descricaoArea.setText(text);
    }

    public void setData(String text) {
        dataField.setText(text);
    }

    public void setHorario(String text) {
        horarioField.setText(text);
    }

    public void setContato(String text) {
        contatoField.setText(text);
    }

    public void setTelefone(String text) {
        telefoneField.setText(text);
    }

}