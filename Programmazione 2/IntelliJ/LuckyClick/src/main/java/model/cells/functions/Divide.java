package model.cells.functions;

import model.Player;

public class Divide implements MyConsumer<Player> {
    @Override
    public void accept(Player player) {
        int pp = player.getPoints();
        if (pp != 0) {
            player.setPoints(pp / 2);
        }
    }
}
