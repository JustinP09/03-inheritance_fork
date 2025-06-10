package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {

    protected Logger logger = LogManager.getLogger();
    private int t = 0;
    private final int duration;

    protected State(int duration){
        this.duration = duration;
    }

    final State tick(Cat cat){
        t++;
        if(t < duration){
            logger.info("Immernoch in " + getClass().getSimpleName());
            return this;
        }
        return successor(cat);
    }

    abstract State successor(Cat cat);

    public int getTime(){ return t; }
    public int getDuration(){ return duration; }
}
