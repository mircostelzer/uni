package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.geralt.Geralt;
import Model.geralt.Mutation;
import Model.mutations.muts.combat.StrCombatMutation;
import Model.mutations.muts.combat.VelCombatMutation;
import Model.mutations.muts.potions.TolPotionMutation;
import Model.mutations.muts.spells.IgniSpellMutation;
import Model.mutations.muts.spells.QuenSpellMutation;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Classe per creare il pannello dei pulsanti che permettono di applicare e rimuovere mutazioni a Geralt.
 */
public class ButtonPane extends HBox {
    private static final int RECTANGLE_SIZE = 50;
    private MainGUI mg;

    /**
     * Costruttore per creare il pannello dei pulsanti.
     *
     * @param mg L'oggetto MainGUI che gestisce l'interfaccia principale.
     */
    public ButtonPane(MainGUI mg) {
        super();
        this.mg = mg;
        Geralt geralt = mg.getGeralt();

        String[] s = {geralt.isPresent(Mutation.Str) + "Str",
                geralt.isPresent(Mutation.Vel) + "Vel",
                geralt.isPresent(Mutation.Tol) + "Tol",
                geralt.isPresent(Mutation.Igni) + "Igni",
                geralt.isPresent(Mutation.Quen) + "Quen"};

        Color[] c = {Color.CRIMSON, Color.CRIMSON, Color.CHARTREUSE, Color.CADETBLUE, Color.CADETBLUE};

        for (int i = 0; i < 5; i++) {
            StackPane sp = creaSlot(s[i], c[i]);
            super.getChildren().add(sp);
        }
    }

    /**
     * Crea uno slot con un rettangolo colorato e un testo che rappresenta una mutazione.
     *
     * @param s Il testo della mutazione.
     * @param c Il colore del rettangolo.
     * @return Lo StackPane contenente il rettangolo e il testo.
     */
    private StackPane creaSlot(String s, Color c) {
        Rectangle r = new Rectangle(RECTANGLE_SIZE, RECTANGLE_SIZE);
        r.setFill(c);
        r.setStroke(Color.BLACK);
        Text t = new Text(s);
        StackPane sp = new StackPane(r, t);
        sp.setOnMouseClicked(event -> {
            Mutation k = riconosci_mutazione(s);
            Geralt g = mg.getGeralt();
            if (g.isPresent(k).equals("-")) {
                rimuovi_mutazione(k, g);
                t.setText("+" + k);
            } else if (g.isPresent(k).equals("+")) {
                if (k == Mutation.Tol) {
                    applica_mutazione(k, g);
                    t.setText("-" + k);
                } else if(!(g.getMutations().get(0) != Mutation.Empty && g.getMutations().get(1) != Mutation.Empty && g.getMutations().get(3) != Mutation.Empty)) {
                    applica_mutazione(k, g);
                    t.setText("-" + k);
                } else
                    AlertDisplayer.display_error_alert("Non puoi aggiungere altre mutazioni di questo tipo, lo slot aggiuntivo è già occupato!");
            }

            mg.getMutationsPane().creaTesti(g);
            mg.getSpellsPane().aggiornaStatistiche(g);
            mg.getStatsPane().creaTesto(g);
        });
        return sp;
    }

    /**
     * Riconosce la mutazione dal testo fornito.
     *
     * @param s Il testo che descrive la mutazione.
     * @return La mutazione riconosciuta.
     */
    private Mutation riconosci_mutazione(String s) {
        if (s.contains("Str"))
            return Mutation.Str;
        else if (s.contains("Vel"))
            return Mutation.Vel;
        else if (s.contains("Tol"))
            return Mutation.Tol;
        else if (s.contains("Igni"))
            return Mutation.Igni;
        else if (s.contains("Quen"))
            return Mutation.Quen;
        return null;
    }

    /**
     * Applica la mutazione specificata a Geralt.
     *
     * @param m La mutazione da applicare.
     * @param g Il personaggio Geralt.
     */
    private void applica_mutazione(Mutation m, Geralt g) {
        switch (m) {
            case Str:
                new StrCombatMutation(g).applica();
                break;
            case Vel:
                new VelCombatMutation(g).applica();
                break;
            case Tol:
                new TolPotionMutation(g).applica();
                break;
            case Igni:
                new IgniSpellMutation(g).applica();
                break;
            case Quen:
                new QuenSpellMutation(g).applica();
                break;
        }
    }

    /**
     * Rimuove la mutazione specificata da Geralt.
     *
     * @param m La mutazione da rimuovere.
     * @param g Il personaggio Geralt.
     */
    private void rimuovi_mutazione(Mutation m, Geralt g) {
        switch (m) {
            case Str:
                new StrCombatMutation(g).rimuovi();
                break;
            case Vel:
                new VelCombatMutation(g).rimuovi();
                break;
            case Tol:
                new TolPotionMutation(g).rimuovi();
                break;
            case Igni:
                new IgniSpellMutation(g).rimuovi();
                break;
            case Quen:
                new QuenSpellMutation(g).rimuovi();
                break;
        }
    }
}
