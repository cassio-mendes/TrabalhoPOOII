package model;

import dao.CompromissoDAO;

public class ListarCommand implements Command {

    @Override
    public Object execute() {
        return CompromissoDAO.listarTodos();
    }
}
