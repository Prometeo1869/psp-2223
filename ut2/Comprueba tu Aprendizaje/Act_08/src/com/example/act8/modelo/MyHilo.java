package com.example.act8.modelo;

import com.example.act8.aplication.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyHilo extends Thread {

    int c = 0;
    TextField textField;
    boolean seguir = true;

    public MyHilo() {

    }

    public void run() {

        try {
            while (seguir) {
                c++;
                this.textField.setText("" + c);
                sleep(500);
            }


        } catch (InterruptedException exception) {
        }
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void setSeguir(boolean flag) {
        this.seguir = flag;
    }

    public boolean getSeguir() {
        return seguir;
    }
}
