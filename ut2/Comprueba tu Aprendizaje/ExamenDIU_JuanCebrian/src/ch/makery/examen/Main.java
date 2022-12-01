package ch.makery.examen;

import ch.makery.examen.model.Moneda;
import ch.makery.examen.model.ModeloVO;
import ch.makery.examen.model.Modelo;
import ch.makery.examen.model.repositoy.impl.MyRepositoryImpl;
import ch.makery.examen.util.Convert;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private MyRepositoryImpl repository;
    private Modelo modelo;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Moneda> claseData = FXCollections.observableArrayList();
    boolean ok = true;

    Main() {
        try {
            this.modelo = new Modelo();
            this.repository = new MyRepositoryImpl();
            Modelo.setRep(this.repository);
            for (ModeloVO mvo : Modelo.obtenerLista()) {
                Moneda nuevo = Convert.convertTo(mvo);
                claseData.add(nuevo);
            }
        } catch (ExceptionClase e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR DE CONEXIÓN");
            alert.setContentText("Error al conectar con la base de datos");
            alert.showAndWait();
            ok = false;
        }
    }

    private void initialize() {

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Examen DIU");

        initRootLayout();
        mostrarVentanaPrincipal();
    }
    private void initRootLayout() {

    }
    private void mostrarVentanaPrincipal() {

    }
    public static void abrirVentanaMenu() {

    }
}
