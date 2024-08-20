package Main;

import Main.model.Giocatore;
import Main.model.energies.*;
import Main.model.summons.Evocazione;
import Main.model.summons.EvocazioneBase;
import Main.model.summons.EvocazioneSuprema;
import Main.model.summons.concrete.*;
import Main.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        EvocazioneBase ifrit = new Ifrit();
        EvocazioneSuprema phoenix = new Phoenix();
        EvocazioneBase diablos = new Diablos();
        ArrayList<Evocazione> evg1 = new ArrayList<>();
        evg1.add(ifrit);
        evg1.add(phoenix);
        evg1.add(diablos);
        ArrayList<Energy> eng1 = new ArrayList<>();
        eng1.add(new EnergyFuoco());
        eng1.add(new EnergyFuoco());
        eng1.add(new EnergyNeutra());
        eng1.add(new EnergyNeutra());
        eng1.add(new EnergyTenebra());
        Giocatore g1 = new Giocatore(1, evg1, eng1);

        EvocazioneBase leviathan = new Leviathan();
        EvocazioneSuprema bahamut = new Bahamut();
        EvocazioneBase alexander = new Alexander();
        ArrayList<Evocazione> evg2 = new ArrayList<>();
        evg2.add(leviathan);
        evg2.add(bahamut);
        evg2.add(alexander);
        ArrayList<Energy> eng2 = new ArrayList<>();
        eng2.add(new EnergyAcqua());
        eng2.add(new EnergyAcqua());
        eng2.add(new EnergyNeutra());
        eng2.add(new EnergyTenebra());
        Giocatore g2 = new Giocatore(2, evg2, eng2);

        g1.setAltroGiocatore(g2);
        g2.setAltroGiocatore(g1);

        MainView mv = new MainView(g1, g2);

        primaryStage.setTitle("Evocazioni");
        Scene s = new Scene(mv, 400, 400);
        primaryStage.setScene(s);
        primaryStage.show();

//        s.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
////            if (e.getCode() == KeyCode.F) {
////                mv.flipPlayers();
////            }
////            try{
////                if (e.getCode() == KeyCode.I){
////                    ifrit.attack(g2.getEvocazioni());
////                } else if (e.getCode() == KeyCode.P){
////                    phoenix.attack(g2.getEvocazioni());
////                } else if (e.getCode() == KeyCode.D){
////                    diablos.attack(g2.getEvocazioni());
////                }
////                if (e.getCode() == KeyCode.L){
////                    leviathan.attack(g1.getEvocazioni());
////                } else if (e.getCode() == KeyCode.B){
////                    bahamut.attack(g1.getEvocazioni());
////                } else if (e.getCode() == KeyCode.A){
////                    alexander.attack(g1.getEvocazioni());
////                }
////            } catch (WrongEnergiesException ex) {
////                throw new RuntimeException(ex);
////            }
//        });

    }
    public static void main(String[] args) {
        launch(args);
    }
}