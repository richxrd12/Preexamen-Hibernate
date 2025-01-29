package pokemon.ejemplo.crudexamen.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pokemon.ejemplo.crudexamen.Models.DatabaseManager;
import pokemon.ejemplo.crudexamen.Objects.Animal;
import pokemon.ejemplo.crudexamen.Objects.Granjero;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    void onClickLogin(ActionEvent event) throws IOException {
        String correo = usuarioTextField.getText();
        String password = passwordTextField.getText();

        Granjero granjero = DatabaseManager.comprobarLogin(correo, password);

        if (granjero != null) {
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

        }else{
            System.out.println("Ha habido un error");
        }
    }

}
