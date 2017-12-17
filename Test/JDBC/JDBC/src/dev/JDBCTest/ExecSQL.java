package dev.JDBCTest;

import java.io.*;
import java.util.*;
import java.sql.*;

/**
 * 在一个文件内执行所有sql语句
 */
class ExecSQL
{
    public static void main(String args[])
    {
        try
        {
            Scanner in = null;
            if (args.length == 0)
                in = new Scanner(System.in);
            else {
                try {
                    in = new Scanner(new File(args[0]));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            Connection con = getConnection();
            try
            {
                Statement stat = con.createStatement();

                fileSql1 = getSqlSyntaxList(File1);
                fileSql2 = getSqlSyntaxList(File2);
                fileSql3 = getSqlSyntaxList(File3);
                fileSql4 = getSqlSyntaxList(File4);


                for (String s:fileSql1) {
                    executeSql(stat, s);
                }
                for (String s:fileSql2) {
                    executeSql(stat, s);
                }
                for (String s:fileSql3) {
                    executeSql(stat, s);
                }
                for (String s:fileSql4) {
                    executeSql(stat, s);
                }
                stat.close();
            }
            finally
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
                t.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/javademo?"
                + "user=root&password=RootJJY" +
                "&useUnicode=true&characterEncoding=UTF8" +
                "&serverTimezone=GMT%2b8" +
                "&useSSL=true";

        return DriverManager.getConnection(url);
    }

    private static void executeSql(Statement statement, String line){
        try
        {
            boolean hasResultSet = statement.execute(line);
            if (hasResultSet)
                showResultSet(statement);
        }
        catch (SQLException ex)
        {
            for (Throwable e : ex)
                e.printStackTrace();
        }
    }


    private static Vector<String> getSqlSyntaxList(File file){
        Vector<String> result = new Vector<String>();

        FileReader fileReader;
        Scanner in;
        try {
            fileReader = new FileReader(file);
            in = new Scanner(fileReader);

            while (true){
                if (!in.hasNextLine())
                    break;
                String line = in.nextLine();
                if (line.trim().endsWith(";")) // remove trailing semicolon
                {
                    line = line.trim();
                    line = line.substring(0, line.length() - 1);
                    result.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  result;
    }

    private static void showResultSet(Statement stat) throws SQLException
    {
        ResultSet result = stat.getResultSet();
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++)
        {
            if (i > 1) System.out.print(", ");
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next())
        {
            //从1开始
            for (int i = 1; i <= columnCount; i++)
            {
                if (i > 1) System.out.print(", ");
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
        result.close();
    }

    private static File File1 = new File(ExecSQL.class.getResource("/dev/test1/Authors.sql").getFile());
    private static File File2 = new File(ExecSQL.class.getResource("/dev/test1/Books.sql").getFile());
    private static File File3 = new File(ExecSQL.class.getResource("/dev/test1/BooksAuthors.sql").getFile());
    private static File File4 = new File(ExecSQL.class.getResource("/dev/test1/Publishers.sql").getFile());

    private static Vector<String> fileSql1, fileSql2, fileSql3, fileSql4;
}

