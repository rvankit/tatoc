package pages;

import java.sql.*;

public class ConnMysql {

    String driver= "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://10.0.1.86/tatoc";
    String u_name = "tatocuser";
    String pass = "tatoc01";
    Connection conn;
    Statement statement;
    ResultSet rs;
    String id = "";
    String name= "";
    String passKey = "";

    public String getId(String symbol) {

        String query ="select id from identity where Symbol='"+ symbol +"'";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, u_name, pass);
            statement = conn.prepareStatement(query);
            rs = statement.executeQuery(query);
            while(rs.next()){
                id = rs.getString(1);
                System.out.println("Symbol: "+rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return symbol;
    }

    public String getName() {
        String query1 ="select name, passkey from credentials where id='"+ id +"'";

        try {
            rs = statement.executeQuery(query1);
            while (rs.next()){
                name = rs.getString(1);
                System.out.println("Name: "+rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  name;
    }

    public String getPassKey() {
        String query2 ="select passkey from credentials where id='"+ id +"'";
        try {
            rs = statement.executeQuery(query2);
            while (rs.next()){
                passKey = rs.getString(1);
                System.out.println("PassKey: "+rs.getString(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  passKey;
    }
}