package model;

import dao.CompromissoDAO;

public class ExcluirCommand implements Command {

    private Compromisso compromisso;

    public ExcluirCommand(Compromisso compromisso) { this.compromisso = compromisso; }

    @Override
    public Object execute() {
        return CompromissoDAO.excluir(this.compromisso);
    }
}
