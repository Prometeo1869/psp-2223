package ch.makery.examen.controller;

import ch.makery.examen.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RootLayoutController {

    private Main main;

    public void abrirNuevaPantalla(ActionEvent actionEvent) {
        Main.abrirVentanaMenu();
    }
    public void hechoPor(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Examen DIU");
        alert.setContentText("Autor: Juan Cebrián");
        alert.showAndWait();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
