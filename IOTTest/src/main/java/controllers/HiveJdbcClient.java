package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import org.apache.hive.jdbc.HiveDriver;
/**
 * Created by rahul.pant on 27/12/17.
 */
@WebServlet(name = "HiveJDBC", urlPatterns = "/sendUpdate")

public class HiveJdbcClient extends HttpServlet {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("send update1");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
//            resp.getWriter().write("ClassNotFoundException");
            e.printStackTrace();
            System.exit(1);
        }

        resp.getWriter().write("send update2");
        try {
            resp.getWriter().write("send update3");
            //replace "hive" here with the name of the user the queries should run as
            Connection con = DriverManager.getConnection("jdbc:hive2://url-here.com:8080/default", "", "");
            Statement stmt = con.createStatement();
            String tableName = "testHiveDriverTable";
            stmt.execute("drop table if exists " + tableName);
            stmt.execute("create table " + tableName + " (key int, value string)");
            // show tables         
            // String sql = "show tables '" + tableName + "'";
            String sql = ("show tables");
            ResultSet res = stmt.executeQuery(sql);
            if (res.next()) {
                System.out.println(res.getString(1));
            }
        }catch (SQLException e)
        {
            resp.getWriter().write("send update4");
        }
        resp.getWriter().write("send update5");
    }

}
