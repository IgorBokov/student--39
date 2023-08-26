package db;
/*
* тест для проверки вывода данных из базы данных*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_39?user = root&password = 324980");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students_39.student");
            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
