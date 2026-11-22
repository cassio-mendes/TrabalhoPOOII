package model;

public class Compromisso {

    private long id;
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

    public Compromisso(long id, String nomeCompromisso, String descricao, String data,
                       String horario, String nomeContato, String telefone) {

        this.id = id;
        this.nomeCompromisso = nomeCompromisso;
        this.descricao = descricao;
        this.nomeContato = nomeContato;
        this.telefone = telefone;
        this.data = data;
        this.horario = horario;
        this.situacao = false;
    }

    @Override
    public String toString() {
        return this.nomeCompromisso + " | Dia: " + this.data + " | Horário: " + this.horario;
    }

    public long getId() {
        return id;
    }

    public String getNomeCompromisso() {
        return nomeCompromisso;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isSituacao() {
        return situacao;
    }
}
