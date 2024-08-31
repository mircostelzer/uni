package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.*;
import view.MainGui;
import view.RicettePane;

import java.util.Date;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Farmacia farmacia = new Farmacia();
        Medicina m1 = new DaBanco("Benagol", 10, new ExpirationDate(System.currentTimeMillis()+100000000));
        farmacia.add(m1);
        Medicina m2 = new DaBanco("Brufen200", 8, new ExpirationDate(System.currentTimeMillis()+100000000));
        farmacia.add(m2);
        ConRicetta m3 = new NonRipetibile("Brufen80", 20, new ExpirationDate(System.currentTimeMillis()+100000000));
        farmacia.add(m3);
        ConRicetta m4 = new Ripetibile("Oki", 12, new ExpirationDate(System.currentTimeMillis()+1000000000), 4);
        farmacia.add(m4);
        ConRicetta m5 = new Ripetibile("Fluifort", 18, new ExpirationDate(System.currentTimeMillis()-1000000000), 2);
        farmacia.add(m5);
        ConRicetta m6 = new Ripetibile("Tachipirina1000", 6, new ExpirationDate(System.currentTimeMillis()+1000000000), 3);
        farmacia.add(m6);

        User user = new User(30);
        Ricetta r1 = new Ricetta(m3, new ExpirationDate(System.currentTimeMillis()-1000000000));
        m3.setRicetta(r1);
        user.getRicette().add(r1);
        Ricetta r2 = new Ricetta(m6, new ExpirationDate(System.currentTimeMillis()+1000000000));
        m6.setRicetta(r2);
        user.getRicette().add(r2);
        Ricetta r3 = new Ricetta(m5, new ExpirationDate(System.currentTimeMillis()+1000000000));
        m5.setRicetta(r3);
        user.getRicette().add(r3);
        MainGui mainGui = new MainGui(user, farmacia);

        Scene scene = new Scene(mainGui, 750, 500);
        primaryStage.setTitle("Farmacia");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}