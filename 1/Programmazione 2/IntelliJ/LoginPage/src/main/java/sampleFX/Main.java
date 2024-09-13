package sampleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Login Page");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        Label welcome = new Label("Welcome");
        welcome.setFont(Font.font("VERDANA", FontWeight.SEMI_BOLD, 26));
        grid.add(welcome, 0, 0, 2, 1);
        welcome.setAlignment(Pos.CENTER_LEFT);

        Label username = new Label("Username: ");
        grid.add(username, 0, 1);
        username.setAlignment(Pos.CENTER_LEFT);
        username.setFont(Font.font("VERDANA",16));

        Label password = new Label("Password: ");
        grid.add(password, 0, 2);
        password.setAlignment(Pos.CENTER_LEFT);
        password.setFont(Font.font("VERDANA",16));

        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1, 2, 1);

        TextField passwordField = new TextField();
        grid.add(passwordField, 1, 2, 2, 1);

        Button signIn = new Button("Sign in");
        grid.add(signIn, 2, 3);
        HBox hb =  new HBox(signIn);
        grid.add(hb, 2, 3);
        hb.setAlignment(Pos.BOTTOM_RIGHT);

        signIn.setOnMouseClicked(mouseEvent -> {
            String uname = usernameField.getText();
            String pass = passwordField.getText();
            if (uname.equals("mircostelzer") && pass.equals("Ciao")) {
                primaryStage.close();
            }
            else {
                Label error = new Label("Wrong Username or Password");
                grid.add(error, 0, 5, 2, 1);
                error.setFont(Font.font("VERDANA", FontWeight.LIGHT, 14));
                error.setTextFill(Color.FIREBRICK);
                error.setAlignment(Pos.CENTER_LEFT);
            }
        });


        Scene scene = new Scene(grid, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}