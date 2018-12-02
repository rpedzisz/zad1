import java.sql.*;

public class App {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/rpedzisz";

   static final String USER = "rpedzisz";
   static final String PASS = "abc";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM Tabela";
      ResultSet result = stmt.executeQuery(sql);

      while(result.next()){
         int id  = rs.getInt("id");
         String dane1 = rs.getString("Dane1");
         String dane2 = rs.getString("Dane2");
		 
         System.out.println("ID: " + id);
         System.out.println(", Dane1: " + dane1);
         System.out.println(", Dane1: " + dane2);
		 
      }
      result.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
 }
}

