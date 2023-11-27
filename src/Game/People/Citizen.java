package Game.People;

import Game.Buildings.Building;

import java.util.UUID;

public class Citizen {
    private final UUID id;
    private Building home;
    private Building workplace;

    public Citizen(Building home) {
        this.id = UUID.randomUUID();
        this.home = home;
        this.workplace = null;
    }

    public UUID getId() {
        return id;
    }

    public Building getHome() {
        return home;
    }

    public void setHome(Building home) {
        this.home = home;
    }

    public Building getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Building workplace) {
        this.workplace = workplace;
    }

}
