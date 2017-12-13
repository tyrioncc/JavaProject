package dev.test1;

import java.sql.*;

/**
 * 测试数据库联机
 */
class TestDB {
    public static void main(String args[])
    {
        try
        {
            runTest();
        }
        catch (SQLException ex)
        {
            for (Throwable t : ex)
                t.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    private static void runTest() throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        try
        {
            Statement stat = con.createStatement();

            stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20))");
            stat.executeUpdate("INSERT INTO Greetings VALUES ('Hello, World!')");

            ResultSet result = stat.executeQuery("SELECT * FROM Greetings");
            if (result.next())
                System.out.println(result.getString(1));
            result.close();
            stat.executeUpdate("DROP TABLE Greetings");
        }
        finally
        {
            con.close();
        }
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/javademo?"
                + "user=root&password=RootJJY" +
                "&useUnicode=true&characterEncoding=UTF8" +
                "&serverTimezone=GMT%2b8" +
                "&useSSL=true";

        return DriverManager.getConnection(url);
    }
}
