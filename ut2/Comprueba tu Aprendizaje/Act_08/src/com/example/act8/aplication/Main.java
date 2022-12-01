package com.example.act8.aplication;

import com.example.act8.controller.Controlador;
import com.example.act8.modelo.MyHilo;
import com.example.act8.modelo.SolicitaSuspender;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public Stage primaryStage;
    @FXML
    public AnchorPane pantalla;
    MyHilo h1 = new MyHilo();
    MyHilo h2= new MyHilo();

    public Main() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initPrograma();
    }

    public void initPrograma() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("../view/Vista.fxml"));
        AnchorPane editPage = loader.load();
        Scene scene = new Scene(editPage);
        Controlador controlador = loader.getController();
        controlador.setMain(this);

        primaryStage.setScene(scene);
        primaryStage.setTitle("EJECUTAR, SUSPENDER Y REANUDAR HILOS");
        primaryStage.show();
    }
    public MyHilo getHilo1() {
        return h1;
    }
    public MyHilo getHilo2() {
        return h2;
    }
}
