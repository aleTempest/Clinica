package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class VBoxTemplate extends VBox {
    protected App app;
    protected Scene scene;

    public VBoxTemplate(App app) {
        this.app = app;
        this.scene = new Scene(this,800,600);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }
}
