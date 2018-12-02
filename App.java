import java.sql.*;

public class App {
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/baza";

   static final String USER = "rpedzisz";
   static final String PASS = "abc";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
	  System.out.println("Przed blokiem try"); 
   try{
      Class.forName(JDBC_DRIVER);

      System.out.println("Łączenie...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
	   
stmt.executeQuery("CREATE TABLE Tabela (id int, Dane1 varchar(255), Dane2 varchar(255));"); // Stworzenie tabeli
stmt.executeQuery("INSERT INTO Tabela  (id, Dane1, Dane2) VALUES (1, 'jakiesdane1', 'jakiesdane2');"); //dodanie jakichś danych	   
	   	        
ResultSet result = stmt.executeQuery("SELECT * FROM Tabela"); //select danych

      while(result.next()){
         int id  = result.getInt("id");
         String dane1 = result.getString("Dane1");
         String dane2 = result.getString("Dane2");
		 
         System.out.println("ID: " + id); // wyświetlenie danych
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

