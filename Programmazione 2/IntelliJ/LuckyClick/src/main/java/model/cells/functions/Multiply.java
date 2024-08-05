package model.cells.functions;

import model.Player;

public class Multiply implements MyConsumer<Player> {
    @Override
    public void accept(Player player) {
        player.setPoints(player.getPoints()*2);
    }
}
