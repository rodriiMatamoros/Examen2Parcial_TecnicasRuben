package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/*
* No he conseguido que el main funcione, no se se porque import o clase es que no me dan errores en el programa
* pero a la hora de runner el main no me funciona
* */
public class Main {
    public static void main(String[] args) {

        // Creamos los usuarios que van a jugar pedidos por consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del usuario 1: ");
        User user1 = new User(scanner.nextLine());
        System.out.print("Nombre del usuario 2: ");
        User user2 = new User(scanner.nextLine());


        // Obtenemos la configuración de donde se colocan los barcos a cada usuario
        System.out.println("Configuración de los barcos de " + user1.getName() + ": ");
        user1.setShips(getShipsConfiguration(scanner));
        System.out.println("Configuración de los barcos de " + user2.getName() + ": ");
        user2.setShips(getShipsConfiguration(scanner));

        // Creamos donde se juega con el tamaño del tablero
        Board board = new Board(10);


        // Imprimimos el tablero de juego
        System.out.println("Tablero de juego: ");
        System.out.println(board);

        // Creamos un objeto para generar números aleatorios
        Random random = new Random();

        // Comenzamos el juego
        boolean gameOver = false;
        User winner = null;
        while (!gameOver) {
            // Turno de user1
            Point shotPoint1 = new Point(random.nextInt(board.getSize()), random.nextInt(board.getSize()));
            int getShot = random.nextInt(2) + 1;
            boolean hit1 = user1.attack(getShot, user2);
            System.out.println(user1.getName() + " ataca en " + shotPoint1 + ": " + (hit1 ? "HIT" : "MISS"));
            System.out.println(user2.getName() + ": " + user2.getBoard());
            if (!user2.isAlive()) {
                winner = user1;
                gameOver = true;
                break;
            }

            // Turno de user2
            Point shotPoint2 = new Point(random.nextInt(board.getSize()), random.nextInt(board.getSize()));
            boolean hit2 = user2.attack(getShot, user1);
            System.out.println(user2.getName() + " ataca en " + shotPoint2 + ": " + (hit2 ? "HIT" : "MISS"));
            System.out.println(user1.getName() + ": " + user1.getBoard());
            if (!user1.isAlive()) {
                winner = user2;
                gameOver = true;
                break;
            }
        }

        // Imprimimos el resultado final del juego
        if (winner != null) {
            System.out.println("¡" + winner.getName() + " gana!");
        } else {
            System.out.println("¡Empate!");
        }
    }

    private static List<Ship> getShipsConfiguration(Scanner scanner) {
        List<Ship> ships = new ArrayList<>();
        while (ships.size() < 3) {
            System.out.print("Tipo de barco (battleship/frigate/canoe): ");
            String shipType = scanner.nextLine();
            System.out.print("Posición inicial (fila columna): ");
            String[] startPosStr = scanner.nextLine().split(" ");
            Point startPos = new Point(Integer.parseInt(startPosStr[0]), Integer.parseInt(startPosStr[1]));
            System.out.print("Orientación (horizontal/vertical): ");
            String orientationStr = scanner.nextLine();
            CardinalPoints orientation = CardinalPoints.valueOf(orientationStr.toUpperCase());
            try {
                if (shipType.equalsIgnoreCase("battleship")) {
                    //ships.add(new Battleship(startPos, orientation));
                } else if (shipType.equalsIgnoreCase("frigate")) {
                    //ships.add(new Frigate(startPos, orientation));
                } else if (shipType.equalsIgnoreCase("canoe")) {
                    //ships.add(new Canoe(startPos, orientation));
                } else {
                    System.out.println("Tipo de barco no válido.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return ships;
    }


    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static class Board {
        private int size;
        private boolean[][] board;

        public Board(int size) {
            this.size = size;
            this.board = new boolean[size][size];
        }

        public int getSize() {
            return size;
        }

        public boolean[][] getBoard() {
            return board;
        }

        public void setBoard(boolean[][] board) {
            this.board = board;
        }

        public boolean isFree(Point point) {
            return !board[point.getX()][point.getY()];
        }

        public void setPoint(Point point) {
            board[point.getX()][point.getY()] = true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sb.append(board[i][j] ? "X" : "O");
                }
                sb.append(" ");
            }
            return sb.toString();
        }


    }
}


