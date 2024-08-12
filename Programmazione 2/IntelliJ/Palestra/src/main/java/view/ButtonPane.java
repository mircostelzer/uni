package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ButtonPane extends BorderPane {
    private HBox leftBox;
    private HBox rightBox;
    private Button tutti;
    private Button studenti;
    private Button atleti;
    private Button nameSort;
    private Button ageSort;
    private Controller controller;

    public ButtonPane(Controller controller) {
        this.controller = controller;
        leftBox = new HBox();
        leftBox.setSpacing(5);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        tutti = new Button("Tutti");
        tutti.setDisable(true);
        setTutti();
        studenti = new Button("Studenti");
        setStudenti();
        atleti = new Button("Atleti");
        setAtleti();
        leftBox.getChildren().addAll(tutti, studenti, atleti);

        rightBox = new HBox();
        rightBox.setSpacing(5);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        nameSort = new Button("Per nome");
        nameSort.setDisable(true);
        setNameSort();
        ageSort = new Button("Per eta'");
        setAgeSort();
        rightBox.getChildren().addAll(nameSort, ageSort);

        this.setLeft(leftBox);
        this.setRight(rightBox);
        this.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    private void setTutti() {
        tutti.setOnMouseClicked(e -> {
           tutti.setDisable(true);
           atleti.setDisable(false);
           studenti.setDisable(false);
           controller.showAll();
        });
    }

    private void setStudenti() {
        studenti.setOnMouseClicked(e -> {
            studenti.setDisable(true);
            atleti.setDisable(false);
            tutti.setDisable(false);
            controller.showStudents();
        });
    }

    private void setAtleti() {
        atleti.setOnMouseClicked(e -> {
            atleti.setDisable(true);
            studenti.setDisable(false);
            tutti.setDisable(false);
            controller.showAthletes();
        });
    }

    private void setNameSort() {
        nameSort.setOnMouseClicked(e -> {
            nameSort.setDisable(true);
            ageSort.setDisable(false);
            controller.toggleComparator();
        });
    }

    private void setAgeSort() {
        ageSort.setOnMouseClicked(e -> {
            ageSort.setDisable(true);
            nameSort.setDisable(false);
            controller.toggleComparator();
        });
    }
}
