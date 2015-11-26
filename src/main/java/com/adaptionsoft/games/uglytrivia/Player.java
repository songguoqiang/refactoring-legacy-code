package com.adaptionsoft.games.uglytrivia;

public class Player {
    private final String name;
    private int place;

    public Player(String name) {
        this.name = name;
    }

    public String toString(){
        return name;

    }

    public int place() {
        return place;
    }
}
