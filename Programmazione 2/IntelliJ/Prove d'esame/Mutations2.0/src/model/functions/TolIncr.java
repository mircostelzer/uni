package model.functions;

import model.geralt.Geralt;

public class TolIncr implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.tol += 2;
    }
}
