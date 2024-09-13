package model.functions;

import model.geralt.Geralt;

public class VelDecr implements MyConsumer<Geralt>{

    @Override
    public void accept(Geralt geralt) {
        geralt.vel -= 2;
    }
}
