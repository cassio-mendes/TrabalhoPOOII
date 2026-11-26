package model;

import dao.CompromissoDAO;

public class ConsultarCommand implements Command {

    private String ordem, filtro, pesquisa;

    public void setOrdem(String ordem) { this.ordem = ordem; }

    public void setFiltro(String filtro) { this.filtro = filtro; }

    public void setPesquisa(String pesquisa) { this.pesquisa = pesquisa; }

    @Override
    public Object execute() {
        return CompromissoDAO.listarComFiltro(ordem, filtro, pesquisa);
    }
}
