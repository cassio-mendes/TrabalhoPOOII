package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compromisso {

    private String descricao;
    private Date data;
    private String horario;
    private String nomeContato;
    private long telefone;
    private boolean situacao; //false == Pendente; true == Concluído

    public Compromisso(String descricao, String nomeContato, long telefone) {
        this.descricao = descricao;
        this.nomeContato = nomeContato;
        this.telefone = telefone;

        this.data = new Date();
        this.horario = new SimpleDateFormat("HH:mm:ss").format(this.data);
        this.situacao = false;
    }

}
