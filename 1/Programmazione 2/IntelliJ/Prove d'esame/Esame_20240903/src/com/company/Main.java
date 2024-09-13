package com.company;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Collections;


public class Main extends Application {

    public static final int SPACING = 10;
    public static final int DIM_SEMAFORO = 40;
    Biblioteca biblioteca = new Biblioteca();
    int currentIndex = 0;

    Text txtLibro = new Text();
    Button btnPrev = new Button("<");
    Button btnNext = new Button(">");

    Button btnPrestito = new Button("Prestito");
    TextField txtPrestito = new TextField();
    Rectangle semaforo = new Rectangle(DIM_SEMAFORO, DIM_SEMAFORO);

    Button btnRestituisci = new Button("Restituisci");

    Button btnInfo = new Button("Per info");
    Button btnID = new Button("Per ID");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        btnPrev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentIndex--;
                update();
            }
        });

        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentIndex++;
                update();
            }
        });

        btnPrestito.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String strGiorni = txtPrestito.getText();
                String error = null;

                if (strGiorni.isBlank())
                    error = "Devi specificare un numero di giorni";
                else {
                    try {
                        int giorni = Integer.parseInt(strGiorni);

                        if (giorni < 0) {
                            error = "Hai inserito un numero inferiore a 0";
                        } else {
                            if (biblioteca.get(currentIndex).richiediPrestito(giorni)) {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Prestito");
                                alert.setHeaderText("Prestito accettato");
                                alert.setContentText("Il prestito di " + giorni + " giorni è andato a buon fine");
                                alert.showAndWait();
                                update();
                            } else {
                                error = "Il prestito richiesto non è ammesso";
                            }
                        }
                    } catch (NumberFormatException ex) {
                        error = "La stringa inserita non è un numero";
                    }
                }

                if (error != null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Prestito");
                    alert.setHeaderText("Prestito RIFIUTATO");
                    alert.setContentText(error);
                    alert.showAndWait();
                }
            }
        });

        btnRestituisci.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                biblioteca.get(currentIndex).restituisci();
                update();
            }
        });

        btnInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.sort(biblioteca.pubblicazioni);
                currentIndex = 0;
                update();

                btnID.setDisable(false);
                btnInfo.setDisable(true);
            }
        });

        btnID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Collections.sort(biblioteca.pubblicazioni, new ComparatorByNumeroArchivio());
                currentIndex = 0;
                update();

                btnID.setDisable(true);
                btnInfo.setDisable(false);
            }
        });

        btnID.fire();
        //update();

        BorderPane root = new BorderPane();

        VBox vbLeft = new VBox(btnPrev);
        vbLeft.setAlignment(Pos.CENTER);
        vbLeft.setPadding(new Insets(SPACING));
        root.setLeft(vbLeft);

        VBox vbRight = new VBox(btnNext);
        vbRight.setAlignment(Pos.CENTER);
        vbRight.setPadding(new Insets(SPACING));
        root.setRight(vbRight);

        HBox hbCenter = new HBox(semaforo, txtLibro);
        hbCenter.setAlignment(Pos.CENTER);
        hbCenter.setSpacing(SPACING);
        root.setCenter(hbCenter);

        HBox hbPrestito = new HBox(btnPrestito, txtPrestito);
        hbPrestito.setSpacing(SPACING);
        HBox hbRestituisci = new HBox(btnRestituisci);
        VBox vbBottom = new VBox(hbPrestito, hbRestituisci);
        vbBottom.setSpacing(SPACING);
        vbBottom.setPadding(new Insets(SPACING));
        root.setBottom(vbBottom);

        HBox hbTop = new HBox(btnInfo, btnID);
        hbTop.setSpacing(SPACING);
        hbTop.setPadding(new Insets(SPACING));
        root.setTop(hbTop);

        primaryStage.setTitle("BiblioManager");
        primaryStage.setScene(new Scene(root, 350, 350));
        primaryStage.show();
    }

    private void update() {
        Pubblicazione p = biblioteca.get(currentIndex);
        //txtLibro.setText(biblioteca.get(currentIndex).toString());
        String txt = p.getNumero_archivio() + ". " + p.getTitolo() + "\n" + p.getAnnoPubblicazione() + ", " + p.getAutore() + "\n";
        txt += p.caratteristiche() + "\n";
        txt += p.getPrestitoString();

        txtLibro.setText(txt);

        btnPrev.setDisable(currentIndex == 0);
        btnNext.setDisable(currentIndex == biblioteca.size() - 1);

        btnPrestito.setDisable(!p.isPrestabile() || p.isPrestato());
        btnRestituisci.setDisable(!(p.isPrestabile() && p.isPrestato()));

        if(p.isPrestabile()) {
            if(p.isPrestato())
                semaforo.setFill(Color.RED);
            else
                semaforo.setFill(Color.GREEN);
        } else {
            semaforo.setFill(Color.GRAY);
        }
    }
}
