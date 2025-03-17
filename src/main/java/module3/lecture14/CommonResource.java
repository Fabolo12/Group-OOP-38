package module3.lecture14;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class CommonResource {

    private int x;
    private AtomicInteger atomic = new AtomicInteger(0);


    public void increment() {
        atomic.incrementAndGet();
    }
}
