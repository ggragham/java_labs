public class Main {
    public static void main(String[] args) {
        int treeHeight = 5; // Высота ялинки
        printTree(treeHeight);

        System.out.println();

        int arrayRows = 3; // Кількість рядків масиву цілих чисел
        int arrayColumns = 4; // Кількість стовпців масиву цілих чисел
        int startNumber = 10;
        printArray(arrayRows, arrayColumns, startNumber);
    }

    // Метод для виведення ялинки заданої висоти
    private static void printTree(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Метод для виведення масиву цілих чисел, де кожне наступне число є на 3 більше за попереднє
    private static void printArray(int arrayRows, int arrayColumns, int startNumber) {
        int[][] array = new int[arrayRows][arrayColumns];

        for (int i = 0; i < arrayRows; i++) {
            for (int j = 0; j < arrayColumns; j++) {
                if (i == 0 && j == 0) {
                    array[i][j] = startNumber;
                } else if (j == 0) {
                    array[i][j] = array[i - 1][arrayColumns - 1] + 3;
                } else {
                    array[i][j] = array[i][j - 1] + 3;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
