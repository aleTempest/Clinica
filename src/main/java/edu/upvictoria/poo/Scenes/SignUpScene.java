package edu.upvictoria.poo.Scenes;

import edu.upvictoria.poo.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

public class SignUpScene extends FormSceneTemplate {
    private TextField firstNameTxt = new TextField();
    private TextField lastNameTxt = new TextField();
    private TextField zipcodeTxt = new TextField();
    private TextField address1Txt = new TextField();
    private TextField address2Txt = new TextField();
    private TextField phoneNumberTxt = new TextField();
    private ComboBox userType = new ComboBox<>();

    public SignUpScene(App app) {
        super(app);
        this.firstNameTxt.setPromptText("Enter the first name");
        this.lastNameTxt.setPromptText("Enter the last name");
        this.zipcodeTxt.setPromptText("Enter the zipcode ");
        this.address1Txt.setPromptText("Enter the address 1");
        this.address2Txt.setPromptText("Enter the address 2");
        this.phoneNumberTxt.setPromptText("Enter the phone number");
        var items = FXCollections.observableArrayList();
        items.addAll("PATIENT","DOCTOR");
        this.userType.setItems(items);
        this.link.setText("Login?");
        this.saveBtn.setText("Save");
        this.getChildren().addAll(
                this.firstNameTxt,
                this.lastNameTxt,
                this.phoneNumberTxt,
                this.usernameTxt,
                this.passwordTxt,
                this.saveBtn,
                this.link
        );
    }

    @Override
    boolean areFieldsEmpty() {
        var arr = new ArrayList<TextField>(
                Arrays.asList(
                        firstNameTxt,
                        lastNameTxt,
                        usernameTxt,
                        passwordTxt,
                        zipcodeTxt,
                        address1Txt,
                        address2Txt,
                        phoneNumberTxt
                )
        );
        for (var txtField : arr) {
            if (txtField.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    EventHandler<ActionEvent> formEvent() {
        return action -> {
            if (!areFieldsEmpty()) {

            }
        };
    }
}
