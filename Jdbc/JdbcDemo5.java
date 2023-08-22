import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.virtusa.PreparedStatementDemo;
class Demo5{
    static{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("class not found exception");
        }
    }
    public static vaid main(String[] args) throws SQLException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try(Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","navya","navya")){
            PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
            for(int i=0;i<4;i++){
                ps.setInt(1,Integer.parseInt(br.readLine()));
                ps.setString(2, br.readLine());
                br.addBatch();
            }
           br.executeBatch();
           int a=ps.executeUpdate();
           if(a>0){
            System.out.println("Successfully Inserted");
           }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
