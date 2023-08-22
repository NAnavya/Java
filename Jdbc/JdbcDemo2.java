import java.util.*;
class JdbcDemo2{

    public static void main(String[] args)throws SQLException{
        try{
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
       
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","navya","navya");
            if(con!=null)
             System.out.println("connection established");
             else
             System.out.println("connection not established");

     
        Statement st=con.createStatement();
        st.execute("create table emp(id number,empname varchar(20),age number,sal varchar(20))");
        st.execute("drop table emp");
        int recordsupdated=st.executeUpdate("insert into emp values(1,"navya",21,15000)");
         System.out.println(recordsupdated); //1
         int recordsupdated1=st.executeUpdate("delete from emp where id=1");
         System.out.println(recordsupdated1); //2
         st.executeUpdate("insert into emp values(1,"navya",21,15000)");
         st.executeUpdate("insert into emp values(2,"divya",21,15000)");
         st.executeUpdate("insert into emp values(3,"bhavya",21,15000)");
         st.executeUpdate("insert into emp values(4,"kavya",21,15000)");
         ResultSet rs=st.executeQuery("select * from emp");
         while(rs.next()){
            int empid=rs.get(1);
            String empname=rs.get(2);
            int age=rs.get("age");
            String sal=rs.get("sal");
            System.out.println(empid+ " "+empname+" "+age+" "+sal);
         }
        con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }


    }
}