package view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Archive;
import model.interfaces.PersonInterface;

import java.util.ArrayList;

public class ArchivePane extends VBox {
    private Archive archive;

    public ArchivePane(Archive archive) {
        this.archive = archive;
        this.setPadding(new Insets(20, 20, 20, 20));
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        ArrayList<PersonInterface> people = archive.getShowingList();
        for (PersonInterface p : people) {
            this.getChildren().add(new Text(p.toString() + " | " + p.getTariffa()));
        }
    }

}
