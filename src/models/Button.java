package models;

import javax.swing.*;

public class Button {

    String label;

    ButtonType type;

    JButton jButton;

    public Button(ButtonType type, String label) {
        this.type = type;
        this.label = label;
        this.jButton = new JButton(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }
}
