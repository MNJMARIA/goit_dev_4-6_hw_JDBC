import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();

    private Connection connection;
    private Database() {
        try {
            String connectionUrl = "jdbc:h2:C:/Users/armyl/goit_dev_3_hw_database_test";
            connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Database getInstance()
    {
        return INSTANCE;
    }

    public int executeUpdate(String sql){
        try(Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();

            return -1;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void close(){
        try{
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
