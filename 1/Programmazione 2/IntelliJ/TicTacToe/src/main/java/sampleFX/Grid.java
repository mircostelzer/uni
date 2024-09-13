package sampleFX;

import java.util.Random;

public class Grid {
    private String[][] spaces;
    final static String PLAYER = "X";
    final static String COMPUTER = "O";
    private boolean gameOver = false;
    private boolean start;

    public Grid() {
        super();
        Random r = new Random();
        int n = r.nextInt(2);
        start = n == 0;
        this.spaces = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.spaces[i][j] = " ";
            }
        }
    }

    public boolean getStart() {
        return start;
    }

    public String getCell(int row, int col) {
        return spaces[row][col];
    }

    public void setCell(int row, int col, String cell) {
        spaces[row][col] = cell;
    }

    public void move(int row, int col, String s) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (spaces[row][col] == " ") {
                this.setCell(row, col, s);
            }
        }
    }

    public boolean isGameOver() {
        if (playerWin() || computerWin() || tie()) {
            this.gameOver = true;
        }
        return gameOver;
    }

    public boolean win(String s) {
        return (((spaces[0][0].equals(s)) && (spaces[0][0].equals(spaces[0][1])) && (spaces[0][0].equals(spaces[0][2]))) ||
                ((spaces[1][0].equals(s)) && (spaces[1][0].equals(spaces[1][1])) && (spaces[1][0].equals(spaces[1][2]))) ||
                ((spaces[2][0].equals(s)) && (spaces[2][0].equals(spaces[2][1])) && (spaces[2][0].equals(spaces[2][2]))) ||
                ((spaces[0][0].equals(s)) && (spaces[0][0].equals(spaces[1][0])) && (spaces[0][0].equals(spaces[2][0]))) ||
                ((spaces[0][1].equals(s)) && (spaces[0][1].equals(spaces[1][1])) && (spaces[0][1].equals(spaces[2][1]))) ||
                ((spaces[0][2].equals(s)) && (spaces[0][2].equals(spaces[1][2])) && (spaces[0][2].equals(spaces[2][2]))) ||
                ((spaces[0][0].equals(s)) && (spaces[0][0].equals(spaces[1][1])) && (spaces[0][0].equals(spaces[2][2]))) ||
                ((spaces[0][2].equals(s)) && (spaces[0][2].equals(spaces[1][1])) && (spaces[0][2].equals(spaces[2][0]))));
    }

    public boolean playerWin() {
        return this.win(PLAYER);
    }

    public boolean computerWin() {
        return this.win(COMPUTER);
    }

    public boolean tie() {
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.spaces[i][j].equals(" ")) {
                    res = false;
                }
            }
        }

        return res;
    }

    public void computer() {
        boolean placed = false;
        while (!placed) {
            Random r = new Random();
            int choice = r.nextInt(9);
            if (spaces[choice/3][choice%3] == " ") {
                placed = true;
                spaces[choice/3][choice%3] = COMPUTER;
            }
        }
    }


}
