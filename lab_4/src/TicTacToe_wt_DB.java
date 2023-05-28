import java.util.Scanner;

public class TicTacToe_wt_DB {
    public static void main(String[] args) {
        Db database = new Db();
        Scanner scanner = new Scanner(System.in);
        Player[] players = new Player[2];

        System.out.println("\n\t TicTacToe\n");

        for (int i = 0; i < 2; i++) {
            String name;
            boolean validUser = false;

            while (!validUser) {
                System.out.print("Введіть ім'я гравця " + (i + 1) + ": ");
                name = scanner.nextLine();

                if (database.isUserExists(name)) {
                    System.out.print("Введіть пароль: ");
                    String password = scanner.nextLine();

                    // Перевірка, чи співпадає введені ім'я користувача та пароль
                    // із наявними у базі данних
                    if (database.verifyPassword(name, password)) {
                        validUser = true;
                        players[i] = new Player(name, (i == 0) ? 'X' : 'O');
                    } else {
                        System.out.println("Неправильний пароль. Спробуйте ще раз.");
                    }
                } else {
                    System.out.println("Гравця з таким ім'ям не знайдено. Спробуйте ще раз.");
                }
            }
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
                database.close(); // Закриття з'єднання з базою даних
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
