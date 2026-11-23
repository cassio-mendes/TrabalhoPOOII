package model;

import dao.CompromissoDAO;

public class EditarCommand implements Command {

    private Compromisso compromisso;

    public EditarCommand(Compromisso compromisso) { this.compromisso = compromisso; }

    @Override
    public Object execute() {
        return CompromissoDAO.atualizar(this.compromisso);
    }
}
