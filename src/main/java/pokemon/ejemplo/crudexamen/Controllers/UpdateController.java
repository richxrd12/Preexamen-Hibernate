package pokemon.ejemplo.crudexamen.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pokemon.ejemplo.crudexamen.Enums.Estado;
import pokemon.ejemplo.crudexamen.Enums.Temperamento;
import pokemon.ejemplo.crudexamen.Models.DatabaseManager;
import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import java.io.IOException;

public class UpdateController {

    @FXML
    private TextField cuidadosTextField;

    @FXML
    private TextField dietaTextField;

    @FXML
    private TextField enfermedadesTextField;

    @FXML
    private TextField generoTextField;

    @FXML
    private TextField horasTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField pesoTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    private TextField sizeTextField;

    @FXML
    private ChoiceBox<Temperamento> temperamentoChoiceBox;

    @FXML
    private ChoiceBox<Estado> estadoChoiceBox;

    private Granjero granjero;

    private Animal animal;

    @FXML
    void initialize(){
        populateCombo();
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

    @FXML
    void onClickUpdate(ActionEvent event) {
        String nombre = nombreTextField.getText();
        String genero = generoTextField.getText();
        float peso = Float.parseFloat(pesoTextField.getText());
        float size = Float.parseFloat(sizeTextField.getText());
        String dieta = dietaTextField.getText();
        float precio = Float.parseFloat(precioTextField.getText());
        Estado estado = estadoChoiceBox.getValue();
        String enfermedades = enfermedadesTextField.getText();
        String cuidados = cuidadosTextField.getText();

        int horasTrabajo = 0;

        if (!horasTextField.getText().equals("")){
            horasTrabajo = Integer.parseInt(horasTextField.getText());
        }
        Temperamento temperamento = temperamentoChoiceBox.getValue();

        animal.setNombreComun(nombre);
        animal.setGenero(genero);
        animal.setPeso(peso);
        animal.setSize(size);
        animal.setDieta(dieta);
        animal.setPeso(precio);
        animal.setEstado(estado);
        animal.setEnfermedades(enfermedades);
        animal.setCuidados(cuidados);
        animal.setHorasTrabajo(horasTrabajo);
        animal.setTemperamento(temperamento);

        DatabaseManager.actualizarAnimal(animal);
    }

    public void populateCombo(){
        estadoChoiceBox.getItems().setAll(Estado.VIVO, Estado.MUERTO);
        temperamentoChoiceBox.getItems().setAll(Temperamento.ACTIVO, Temperamento.DOCIL, Temperamento.AGRESIVO,
                Temperamento.TIMIDO, Temperamento.INDEPENDIENTE);
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;

        nombreTextField.setText(animal.getNombreComun());
        generoTextField.setText(animal.getGenero());
        pesoTextField.setText(String.valueOf(animal.getPeso()));
        sizeTextField.setText(String.valueOf(animal.getSize()));
        precioTextField.setText(String.valueOf(animal.getPrecio()));
        estadoChoiceBox.setValue(animal.getEstado());
        enfermedadesTextField.setText(animal.getEnfermedades());
        cuidadosTextField.setText(animal.getCuidados());

        Integer horasTrabajo = animal.getHorasTrabajo();

        if (horasTrabajo != null){
            horasTextField.setText(String.valueOf(animal.getHorasTrabajo()));
        }

        temperamentoChoiceBox.setValue(animal.getTemperamento());
    }

    public void setGranjero(Granjero granjero){
        this.granjero = granjero;
    }
}
