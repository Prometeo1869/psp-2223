package com.example.act8.modelo;

import com.example.act8.aplication.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MyHilo extends Thread {

    private int c = 0;
    private TextField textField;
    private SolicitaSuspender suspender;


    public MyHilo() {
        suspender.set(false);
    }

    public SolicitaSuspender getSuspender() {
        return suspender;
    }

    public void run() {

        try {
            while (!suspender.isSolicitaSuspender()) {
                c++;
                this.textField.setText("" + c);
                sleep(500);
                suspender.esperandoParaReanudar();
            }


        } catch (InterruptedException exception) {
        }
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

}
