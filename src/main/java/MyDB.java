import java.sql.*;

//Создать небольшую БД (таблица: студенты; поля: id, фамилия, балл). Написать тесты для проверки того,
// что при работе с базой корректно добавляются, обновляются и читаются записи.
// Следует учесть что в базе есть заранее добавленные записи, и после проведения тестов
// эти записи не должны быть удалены/изменены/добавлены.

public class MyDB {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String testConnection() throws SQLException {
        connect();
        String sql = String.format("SELECT surname FROM students");

        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                System.out.println(rs.getString(1));
                return rs.getString(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    public void newEntry(String surname, int grade) throws SQLException {

        if(grade > 0 && grade <= 5) {
            String sql = String.format("INSERT into students (surname, grades) VALUES ('%s', '%d');", surname, grade);
            stmt.executeUpdate(sql);
        } else System.out.println("В нашем университете ставят оценки от 1 до 5");

    }

    public String readEntry(int id) throws SQLException {

        String result = null;
        String sql = String.format("SELECT surname, grades FROM students where id='%d'", id);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    public String readEntry(String surname) throws SQLException {

        String sql = String.format("SELECT surname, grades FROM students where surname='%s'", surname);
        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()) {
            String s = rs.getString(1);
            return s;
        }
        return null;
    }

    public void deleteEntry(int id) throws SQLException {

        String sql = String.format("DELETE from students where id ='%d';", id);
        stmt.executeUpdate(sql);

    }

    public void readAll() throws SQLException {

        String sql = String.format("SELECT * from students");
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString(2) + " " + rs.getInt(3));
        }
    }

    public int getID(String surname) throws SQLException {

        String sql = String.format("SELECT id from students where surname='%s'", surname);
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) {
            int x = rs.getInt(1);
            return x;
        }
        return -1;
    }
}
