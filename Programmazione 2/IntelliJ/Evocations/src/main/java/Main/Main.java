package Main;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Energy;
import model.Player;
import model.attacks.DarknessAttack;
import model.attacks.FireAttack;
import model.attacks.NeutralAttack;
import model.attacks.WaterAttack;
import model.evocations.NormalEvocation;
import model.evocations.SupremeEvocation;
import view.MainGui;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("PLayer 2");
        player1.addEvocation(new NormalEvocation("Ifrit", Energy.Fire, 30, new FireAttack("Hellflame", 20, 2)));
        player1.addEvocation(new SupremeEvocation("Phoenix", Energy.Fire, 50, new FireAttack("Fiammata", 20, 2)));
        player1.addEvocation(new NormalEvocation("Diablos", Energy.Darkness, 50, new DarknessAttack("Demi", 20, 1)));
        player2.addEvocation(new NormalEvocation("Leviathan", Energy.Water, 30, new WaterAttack("Tsunami", 10, 1)));
        player2.addEvocation(new SupremeEvocation("Bahamut", Energy.Neutral, 60, new NeutralAttack("MegaFlare", 40, 3)));
        player2.addEvocation(new NormalEvocation("Alexander", Energy.Neutral, 30, new NeutralAttack("Judgement", 10, 1)));
        player1.addEnergy(Energy.Fire);
        player1.addEnergy(Energy.Fire);
        player1.addEnergy(Energy.Neutral);
        player1.addEnergy(Energy.Neutral);
        player1.addEnergy(Energy.Darkness);
        player2.addEnergy(Energy.Water);
        player2.addEnergy(Energy.Water);
        player2.addEnergy(Energy.Neutral);
        player2.addEnergy(Energy.Darkness);

        Controller controller = new Controller(player1, player2);

        MainGui mainGui = controller.getMainGui();


        Scene scene = new Scene(mainGui, 450, 400);
        primaryStage.setTitle("Evocations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}