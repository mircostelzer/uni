package model.mutations;

import javafx.scene.paint.Color;
import model.geralt.Geralt;
import model.functions.MyConsumer;

public interface MutationInterface {

    MyConsumer<Geralt> applica();
    MyConsumer<Geralt> rimuovi();

    void clicked();

    Color getMutationColor();
}
