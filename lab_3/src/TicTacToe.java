import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];

        System.out.println("\n\t TicTacToe\n");

        for (int i = 0; i < 2; i++) {
            System.out.print("Введіть ім'я гравця " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players[i] = new Player(name, (i == 0) ? 'X' : 'O');
        }

        GameBoard gameBoard = new GameBoard();
        Player currentPlayer = players[0];

        while (true) {
            gameBoard.printBoard();

            while (true) {
                int row = getPlayerInput(currentPlayer.getName() + ", введіть рядок: ");
                int col = getPlayerInput(currentPlayer.getName() + ", введіть стовпець: ");
                if (!currentPlayer.makeMove(gameBoard, row - 1, col - 1)) {
                    continue;
                }
                break;
            }


            if (gameBoard.checkWin(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " переміг!");
                break;
            }

            // Зміна поточного гравця
            currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
        }
    }

    private static int getPlayerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }
}
