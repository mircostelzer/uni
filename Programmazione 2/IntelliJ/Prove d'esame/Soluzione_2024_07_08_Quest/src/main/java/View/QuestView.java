package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Quest;
import Model.Quests.ContractQuest;
import Model.Quests.DLCQuest;
import Model.Quests.MainQuest;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class QuestView extends VBox {
    private Quest quest;
    private Button completa;
    private Rectangle r;

    /**
     * crea la vista di una singola quest
     * se la quest è completata crea la vista con la quest verde e il bottone disattivato
     * altrimenti crea la vista con quest lightgreen e bottone attivato
     * @param quest
     */
    public QuestView(Quest quest) {
        this.quest = quest;
        r = new Rectangle(240, 60);

        completa = new Button("Completa");
        if(quest.isCompleta()){
            r.setFill(Color.LIGHTGREEN);
            completa.setDisable(true);
        } else {
            r.setFill(Color.BEIGE);
            setCompletaAction();
        }

        setAlignment(Pos.CENTER);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(r, new Text(quest.toString()));
        getChildren().addAll(sp, completa);
    }

    /**
     * attiva il bottone completa
     * in base ad una serie di verifiche completa la quest oppure lancia un messaggio di alert
     */
    private void setCompletaAction() {
        completa.setOnAction(event -> {
            boolean isCompletabile = false;
            if(MainGUI.getGeraldo().getLivello() >= quest.getLivelloMinimo()){
                if(quest instanceof DLCQuest d){
                    if(d.getPrecedente() == null || d.getPrecedente().isRisolta()){
                        if(d.getCollegata().isRisolta()){
                            isCompletabile = true;
                        } else {
                            AlertDisplayer.displayErrorAlert("Devi prima completare la main quest collegata");
                        }
                    } else {
                        AlertDisplayer.displayErrorAlert("Devi prima completare la quest precedente");
                    }
                } else if(quest instanceof MainQuest m){
                    if(m.getPrecedente() == null || m.getPrecedente().isRisolta()){
                        isCompletabile = true;
                    } else {
                        AlertDisplayer.displayErrorAlert("Devi prima completare la quest precedente");
                    }
                } else {
                    isCompletabile = true;
                }
            } else {
                AlertDisplayer.displayErrorAlert("Il tuo livello di " + MainGUI.getGeraldo().getLivello() + " non è abbastanza alto per una quest che richiede livello minimo: " + quest.getLivelloMinimo());
            }

            if(isCompletabile){
                r.setFill(Color.LIGHTGREEN);
                completa.setDisable(true);
                if(quest instanceof MainQuest m)
                    m.setRisolta();
                quest.setCompleta();
                MainGUI.getGeraldo().setLivello(MainGUI.getGeraldo().getLivello()+quest.getAumentoLivello());
                if(quest instanceof ContractQuest c)
                    MainGUI.getGeraldo().setSoldi(MainGUI.getGeraldo().getSoldi()+c.getRicompensaAggiuntiva());
                else
                    MainGUI.getGeraldo().setSoldi(MainGUI.getGeraldo().getSoldi()+quest.getRicompensa());
                MainGUI.aggiornaGeraldoStats();
            }
        });
    }
}
