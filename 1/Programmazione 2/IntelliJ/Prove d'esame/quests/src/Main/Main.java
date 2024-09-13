package Main;

import controller.GeraldoController;
import controller.SorterController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Geraldo;
import model.enums.Luoghi;
import model.enums.Mostri;
import model.enums.NPC;
import model.quests.*;
import view.GeraldoPane;
import view.VQPane;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        MainQuest lag = new MainQuest("Lilac and Gooseberries", 2 , Luoghi.White_Orchard, null);
        MainQuest tng = new MainQuest("The Nilfgaardian Connection", 3 , Luoghi.Velen, lag);
        MainQuest pon = new MainQuest("Pyres of Novigrad", 5 , Luoghi.Novigrad, tng);
        lag.setNext(tng);
        tng.setNext(pon);
        SecondaryQuest faf = new SecondaryQuest("Favor for a Friend", 2, 10, NPC.Keira_Metz);
        SecondaryQuest tlw = new SecondaryQuest("The Last Wish", 6, 30, NPC.Bloody_Baron);
        ArrayList<Mostri> m1 = new ArrayList<>();
        m1.add(Mostri.Drowners); m1.add(Mostri.Foglet);
        ContractQuest st = new ContractQuest("Swamp Thing", 12, 40, m1);
        ArrayList<Mostri> m2 = new ArrayList<>();
        m2.add(Mostri.Drowners);
        TreasureHunt cow = new TreasureHunt("Coast of Wrecks", 4, 50, m2, Luoghi.Novigrad);
        ArrayList<Mostri> m3 = new ArrayList<>();
        m3.add(Mostri.Drowners); m3.add(Mostri.Wolves);
        TreasureHunt df = new TreasureHunt("Dirty Funds", 1, 20, m3, Luoghi.Velen);
        DLCQuest ew = new DLCQuest("Envoys, Wineboys", 8, Luoghi.Velen, null, tng);
        DLCQuest ctc = new DLCQuest("Capture the Castle", 9, Luoghi.Toussaint, ew, tng);
        ew.setNext(ctc);

        ArrayList<Quest> amq = new ArrayList<>();
        amq.add(lag); amq.add(tng); amq.add(pon);
        ArrayList<Quest> asq = new ArrayList<>();
        asq.add(faf); asq.add(tlw);
        ArrayList<Quest> acq = new ArrayList<>();
        acq.add(st); acq.add(cow); acq.add(df);
        ArrayList<Quest> adq = new ArrayList<>();
        adq.add(ew); adq.add(ctc);

        Geraldo g = new Geraldo();

        // end of model
        GeraldoController gc = new GeraldoController(g);

        SorterController scm = new SorterController(amq, gc);
        SorterController scs = new SorterController(asq, gc);
        SorterController scc = new SorterController(acq, gc);
        SorterController scd = new SorterController(adq, gc);

        // end of controller

        GeraldoPane gp = gc.getGp();

        VQPane mqvb = scm.getVqp();
        VQPane sqvb = scs.getVqp();
        VQPane cqvb = scc.getVqp();
        VQPane dqvb = scd.getVqp();

        HBox hb = new HBox();
        hb.getChildren().add(mqvb);
        hb.getChildren().add(sqvb);
        hb.getChildren().add(cqvb);
        hb.getChildren().add(dqvb);
        hb.setSpacing(10);

        VBox vb = new VBox();
        vb.getChildren().add(gp);
        vb.getChildren().add(hb);
        vb.setSpacing(10);

        primaryStage.setTitle("QuestLog");
        primaryStage.setScene(new Scene(vb, 1000, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}