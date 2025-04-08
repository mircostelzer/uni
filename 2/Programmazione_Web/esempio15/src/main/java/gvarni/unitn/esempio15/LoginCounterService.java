package gvarni.unitn.esempio15;

import org.springframework.stereotype.Service;

@Service
public class LoginCounterService {
    private int counter = 0;

    public synchronized void increment() {
        this.counter++;
    }

    public int getCounter() {
        return counter;
    }
}
