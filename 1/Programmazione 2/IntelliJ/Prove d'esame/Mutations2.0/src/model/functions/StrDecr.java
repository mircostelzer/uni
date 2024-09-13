package model.functions;

import model.geralt.Geralt;

public class StrDecr implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.str -= 2;
    }
}
