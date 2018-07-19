package by.mytaxi.demo;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.*;
import java.sql.*;
import java.util.Properties;

public class TaxiFirstConnection {
    private static Logger log = LogManager.getLogger(TaxiFirstConnection.class);


    public static void main(String[] args) {

        File file = new File("D:\\123\\.gitignore");
        String a = new String("out/*");
        Writer


        try { Connection connection= getConnection();
            PreparedStatement statement= connection.prepareStatement(DataBaseQueries.SELECT_SIFTS_PROCIDURE);


                 ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    log.info(rs.getString("id"));
                }




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        Properties info = new Properties();
        try (InputStream inputStream= new FileInputStream("C:\\Users\\User\\IdeaProjects\\mytaxi_demo\\src\\main\\resources\\database.properties")) {
            info.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(info.getProperty("jdbc.url"),
                                            info.getProperty("jdbc.user"),
                                            info.getProperty("jdbc.password"));
    }

}