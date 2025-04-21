package gvarni.unitn.esempio17;

import org.springframework.stereotype.Service;


@Service
public class LoginCounterService {

    private int counter = 0;
    public synchronized int getCounter(){return this.counter;}

    public synchronized void incrementCounter(){this.counter++;}

}
