package edu.upvictoria.poo;

import edu.upvictoria.poo.Scenes.LoginScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public final String DB_PATH = "src/main/resources/main.db";
    private Stage stage;
    private LoginScene loginScene;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.loginScene = new LoginScene(this);
        this.stage.setScene(loginScene.getScene());
        this.stage.show();
    }

    public void switchScenes(int index) {
        switch (index) {
            case 0 -> this.stage.setScene(loginScene.getScene());
        }
    }

    public static void main(String[] args) {
        launch();
    }

}