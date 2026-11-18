package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class PainelCadastro extends JPanel {

    private JTextField nomeField;
    private JTextField contatoField;

    private JScrollPane descricaoScroll;
    private JTextArea descricaoArea;

    private JFormattedTextField dataField;
    private JFormattedTextField horarioField;
    private JFormattedTextField telefoneField;

    public PainelCadastro() {
        this.setLayout(null);

        Font fonte = new Font("Arial", Font.PLAIN, 16);
        LineBorder borda = new LineBorder(Color.BLACK, 1);

        JLabel titulo = new JLabel("Cadastro de Compromissos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(145, 30, 400, 25);
        this.add(titulo);

        JLabel nomeLabel = new JLabel("Nome: ");
        nomeLabel.setFont(fonte);
        nomeLabel.setBounds(79, 90, 60, 18);
        this.add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setFont(fonte);
        nomeField.setBounds(140, 90, 300, 20);
        nomeField.setBorder(borda);
        this.add(nomeField);

        JLabel descricaoLabel = new JLabel("Descrição: ");
        descricaoLabel.setFont(fonte);
        descricaoLabel.setBounds(50, 120, 90, 18);
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
        descricaoScroll.setBounds(140, 120, 400, 75);
        this.add(descricaoScroll);

        JLabel dataLabel = new JLabel("Data: ");
        dataLabel.setFont(fonte);
        dataLabel.setBounds(90, 205, 80, 20);
        this.add(dataLabel);

        //Configurando campo de texto formatado para datas
        try {
            MaskFormatter dataFormatter = new MaskFormatter("##/##/####");
            dataFormatter.setPlaceholderCharacter('_');

            dataField = new JFormattedTextField(dataFormatter);
            dataField.setFont(fonte);
            dataField.setBounds(140, 205, 90, 20);
            this.add(dataField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo de data", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        JLabel horarioLabel = new JLabel("Horário: ");
        horarioLabel.setFont(fonte);
        horarioLabel.setBounds(68, 235, 90, 20);
        this.add(horarioLabel);

        //Configurando campo de texto formatado para horários
        try {
            MaskFormatter horarioFormatter = new MaskFormatter("## : ##");
            horarioFormatter.setPlaceholderCharacter('_');

            horarioField = new JFormattedTextField(horarioFormatter);
            horarioField.setFont(fonte);
            horarioField.setBounds(140, 235, 55, 20);
            this.add(horarioField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo do horário", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        JLabel contatoLabel = new JLabel("Contato: ");
        contatoLabel.setFont(fonte);
        contatoLabel.setBounds(66, 265, 90, 20);
        this.add(contatoLabel);

        contatoField = new JTextField();
        contatoField.setFont(fonte);
        contatoField.setBounds(140, 265, 300, 20);
        contatoField.setBorder(borda);
        this.add(contatoField);

        JLabel telefoneLabel = new JLabel("Whatsapp: ");
        telefoneLabel.setFont(fonte);
        telefoneLabel.setBounds(50, 295, 90, 20);
        this.add(telefoneLabel);

        //Configurando campo de texto formatado para números de telefone (whatsapp)
        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("+## (##) ##### - ####");
            telefoneFormatter.setPlaceholderCharacter('_');

            telefoneField = new JFormattedTextField(telefoneFormatter);
            telefoneField.setFont(fonte);
            telefoneField.setBounds(140, 295, 170, 20);
            this.add(telefoneField);
        } catch(ParseException e) {
            JOptionPane.showMessageDialog(this, "ERRO no campo de telefone", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }

        //Botões:
        JButton cadastrarBtn = new JButton("CADASTRAR");
        cadastrarBtn.setFont(fonte);
        cadastrarBtn.setBackground(Color.WHITE);
        cadastrarBtn.setFocusPainted(false);
        cadastrarBtn.setBounds(150, 340, 125, 30);
        this.add(cadastrarBtn);

        JButton limparBtn = new JButton("LIMPAR");
        limparBtn.setFont(fonte);
        limparBtn.setBackground(Color.WHITE);
        limparBtn.setFocusPainted(false);
        limparBtn.setBounds(340, 340, 120, 30);
        this.add(limparBtn);

    }

}
