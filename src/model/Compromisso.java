package model;

public class Compromisso {

    private String nomeCompromisso, descricao, data, horario, nomeContato, telefone;
    private boolean situacao; //false == Pendente; true == Concluído

    public Compromisso(String nomeCompromisso, String descricao, String data, String horario,
                       String nomeContato, String telefone) {

        this.nomeCompromisso = nomeCompromisso;
        this.descricao = descricao;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.data = data;
        this.horario = horario;
        this.situacao = false;
    }

}
