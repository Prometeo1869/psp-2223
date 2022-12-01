package com.example.act8.controller;

import com.example.act8.aplication.Main;
import com.example.act8.modelo.MyHilo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controlador  {

    @FXML
    private TextField txtFieldHilo1, txtFieldHilo2;
    @FXML
    private Label labelHilo1, labelHilo2;
    MyHilo h1;
    MyHilo h2;
    Main main;

    @FXML
    private void initialize() {

    }

    public TextField getTxtFieldHilo1() {
        return txtFieldHilo1;
    }

    public TextField getTxtFieldHilo2() {
        return txtFieldHilo2;
    }

    public void pulsarComenzar() {
        h1 = main.getHilo1();
        h2 = main.getHilo2();
        h1.setTextField(txtFieldHilo1);
        h2.setTextField(txtFieldHilo2);
        h1.start();
        h2.start();
        labelHilo1.setText("HILO 1 CORRIENDO");
        labelHilo2.setText("HILO 2 CORRIENDO");
    }

    public void reanudarHilo1(ActionEvent event) {
        h1.getSuspender().set(false);
        labelHilo1.setText("HILO 1 REANUDADO");
    }

    public void reanudarHilo2(ActionEvent event) {
        h2.getSuspender().set(false);
        labelHilo2.setText("HILO 2 REANUDADO");
    }

    public void suspenderHilo1(ActionEvent event) throws InterruptedException {
        h2.getSuspender().set(true);
        labelHilo1.setText("HILO 1 SUSPENDIDO");
    }

    public void suspenderHilo2(ActionEvent event) throws InterruptedException {
        h2.getSuspender().set(true);
        labelHilo2.setText("HILO 2 SUSPENDIDO");
    }

    public void pulsarFinalizar(ActionEvent event) {
        h1.getSuspender().set(true);
        h2.getSuspender().set(true);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
