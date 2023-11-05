package edu.upvictoria.poo;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public final String DB_PATH = "src/main/resources/main.db";
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.show();
    }

    public void switchScenes(int index) {
    }

    public static void main(String[] args) {
        launch();
    }

}