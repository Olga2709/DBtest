import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.*;
public class SQLtesting {
    public static void main(SQLtesting[] args) {

        //TestData
        String emailaddress = "blahblah";
        String zipcode = "blahblah";
        String firstname = "blahblah";
        String lastname = "blahblah";


        //Input testdData using Selenium
        WebDriver driver = new FirefoxDriver();
        driver.get("any_url");
        driver.findElement(By.xpath("___________")).sendKeys(emailaddress);
        driver.findElement(By.xpath("___________")).sendKeys(zipcode);
        driver.findElement(By.xpath("___________")).sendKeys(firstname);
        driver.findElement(By.xpath("___________")).sendKeys(lastname);
        driver.findElement(By.xpath("signupbutton"));


        //Connecting to DataBase
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
            System.out.println(result.getString("zipcode"));
            System.out.println(result.getString("firstname"));
            System.out.println(result.getString("lastname"));



            //DataBase Testing

            if(! result.getString("emailaddress").equals(emailaddress));
            System.out.println("Wrong email address");

            if(! result.getString("zipcode").equals(zipcode));
            System.out.println("Wrong zipcode ");

            if(! result.getString("firstname").equals(firstname));
            System.out.println("Wrong firstname");

            if(! result.getString("lastname").equals(lastname));
            System.out.println("Wrong lastname");




        }catch (Exception e) {
            System.out.println(e);
        }finally {
            if(con != null) {
                con= null;
            }


        }

    }
}
