package view;

import model.Command;

import javax.swing.*;

public class InvokerButton extends JButton {

    private Command command;

    public InvokerButton(String text) { super(text); }

    public void setCommand(Command c) { this.command = c; }

    public Object invokeCommand() { return this.command.execute(); }

}
