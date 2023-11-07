package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoginScene extends FormSceneTemplate {
    public LoginScene(App app) {
        super(app);
    }

    @Override
    boolean areFieldsEmpty() {
        return false;
    }

    @Override
    EventHandler<ActionEvent> formEvent() {
        return null;
    }
}
