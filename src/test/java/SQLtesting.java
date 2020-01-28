import java.sql.*;
public class SQLtesting {
    public static void main(SQLtesting[] args) {
        Connection con = null;
        String url = "jdbs:mysql://localhost:3306/";
        String databaseName = "name_of_database";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url+databaseName, username, password);

            String sqlQuery = "Select * from table_name";
            Statement statement = con.createStatement();
            ResultSet result =statement.executeQuery(sqlQuery);

            result.next();
            //Column of the tables
            System.out.println(result.getString("emailaddress"));
            System.out.println(result.getString("emailaddress"));
            System.out.println(result.getString("emailaddress"));




        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(con != null) {
                con= null;
            }


        }

    }
}
