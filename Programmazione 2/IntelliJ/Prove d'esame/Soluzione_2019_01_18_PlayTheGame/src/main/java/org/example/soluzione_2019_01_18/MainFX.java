package org.example.soluzione_2019_01_18;

import Controller.MainGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import java.util.Optional;

public class MainFX extends Application {
    private static int LATO;
    @Override
    public void start(Stage stage) {
        do{
            System.out.println("inserisci la dimensione della griglia: ");
            LATO = Integer.parseInt(InputDialog.getResponse());
            System.out.println("Hai inserito " + LATO + ((LATO < 3 || LATO > 9)? ",indice non valido, inserisci da 3 a 9" : "!"));
        }while(LATO < 3 || LATO > 9);

        MainGUI mg = new MainGUI();
        Scene scene = new Scene(mg, LATO*60, LATO*55);
        stage.setTitle("Play the game!");
        stage.setScene(scene);
        stage.show();
    }

    public static int getLATO() {
        return LATO;
    }

    public static class InputDialog {
        static String getResponse(){
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("inserisci la dimensione della griglia:");
            Optional<String> result = dialog.showAndWait();
            return result.orElse(null);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
