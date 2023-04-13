package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Ship> ships;
    private boolean isAlive;

    public User(List<Ship> ships) throws IllegalArgumentException {
        if (ships == null || ships.isEmpty()) {
            throw new IllegalArgumentException("El usuario debe tener al menos un barco.");
        }

        this.ships = ships;
        this.isAlive = true;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean attack(int x, int y, User user) throws ArrayIndexOutOfBoundsException {
        for (Ship ship : user.getShips()) {
            if (ship.getHits() >= ship.getSize()) {
                continue;
            }
            for (int i = 0; i < ship.getSize(); i++) {
                int shipX = ship.getStartX() + (ship.getDirection() == CardinalPoints.EAST ? i : 0)
                        - (ship.getDirection() == CardinalPoints.WEST ? i : 0);
                int shipY = ship.getEndY() + (ship.getDirection() == CardinalPoints.SOUTH ? i : 0)
                        - (ship.getDirection() == CardinalPoints.NORTH ? i : 0);
                if (x == shipX && y == shipY) {
                    ship.hit();
                    if (ship.getHits() >= ship.getSize()) {
                        if (user.allShipsSunk()) {
                            user.die();
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }



    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (ship.getHits() < ship.getSize()) {
                return false;
            }
        }
        return true;
    }

    public void die() {
        isAlive = false;
    }
}

