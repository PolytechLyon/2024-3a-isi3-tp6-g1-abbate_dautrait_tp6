package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {
    private final int time;
    private static final Clock instance = new Clock();

    /**
     * Random integer between 0 and 24 inclusive.
     */
    private Clock(){
        time=new Random().nextInt(25);
    }
    public static Clock getInstance() {
        return instance;
    }
    public int getTime() {
        return time;
    }
}
