class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean makeMove(GameBoard gameBoard, int row, int col) {
        if (!gameBoard.makeMove(row, col, symbol)) {
            System.out.println("Неприпустимий хід. Спробуйте ще раз.");
            return false;
        }
        return true;
    }
}
