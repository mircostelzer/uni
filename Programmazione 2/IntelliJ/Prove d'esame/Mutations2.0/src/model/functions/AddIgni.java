package model.functions;

import model.geralt.Geralt;
import model.geralt.Spell;

public class AddIgni implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.spellist.add(Spell.Igni);
    }
}
