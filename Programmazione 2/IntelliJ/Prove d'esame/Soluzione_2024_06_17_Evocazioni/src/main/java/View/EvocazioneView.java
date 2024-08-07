package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Evocazione.Evocazione;
import Model.Evocazione.EvocazioneSuprema;
import Model.Giocatore;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * La classe EvocazioneView estende StackPane e rappresenta la visualizzazione di una singola evocazione nel gioco.
 */
public class EvocazioneView extends StackPane {
    private Text text;
    private Evocazione evocazione;

    /**
     * Costruttore per creare una nuova visualizzazione di una evocazione.
     *
     * @param evocazione L'evocazione da visualizzare.
     * @param giocatore Il giocatore a cui appartiene l'evocazione.
     * @param mg L'istanza del controller MainGUI.
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     */
    public EvocazioneView(Evocazione evocazione, Giocatore giocatore, MainGUI mg, EvocazioniGiocatore evocazioniGiocatore) {
        super();
        this.evocazione = evocazione;
        text = new Text();
        setEvocazioneText();

        setAction(giocatore, mg, evocazioniGiocatore);

        Rectangle r = new Rectangle(100, 100);
        r.setFill(evocazione.getTipo().getColore());
        r.setStrokeWidth(5);
        if(evocazione instanceof EvocazioneSuprema)
            r.setStroke(Color.BLACK);
        else
            r.setStroke(evocazione.getTipo().getColore());

        getChildren().addAll(r, text);
    }

    /**
     * Imposta l'azione da eseguire quando si fa clic sull'evocazione.
     *
     * @param giocatore Il giocatore a cui appartiene l'evocazione.
     * @param mg L'istanza del controller MainGUI.
     * @param evocazioniGiocatore La visualizzazione delle evocazioni del giocatore.
     */
    private void setAction(Giocatore giocatore, MainGUI mg, EvocazioniGiocatore evocazioniGiocatore) {
        setOnMouseClicked(event -> {
            if (giocatore.isTurno() == MainGUI.isTurno()) {
                Evocazione evo = giocatore.getEvocazioni().get(0);
                if (evo.getEnergieAssegnate() >= evo.getAttacco().getEnergie()) {
                    evo.setAttacking(true);
                    if(evo instanceof EvocazioneSuprema) {
                        int dannoRicevuto;
                        ArrayList<Evocazione> toRemove = new ArrayList<>();
                        for (Evocazione evocazione : mg.getAltroGiocatore().getGiocatore().getEvocazioni()) {
                            dannoRicevuto = mg.getDisabled().getAttacco().getDanno(evocazione.getTipo());
                            evocazione.riceviAttacco(dannoRicevuto);
                            if(evocazione.getPvAttuali() <= 0) {
                                toRemove.add(evocazione);
                            } else {
                                mg.getAltroGiocatore().getEvocazioniGiocatore().creaEvocazioniGiocatore(mg);
                            }
                        }

                        for(Evocazione e : toRemove){
                            mg.getAltroGiocatore().getGiocatore().getEvocazioni().remove(e);
                            mg.getAltroGiocatore().getEvocazioniGiocatore().creaEvocazioniGiocatore(mg);
                        }

                        evo.setEnergieAssegnate();
                        evocazioniGiocatore.creaEvocazioniGiocatore(mg);

                        if(mg.getAltroGiocatore().getGiocatore().getEvocazioni().isEmpty()){
                            AlertDisplayer.display_CONFIRMATION_alert();
                        } else {
                            mg.getDisabled().setAttacking(false);
                            MainGUI.cambiaTurno();
                            mg.invertiGiocatori();
                        }
                    }
                } else {
                    AlertDisplayer.display_ERROR_alert("Non hai abbastanza energie per attaccare");
                }
            } else {
                if(mg.getDisabled() != null) {
                    if (!(mg.getDisabled() instanceof EvocazioneSuprema)) {
                        int dannoRicevuto = mg.getDisabled().getAttacco().getDanno(evocazione.getTipo());
                        evocazione.riceviAttacco(dannoRicevuto);
                        evocazioniGiocatore.creaEvocazioniGiocatore(mg);
                        if(evocazione.getPvAttuali() <= 0) {
                            mg.getAltroGiocatore().getGiocatore().getEvocazioni().remove(evocazione);
                            mg.getAltroGiocatore().getEvocazioniGiocatore().creaEvocazioniGiocatore(mg);
                        }
                        if(mg.getAltroGiocatore().getGiocatore().getEvocazioni().isEmpty()){
                            AlertDisplayer.display_CONFIRMATION_alert();
                        } else {
                            mg.getDisabled().setAttacking(false);
                            MainGUI.cambiaTurno();
                            mg.invertiGiocatori();
                        }
                    }
                } else {
                    AlertDisplayer.display_ERROR_alert("Non hai selezionato l'attaccante");
                }
            }
        });
    }

    /**
     * Imposta il testo della visualizzazione dell'evocazione basato sul metodo toString() dell'evocazione.
     */
    public void setEvocazioneText() {
        text.setText(evocazione.toString());
    }
}
