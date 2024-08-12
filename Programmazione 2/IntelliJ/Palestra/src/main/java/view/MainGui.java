package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.Archive;

public class MainGui extends BorderPane {
    private ArchivePane archivePane;
    private ButtonPane buttonPane;
    private AnchorPane anchorPane;
    private Button exit;

    public MainGui(Archive archive, Controller controller) {
        archivePane = new ArchivePane(archive);
        buttonPane = new ButtonPane(controller);
        anchorPane = new AnchorPane();
        exit = new Button("Exit");
        exit.setOnAction(e -> System.exit(0));
        anchorPane.getChildren().add(exit);
        AnchorPane.setRightAnchor(exit, 0.0);
        anchorPane.setPadding(new Insets(10, 10, 10, 10));

        this.setTop(buttonPane);
        this.setCenter(archivePane);
        this.setBottom(anchorPane);
    }

    public void redraw() {
        archivePane.redraw();
    }
}
