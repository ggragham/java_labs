class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
        System.out.println("");
    }

    public boolean makeMove(int row, int col, char playerSymbol) {
        if (isValidMove(row, col)) {
            board[row][col] = playerSymbol;
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public boolean checkWin(char playerSymbol) {
        // Перевірка рядків і стовпців
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == playerSymbol && board[i][1] == playerSymbol
                    && board[i][2] == playerSymbol)
                return true; // Перевірка рядків
            if (board[0][i] == playerSymbol && board[1][i] == playerSymbol
                    && board[2][i] == playerSymbol)
                return true; // Перевірка стовпців
        }

        // Перевірка діагоналей
        if (board[0][0] == playerSymbol && board[1][1] == playerSymbol
                && board[2][2] == playerSymbol)
            return true; // Головна діагональ
        if (board[0][2] == playerSymbol && board[1][1] == playerSymbol
                && board[2][0] == playerSymbol)
            return true; // Побічна діагональ

        return false;
    }
}
