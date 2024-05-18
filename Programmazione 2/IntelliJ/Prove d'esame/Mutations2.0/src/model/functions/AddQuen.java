package model.functions;

import model.geralt.Geralt;
import model.geralt.Spell;

public class AddQuen implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.spellist.add(Spell.Quen);
    }
}
