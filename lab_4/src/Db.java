import java.sql.*;

class Db {
    String dbUrl = "jdbc:mariadb://localhost:3306/myGame?useSSL=false";
    String user = "mariauser";
    String password = "1234";
    Connection con;

    public Db() {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Завантаження драйвера MariaDB
            this.con = DriverManager.getConnection(dbUrl, user, password);
            if (con != null) {
                System.out.println("Успішне підключення до бд.");
            }
        } catch (Exception e) {
            System.out.println("Помилка при підключенні до бази даних: " + e.getMessage());
        }
    }

    public void close() {
        try {
            con.close(); // Закриття з'єднання з базою даних
        } catch (Exception e) {
            System.out.println(e); // Виведення повідомлення про помилку закриття з'єднання
        }
    }

    // Перевірка наявності користувача з заданим ім'ям в базі даних
    public boolean isUserExists(String username) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT count(*) FROM users WHERE username='" + username + "';");
            while (rs.next()) {
                if (rs.getInt(1) == 1)
                    return true;
                else
                    return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    // Перевірка правильності пароля для заданого користувача
    public boolean verifyPassword(String username, String password) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt
                    .executeQuery("SELECT password FROM users WHERE username='" + username + "';");
            while (rs.next()) {
                String storedPassword = rs.getString("password");
                // Порівняння введеного пароля із збереженною в базі данних
                return password.equals(storedPassword);
            }
        } catch (Exception e) {
            System.out.println(e); // Виведення повідомлення про помилку виконання запиту
        }
        return false; // Повертає false, якщо сталась помилка або пароль невірний
    }
}
