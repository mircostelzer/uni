package sampleFX;

public class Grid {
    private String[][] spaces;
    final static String PLAYER = "X";
    final static String COMPUTER = "O";
    private boolean gameOver = false;

    public Grid() {
        super();
        this.spaces = new String[3][3];
    }

    public String getCell(int row, int col) {
        return spaces[row][col];
    }

    public void setCell(int row, int col, String cell) {
        spaces[row][col] = cell;
    }

    public void move(int row, int col, String s) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (spaces[row][col] == null) {
                this.setCell(row, col, s);
            }
        }
    }

    public boolean isGameOver() {
        if (playerWin() || computerWin()) {
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

}
