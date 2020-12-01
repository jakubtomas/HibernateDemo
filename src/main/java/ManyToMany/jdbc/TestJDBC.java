package ManyToMany.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

       /// String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false";
        String user = "root";
        String pass = "root";

        try {
            System.out.println("from file OnetoOne testjdbc");
            System.out.println("Connecting to database: " + jdbcUrl + "    user " + user  + "   pass    "+ pass);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful  yeeeeeeeees!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
