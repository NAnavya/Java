import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
class JdbcDemo3{
    static{
        try{
         Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
}
    public static void main(String[] args) throws SQLException{
        try( Connectin con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","navya","navya")){
            if(con!=null){
                System.out.println("connection established");
            }
            else
            System.out.println("connection not established");
        }catch(Exception e){
            e.printStackTrace();
        }
       
      

    }
}