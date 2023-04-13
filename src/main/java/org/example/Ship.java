package org.example;

public class Ship {
    private int size;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private CardinalPoints direction;
    private int hits;

    public Ship(int size, int startX, int startY, int endX, int endY) {
        this.size = size;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        if (!isValidShip()) {
            throw new IllegalArgumentException("Coordenadas de barco inválidas");
        }
    }

    public int getSize() {
        return size;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public boolean isSunk() {
        return hits >= size;
    }

    public boolean getShot(int x, int y) {
        if (isPointInShip(x, y)) {
            hits++;
            return true;
        }
        return false;
    }

    private boolean isValidShip() {
        if (startX == endX && startY == endY) {
            return false;
        }
        if (startX == endX) {
            direction = CardinalPoints.NORTH;
            if (startY > endY) {
                int temp = startY;
                startY = endY;
                endY = temp;
            }
            return (endY - startY + 1 == size);
        } else if (startY == endY) {
            direction = CardinalPoints.EAST;
            if (startX > endX) {
                int temp = startX;
                startX = endX;
                endX = temp;
            }
            return (endX - startX + 1 == size);
        } else {
            return false;
        }
    }

    private boolean isPointInShip(int x, int y) {
        if (direction == CardinalPoints.NORTH) {
            return (x == startX && y >= startY && y <= endY);
        } else {
            return (y == startY && x >= startX && x <= endX);
        }
    }

    public void hit() {
        hits++;
    }
}

