package fr.polytech.sim.cycling;

import fr.polytech.sim.transport.Wheel;

public class TagAlongBike extends Bike{

    public TagAlongBike() {
        components.add(new Wheel(this));
        components.add(new Wheel(this));
        components.add(new SimpleBike());
    }
}
