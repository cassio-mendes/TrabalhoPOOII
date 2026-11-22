package model;

import dao.CompromissoDAO;

public class CadastroCommand implements Command {

    private Compromisso compromisso;

    public CadastroCommand(Compromisso compromisso) {
        this.compromisso = compromisso;
    }

    @Override
    public Object execute() { //Cadastro do compromisso
        return CompromissoDAO.inserir(compromisso);
    }
}
