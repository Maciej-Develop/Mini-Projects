package maciej.dev.model;

import maciej.dev.model.tools.State;

public class Entity {

    private State state;

    public Entity(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
