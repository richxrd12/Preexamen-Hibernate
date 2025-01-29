package pokemon.ejemplo.crudexamen.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pokemon.ejemplo.crudexamen.Enums.Estado;
import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import java.io.IOException;

public class HomeController {

    @FXML
    private ListView<Animal> animalesMuertosList;

    @FXML
    private ListView<Animal> animalesVivosList;

    private Granjero granjero;

    @FXML
    void onClickBuyAnimal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pokemon/ejemplo/crudexamen/BuyView.fxml"));

        Scene scene = new Scene(loader.load());

        BuyController controller = loader.getController();
        controller.setGranjero(granjero);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("Buy");
        stage.show();

        stage.setHeight(610);
        stage.setWidth(870);
    }

    @FXML
    void onClickSeeAnimal(ActionEvent event) throws IOException {
        Animal animal = animalesVivosList.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pokemon/ejemplo/crudexamen/DetailsView.fxml"));

        Scene scene = new Scene(loader.load());

        DetailsController controller = loader.getController();
        controller.setGranjero(granjero);
        controller.setAnimal(animal);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("Home");
        stage.show();

        stage.setHeight(610);
        stage.setWidth(870);
    }

    @FXML
    void onClickUpdate(ActionEvent event) {

    }

    public Granjero getGranjero() {
        return granjero;
    }

    public void setGranjero(Granjero granjero) {
        this.granjero = granjero;

        //Para animales vivos
        ObservableList<Animal> listaNombresVivos = FXCollections.observableArrayList();

        for (Animal animal: granjero.getAnimales()){
            if (animal.getEstado().equals(Estado.VIVO)){
                listaNombresVivos.add(animal);
            }
        }

        animalesVivosList.setItems(listaNombresVivos);

        //Para animales muertos
        ObservableList<Animal> listaNombresMuertos = FXCollections.observableArrayList();

        for (Animal animal: granjero.getAnimales()){
            if (animal.getEstado().equals(Estado.MUERTO)){
                listaNombresMuertos.add(animal);
            }
        }

        animalesMuertosList.setItems(listaNombresMuertos);
    }
}
