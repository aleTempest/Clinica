package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import edu.upvictoria.poo.Lib.Session;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class LoginScene extends FormSceneTemplate {
    public LoginScene(App app) {
        super(app);
        this.saveBtn.setOnAction(formEvent());
    }

    @Override
    boolean areFieldsEmpty() {
        return this.usernameTxt.getText().isEmpty() || this.passwordTxt.getText().isEmpty();
    }

    @Override
    EventHandler<ActionEvent> formEvent() {
        return action -> {
            if (!areFieldsEmpty()) {
                var alert = new Alert(Alert.AlertType.ERROR);
                var username = this.usernameTxt.getText();
                var password = this.passwordTxt.getText();
                var session = new Session(app.DB_PATH);
                try {
                    if (session.auth(username,password)) {
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("WORKS");
                        alert.setContentText("WORKS");
                        alert.show();
                    }
                } catch (SQLException e) {
                    alert.setTitle("DB Error");
                    alert.setContentText(e.getMessage());
                    alert.show();
                }
            }
        };
    }
}
