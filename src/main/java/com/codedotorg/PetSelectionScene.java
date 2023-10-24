package com.codedotorg;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PetSelectionScene extends PetApp {

    /** The name of the pet provided by the user */
    private String petName;

    /** The type of pet chosen by the user */
    private String petType;

    TextField petNameField;
    ComboBox<String> petTypeComboBox;

    /**
     * This class represents a scene for selecting a pet. It extends the Scene class and
     * provides a constructor for initializing the pet name and type.
     */
    public PetSelectionScene(Stage window, int width, int height) {
        super(window, width, height);

        petName = "";
        petType = "";
    }

    /**
     * This method starts the application by creating a VBox layout for pet selection
     * and setting it as the scene to be displayed.
     */
    public void startApp() {
        VBox petSelectionLayout = createPetSelectionLayout();
        setAndShowScene(petSelectionLayout);
    }

    /**
     * Sets petName to the name entered by the user
     */
    public void setPetName() {
        petName = petNameField.getText();
    }

    /**
     * Sets petType to the type of pet chosen by the user
     */
    public void setPetType() {
        petType = petTypeComboBox.getValue();
    }

    /**
     * Creates the main layout for the PetSelection scene
     * 
     * @return the VBox layout for the PetSelection scene
     */
    public VBox createPetSelectionLayout() {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("Enter pet name"));
        vBox.getChildren().add(petNameField = new TextField());
        vBox.getChildren().add(new Label("Choose pet type"));
        petTypeComboBox = new ComboBox<>();
        petTypeComboBox.getItems().addAll("Dog", "Cat");
        vBox.getChildren().add(petTypeComboBox);
        vBox.getChildren().add(createSubmitButton());
        return vBox;
    }

    /**
     * Creates a submit button that, when clicked, creates a new MainScene object with
     * the given pet name and type, and displays it.
     *
     * @return the submit button
     */
    public Button createSubmitButton() {
        Button tempButton = new Button("Submit");

        tempButton.setOnAction(event -> {
            setPetName();
            setPetType();
            if(petName.equals("") || petType == null) {
                return;
            }
            MainScene mainScene = new MainScene(getWindow(), getWidth(), getHeight(), petName, petType);
            mainScene.showMainScene();
        });

        return tempButton;
    }

}