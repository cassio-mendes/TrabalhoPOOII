package view;

import javax.swing.*;

public class PainelEdicao extends JPanel {

    private PainelComponentes componentes;

    public PainelEdicao() {
        this.setLayout(null);

        componentes = new PainelComponentes("Editar Compromissos");
        componentes.setBounds(30, 17, PainelComponentes.LARGURA, PainelComponentes.ALTURA);

        this.add(componentes);
    }

}
