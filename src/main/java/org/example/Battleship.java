package org.example;

public class Battleship extends Ship {

    private boolean[] isolatedParts; // array para controlar las partes aisladas del barco

    public Battleship(int x, int y, CardinalPoints direction) {
        super(5, x, y, direction);
        this.isolatedParts = new boolean[5]; // inicializamos el array con todos los valores a false
    }

    // método para obtener si todas las partes aisladas han sido atacadas
    public boolean allIsolatedPartsHit() {
        for(boolean part : isolatedParts) {
            if(!part) {
                return false;
            }
        }
        return true;
    }

    // método para establecer como atacada una parte aislada
    public void setIsolatedPartHit(int index) {
        isolatedParts[index] = true;
    }

    @Override
    public boolean getShot(int x, int y) {
        boolean hit = super.getShot(x, y);
        if(hit) {
            // si la posición ha sido impactada, comprobamos si es parte aislada
            int index = getPositionIndex(x, y);
            if(index > 0 && index < getSize() - 1) { // si la posición no es el extremo del barco
                isolatedParts[index - 1] = true;
                isolatedParts[index + 1] = true;
            }
            else if(index == 0) { // si la posición es el extremo izquierdo del barco
                isolatedParts[index + 1] = true;
            }
            else { // si la posición es el extremo derecho del barco
                isolatedParts[index - 1] = true;
            }
        }
        return hit;
    }

    private int getPositionIndex(int x, int y) {
        return 0;
    }
}

