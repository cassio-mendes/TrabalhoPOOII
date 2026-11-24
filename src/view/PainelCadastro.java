package view;

import model.CadastroCommand;
import model.Command;
import model.Compromisso;

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
        InvokerButton cadastrarBtn = new InvokerButton("CADASTRAR");
        cadastrarBtn.setFont(fonte);
        cadastrarBtn.setBackground(Color.WHITE);
        cadastrarBtn.setFocusPainted(false);
        cadastrarBtn.setBounds(150, 340, 125, 30);
        cadastrarBtn.addActionListener(e -> {
            //Cadastro de compromisso:
            String nome = componentes.getNome();
            String data = componentes.getData();
            String horario = componentes.getHorario();
            String contato = componentes.getContato();
            String telefone = componentes.getTelefone();

            //Informações faltando (a descrição é opcional)
            if(nome.isBlank() || data.contains("_") || horario.contains("_") || contato.contains("_") ||
                    telefone.contains("_")) {

                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os dados do " +
                        "compromisso (a descrição é opcional)", "Dados faltando", JOptionPane.WARNING_MESSAGE);
            } else {
                String descricao = componentes.getDescricao(); //Pode ser uma String vazia
                Compromisso compromisso = new Compromisso(nome, descricao, data, horario, contato, telefone);

                cadastrarBtn.setCommand(new CadastroCommand(compromisso));
                boolean result = (Boolean) cadastrarBtn.invokeCommand();

                if(result) {
                    JOptionPane.showMessageDialog(null, "Novo compromisso registrado!",
                            "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

                    componentes.limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar novo compromisso...",
                            "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
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
