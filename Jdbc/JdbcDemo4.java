import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
//Preapared Statement
class JdbcDemo4{
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String USERNAME="navya";
    private static final String PASSWORD="navya";
    private static final String URL="jdbc:mysql://localhost:3306/db1";
    static{
        try{
            Class.forName(Driver);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try(Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD)){
           PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
           //or
           Statement st=con.createStatement();
           st.executeUpdate("insert into emp values("+id+",'"+name+"'+'"+add+"')");
            int id=Integer.parseInt(br.readLine());
            String name=br.readLine();
            String add=br.readLine();
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,add);
            int update=st.executeUpdate();
            if(update>0){
                System.out.println("successfully inserted");
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }

    }

}