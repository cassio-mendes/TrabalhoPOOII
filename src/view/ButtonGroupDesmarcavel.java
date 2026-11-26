package view;

import javax.swing.*;

public class ButtonGroupDesmarcavel extends ButtonGroup {

    @Override
    public void setSelected(ButtonModel m, boolean b) {
        if(!b && m == getSelection()) { //Se o usuário tentar desmarca o botão já selecionado
            clearSelection();
        } else {
            super.setSelected(m, b); //Senão, prossegue normalmente
        }
    }
}
