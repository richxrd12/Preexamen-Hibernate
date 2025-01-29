package pokemon.ejemplo.crudexamen.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import java.io.IOException;

public class DetailsController {

    @FXML
    private Label dietaLabel;

    @FXML
    private Label estadoLabel;

    @FXML
    private Label generoLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label parcelaLabel;

    @FXML
    private Label pesoLabel;

    @FXML
    private Label precioLabel;

    @FXML
    private Label sizeLabel;

    private Granjero granjero;

    private Animal animal;

    @FXML
    void onClickReturn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pokemon/ejemplo/crudexamen/HomeView.fxml"));

        Scene scene = new Scene(loader.load());

        HomeController controller = loader.getController();
        controller.setGranjero(granjero);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("Home");
        stage.show();

        stage.setHeight(610);
        stage.setWidth(870);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;

        idLabel.setText(String.valueOf(animal.getId()));
        nombreLabel.setText(animal.getNombreComun());
        generoLabel.setText(animal.getGenero());
        pesoLabel.setText(String.valueOf(animal.getPeso()));
        sizeLabel.setText(String.valueOf(animal.getPeso()));
        dietaLabel.setText(animal.getDieta());
        precioLabel.setText(String.valueOf(animal.getPrecio()));
        estadoLabel.setText(String.valueOf(animal.getEstado()));
        parcelaLabel.setText(animal.getParcela().getUbicacion());

    }

    public Granjero getGranjero() {
        return granjero;
    }

    public void setGranjero(Granjero granjero) {
        this.granjero = granjero;
    }
}
