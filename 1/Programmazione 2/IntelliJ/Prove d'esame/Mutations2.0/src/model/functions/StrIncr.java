package model.functions;

import model.geralt.Geralt;

public class StrIncr implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.str += 2;
    }
}
