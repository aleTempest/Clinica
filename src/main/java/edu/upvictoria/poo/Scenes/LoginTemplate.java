package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public abstract class LoginTemplate extends VBoxTemplate {
    protected TextField usernameTxt = new TextField();
    protected TextField passwordTxt = new TextField();
    protected Hyperlink link = new Hyperlink("Register?");
    protected Button saveBtn = new Button("Login");
    protected Label img = new Label("");

    public LoginTemplate(App app) {
        super(app);
        this.getChildren().addAll(img,usernameTxt,passwordTxt,saveBtn,link);
    }

    abstract boolean areFieldsEmpty();

    abstract EventHandler<ActionEvent> formEvent();
}
