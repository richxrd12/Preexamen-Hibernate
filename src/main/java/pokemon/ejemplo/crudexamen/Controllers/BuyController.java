package pokemon.ejemplo.crudexamen.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pokemon.ejemplo.crudexamen.Models.DatabaseManager;
import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyController {

    @FXML
    private ListView<Animal> animalesList;

    @FXML
    private Button comprarButton;

    @FXML
    private Label saldoLabel;

    private Granjero granjero;

    private ArrayList<Integer> arrayList = new ArrayList<>();

    private ArrayList<Integer> arrayVistos = new ArrayList<>();

    @FXML
    void initialize(){
        List<Animal> animales = DatabaseManager.obtenerAnimalesSolos();
        ObservableList<Animal> animalesObservable = FXCollections.observableArrayList(animales);

        animalesList.setItems(animalesObservable);

        int size = animalesList.getItems().size();

        for (int i = 0; i < size; i++){
            arrayList.add(i);
        }

        animalesList.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (!arrayVistos.contains(newValue.intValue())){
                arrayVistos.add(newValue.intValue());
            }

            if (arrayVistos.stream().sorted().toList().equals(arrayList.stream().sorted().toList())) {
                comprarButton.setDisable(false);
            }

        });


        comprarButton.setDisable(true);
    }

    @FXML
    void onClickBuy(ActionEvent event) {
        Animal animal = animalesList.getSelectionModel().getSelectedItem();

        //Updatear el precio
        granjero.setSaldo(granjero.getSaldo() - animal.getPrecio());
        DatabaseManager.actualizarSaldo(granjero);

        saldoLabel.setText(String.valueOf(granjero.getSaldo()));

        //Añadirlo
        granjero.getAnimales().add(animal);
        DatabaseManager.comprarAnimal(granjero);

        initialize();
    }

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

    public void setGranjero(Granjero granjero){
        this.granjero = granjero;

        saldoLabel.setText(String.valueOf(granjero.getSaldo()));
    }

}
