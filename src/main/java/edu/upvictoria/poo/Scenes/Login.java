package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import edu.upvictoria.poo.Lib.PatientRepository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class Login extends LoginTemplate {
    public Login(App app) {
        super(app);
        this.saveBtn.setOnAction(formEvent());
        this.link.setOnAction(event -> app.switchScenes(1));
    }

    @Override
    boolean areFieldsEmpty() {
        return usernameTxt.getText().isEmpty() || passwordTxt.getText().isEmpty();
    }

    @Override
    EventHandler<ActionEvent> formEvent() {
        return action -> {
            if (!areFieldsEmpty()) {
                var username = usernameTxt.getText();
                var password = passwordTxt.getText();
                var repo = new PatientRepository(app.DB_PATH);
                var userAux = repo.searchUserByUsername(username);
                if (userAux != null) {
                    var alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Logged");
                    alert.setContentText("WORKS");
                    alert.show();
                }
            }
        };
    }
}
