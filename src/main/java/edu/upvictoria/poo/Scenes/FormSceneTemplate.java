package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public abstract class FormSceneTemplate extends VBoxTemplate {
    protected TextField usernameTxt = new TextField();
    protected TextField passwordTxt = new TextField();
    protected Hyperlink link = new Hyperlink("Register?");
    protected Button saveBtn = new Button("Login");
    protected Label imgLabel = new Label("");

    public FormSceneTemplate(App app) {
        super(app);
        this.usernameTxt.setPromptText("Enter your username");
        this.passwordTxt.setPromptText("Enter your password");
    }

    abstract boolean areFieldsEmpty();

    abstract EventHandler<ActionEvent> formEvent();
}