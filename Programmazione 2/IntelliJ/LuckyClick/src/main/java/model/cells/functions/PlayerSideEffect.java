package model.cells.functions;

import model.Player;

public interface PlayerSideEffect {

    MyConsumer<Player> reveal();
}
